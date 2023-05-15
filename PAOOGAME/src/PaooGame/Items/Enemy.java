package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.Observer.PlayerLocationObserver;
import PaooGame.RefLinks;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends Character {
    private int damage;
    private int move;
    private int counter;
    private final float movingAreaXL;
    private final float movingAreaXR;
    private final float movingAreaYU;
    private final float movingAreaYD;
    private BufferedImage image;
    private int SPRITE_COUNTER = 1;
    private int SPRITE_NUM = 1;

    public Enemy(RefLinks refLink, float x, float y, int damage)
    {
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        this.damage= damage;
        speed = 1f;
        move = 1;
        movingAreaXL = x - 100;
        movingAreaXR = x + 100;
        movingAreaYU = y - 100;
        movingAreaYD = y + 100;
        image = Assets.EnemyOLeftOne;
        normalBounds.x = 35;
        normalBounds.y = 35;
        normalBounds.width = 24;
        normalBounds.height = 40;

        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 38;
        attackBounds.height = 38;

    }

    public int RandomNumber(){
        return (int) (Math.random()* 3.99);
    }


    @Override
    public void Update() {
        letsMove();
        Move();
        if(move == 0){ // UP
            if (SPRITE_NUM == 1) {
                image = Assets.EnemyOUpOne;
            }
            if (SPRITE_NUM == 2) {
                image = Assets.EnemyOUpTwo;
            }
            if (SPRITE_NUM == 3) {
                image = Assets.EnemyOUpThree;
            }
        }
        if(move == 1 ){ // DOWN
            if (SPRITE_NUM == 1) {
                image = Assets.EnemyODownOne;
            }
            if (SPRITE_NUM == 2) {
                image = Assets.EnemyODownTwo;
            }
            if (SPRITE_NUM == 3) {
                image = Assets.EnemyODownThree;
            }
        }
        if(move == 2 ) // LEFT
        {
            if (SPRITE_NUM == 1) {
                image = Assets.EnemyOLeftOne;
            }
            if (SPRITE_NUM == 2) {
                image = Assets.EnemyOLeftTwo;
            }
            if (SPRITE_NUM == 3) {
                image = Assets.EnemyOLeftThree;
            }
        }
        if(move == 3 ) { // RIGHT
            if (SPRITE_NUM == 1) {
                image = Assets.EnemyORightOne;
            }
            if (SPRITE_NUM == 2) {
                image = Assets.EnemyORightTwo;
            }
            if (SPRITE_NUM == 3) {
                image = Assets.EnemyORightThree;
            }
        }

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
            SPRITE_COUNTER = 0;
        }
        if(counter > 120){
            move = RandomNumber();
            counter = 0;
        }


    }
    @Override
    public void Draw(Graphics g) {
        // Draw enemy sprite
        g.drawImage(image, (int)x, (int)y, width, height, null);
    }

    public void Attack(Hero player) {
        player.setHealth(damage);
    }
    public void Damaged(Hero player){
        this.life -= player.getDamage();
    }
    public int getMove(){
        return move;
    }

    public void letsMove(){
        xMove = 0;
        yMove = 0;
        collisionOn = false;
        checkTile();
        if(!collisionOn) {
            if (move == 0) { // UP
                if(this.y - speed <= movingAreaYU) {
                    move = 1;
                    counter = 40;
                    yMove += speed;
                }else {
                    yMove = -speed;
                }
            }
            if(move == 1) { // DOWN
                if(this.y + speed >= movingAreaYD){
                    move = 0;
                    counter = 40;
                    yMove = -speed;
                }else {
                    yMove = speed;
                }
            }
            if(move == 2) { // LEFT
                if(this.x - speed <= movingAreaXL){
                    move = 3;
                    counter = 40;
                    xMove = +speed;
                }else{
                    xMove = -speed;
                }
            }
            if(move == 3) { // RIGHT
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
    public void checkTile(){
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

}
