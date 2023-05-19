package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class NPC extends Character {
    protected final int damage;
    protected int move;
    protected boolean playerNearby = false;
    protected int counter;
    protected float movingAreaXL;
    protected float movingAreaXR;
    protected float movingAreaYU;
    protected float movingAreaYD;
    protected BufferedImage image;
    protected int SPRITE_COUNTER = 1;
    protected int SPRITE_NUM = 1;
    protected boolean attack = false;
    protected Rectangle atBounds;
    private final Rectangle intBounds;

    public NPC(RefLinks refLink, float x, float y, int damage)
    {
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        this.damage= damage;
        speed = 1f;
        move = 1;

        normalBounds.x = 35;
        normalBounds.y = 35;
        normalBounds.width = 24;
        normalBounds.height = 40;

        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 38;
        attackBounds.height = 38;

        atBounds = new Rectangle((int) x + attackBounds.x, (int) y+attackBounds.y, attackBounds.width, attackBounds.height);
        intBounds= new Rectangle((int)x,(int)y,60,60);
    }
    public boolean PlayerInteract(){
        return intBounds.intersects(GetHero().getNormalBounds());
    }

    public int RandomNumber(){
        return (int) (Math.random()* 3.99);
    }

    public void Damaged(Hero player){
        this.life -= player.getDamage();
    }

    protected void UpCounter(boolean playerNearby){
        SPRITE_COUNTER++;
        counter++;
        if(SPRITE_COUNTER > 8){
            if(SPRITE_NUM == 1){
                SPRITE_NUM = 2;
            }
            else if(SPRITE_NUM == 2) {
                SPRITE_NUM = 3;
            }else if(SPRITE_NUM == 3){
                SPRITE_NUM = 1;
            }
            attack = SPRITE_COUNTER == 9 && SPRITE_NUM == 2;

            SPRITE_COUNTER = 0;
        }
        if(!playerNearby) {
            if (counter > 120) {
                move = RandomNumber();
                counter = 0;
            }
        }
    }

    protected Hero GetHero(){
        return refLink.GetGame().GetPlayState().GetHero();
    }

    protected void CheckForPlayer(){
        if(GetHero().GetX() > movingAreaXL &&
                GetHero().GetX() < movingAreaXR &&
                GetHero().GetY() > movingAreaYU &&
                GetHero().GetY() < movingAreaYD){
            playerNearby = true;
        }
    }
    public void NPCMove(){
        xMove = 0;
        yMove = 0;
        collisionOn = false;
        NPCCheckTile();
        if(!collisionOn) {
            if(playerNearby){
                if(GetHero().GetY()-48 > this.GetY()){

                    yMove = +speed;
                    move = 1;
                }else if(GetHero().GetY()+40 < this.GetY()){
                    yMove = -speed;
                    move = 0;
                }else if(GetHero().GetX()+40 < this.GetX()){
                    xMove = -speed;
                    move = 2;
                }else if(GetHero().GetX()-40 > this.GetX()){
                    xMove = +speed;
                    move = 3;
                }else{
                    yMove = 0;
                    xMove = 0;
                }
            }else {
                if (move == 0) { // UP
                    if (this.y - speed <= movingAreaYU) {
                        move = 1;
                        counter = 40;
                        yMove = +speed;
                    } else {
                        yMove = -speed;
                    }
                }
                if (move == 1) { // DOWN
                    if (this.y + speed >= movingAreaYD) {
                        move = 0;
                        counter = 40;
                        yMove = -speed;
                    } else {
                        yMove = speed;
                    }
                }
                if (move == 2) { // LEFT
                    if (this.x - speed <= movingAreaXL) {
                        move = 3;
                        counter = 40;
                        xMove = +speed;
                    } else {
                        xMove = -speed;
                    }
                }
                if (move == 3) { // RIGHT
                    if (this.x + speed >= movingAreaXR) {
                        move = 2;
                        counter = 40;
                        xMove = -speed;
                    } else {
                        xMove = speed;
                    }
                }
            }
        }
    }
    public void NPCCheckTile(){
        int entityXLeftBorder = (int) (this.GetX() + this.normalBounds.x);
        int entityXNearLeftBorder = (int) (this.GetX() + this.normalBounds.x)+10;
        int entityXRightBorder = (int) (this.GetX() + this.normalBounds.x + this.normalBounds.width);
        int entityXNearRightBorder = (int) (this.GetX() + this.normalBounds.x + this.normalBounds.width);
        int entityYTopBorder = (int) (this.GetY() + this.normalBounds.y);
        int entityYNearTopBorder = (int) (this.GetY() + this.normalBounds.y) + 10;
        int entityYBottomBorder = (int) (this.GetY() + this.normalBounds.y + this.normalBounds.height)+5;
        int entityYNearBottomBorder = (int) (this.GetY() + this.normalBounds.y + this.normalBounds.height);


        int entityColXLeftBorder = (int) ((entityXLeftBorder - this.speed) / 32);
        int entityColXNearLeftBorder = (int) ((entityXNearLeftBorder - this.speed) / 32);
        int entityColXRightBorder = (int) ((entityXRightBorder - this.speed) / 32);
        int entityColXNearRightBorder = (int) ((entityXNearRightBorder - this.speed) / 32);
        int entityColYTopBorder = (int) ((entityYTopBorder - this.speed) / 32);
        int entityColYNearTopBorder = (int) ((entityYNearTopBorder - this.speed) / 32);
        int entityColYBottomBorder = (int) ((entityYBottomBorder - this.speed) / 32);
        int entityColYNearBottomBorder = (int) ((entityYNearBottomBorder - this.speed) / 32);


        if (move == 0) {
            if (refLink.GetMap().GetObject(entityColXLeftBorder, entityColYTopBorder).IsSolid() &&
                    refLink.GetMap().GetObject(entityColXNearLeftBorder, entityColYTopBorder).IsSolid() ||
                    refLink.GetMap().GetObject(entityColXNearRightBorder, entityColYTopBorder).IsSolid() &&
                    refLink.GetMap().GetObject(entityColXRightBorder, entityColYTopBorder).IsSolid()) {
                this.collisionOn = true;
            }
        }
        if (move == 1) {
            if (refLink.GetMap().GetObject(entityColXLeftBorder, entityColYBottomBorder).IsSolid() &&
                    refLink.GetMap().GetObject(entityColXNearLeftBorder, entityColYBottomBorder).IsSolid() ||
                    refLink.GetMap().GetObject(entityColXNearRightBorder, entityColYBottomBorder).IsSolid() &&
                    refLink.GetMap().GetObject(entityColXRightBorder, entityColYBottomBorder).IsSolid()) {
                this.collisionOn = true;
            }
        }
        if (move == 2) {
            if (refLink.GetMap().GetObject(entityColXLeftBorder, entityColYTopBorder).IsSolid() &&
                    refLink.GetMap().GetObject(entityColXLeftBorder, entityColYNearTopBorder).IsSolid() ||
                    refLink.GetMap().GetObject(entityColXLeftBorder, entityColYNearBottomBorder).IsSolid() &&
                            refLink.GetMap().GetObject(entityColXLeftBorder, entityColYBottomBorder).IsSolid()) {
                this.collisionOn = true;
            }
        }
        if (move == 3) {
            if (refLink.GetMap().GetObject(entityColXRightBorder, entityColYTopBorder).IsSolid() &&
                    refLink.GetMap().GetObject(entityColXRightBorder, entityColYNearTopBorder).IsSolid() ||
                    refLink.GetMap().GetObject(entityColXRightBorder, entityColYNearBottomBorder).IsSolid() &&
                    refLink.GetMap().GetObject(entityColXRightBorder, entityColYBottomBorder).IsSolid()) {
                this.collisionOn = true;
            }
        }
    }
    public void DrawHealth(Graphics g){
        for(int i = 0; i< life/10; i++){
            g.drawImage(heart, (int)x+20+i*21, (int)y, 20, 20, null);
        }
    }
    @Override
    public void Draw(Graphics g) {
        // Draw enemy sprite
        g.drawImage(image, (int)x, (int)y, width, height, null);
/*
        g.setColor(Color.cyan);
        g.fillRect((int)(movingAreaXL),(int)(movingAreaYU),(int)400, (int)400);


        g.setColor(Color.green);
        g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
/*

        g.setColor(Color.cyan);
        g.fillRect((int)(x + attackBounds.x), (int)(y + attackBounds.y), attackBounds.width, attackBounds.height);
 */
    }
}
