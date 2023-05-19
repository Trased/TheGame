package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

public class Archer extends NPC {
    private boolean attacking = false;
    private int oneTime = 0;
    private int direction;
    private Arrow[] arr;
    private boolean intersect;
    private Rectangle attackBoundsLR = new Rectangle(-500,30,1000,35);
    private Rectangle attackBoundsUD = new Rectangle(30,-500,35,1000);
    private Rectangle atBoundsUD = new Rectangle(0,0,attackBoundsUD.width, attackBoundsUD.height);
    private Rectangle atBoundsLR= new Rectangle(0,0,attackBoundsLR.width, attackBoundsLR.height);
    public Archer(RefLinks refLink, float x, float y, int damage) {
        super(refLink, x, y, damage);
        image = Assets.EnemyOLeftOne;
        attackBounds.setBounds(0,0,0,0);
        life = 20;
        arr = new Arrow[5];
        movingAreaXL = x - 500;
        movingAreaXR = x + 500;
        movingAreaYU = y - 500;
        movingAreaYD = y + 500;
    }
    private boolean checkAttackSprite(){
        return image == Assets.EnemyOAttackUpTwo || image == Assets.EnemyOAttackDownTwo || image == Assets.EnemyOAttackLeftTwo || image == Assets.EnemyOAttackRightTwo;
    }
    @Override
    public void Update() {
        for(int i = 0; i < arr.length; i++){
            if( arr[i] != null){
                arr[i].Update();
                if(arr[i].IsHit()){
                    arr[i] = null;
                }
            }
        }
        playerNearby = false;
        CheckForPlayer();
        NPCMove();
        Move();

        atBoundsUD.setLocation((int) x + attackBoundsUD.x, (int) y+attackBoundsUD.y);
        atBoundsLR.setLocation((int) x + attackBoundsLR.x, (int) y+attackBoundsLR.y);
        intersect = (atBoundsUD.intersects(GetHero().getNormalBounds()) || atBoundsLR.intersects(GetHero().getNormalBounds()));
        attacking = attack && intersect;
        if(move == 0){ // UP
            if (SPRITE_NUM == 1) {
                if(attacking){
                    image = Assets.EnemyOAttackUpOne;
                }else {
                    image = Assets.EnemyOUpOne;
                }
            }
            if (SPRITE_NUM == 2) {
                if(attacking){
                    image = Assets.EnemyOAttackUpTwo;
                }else {
                    image = Assets.EnemyOUpTwo;
                }
            }
            if (SPRITE_NUM == 3) {
                if(attacking){
                    image = Assets.EnemyOAttackUpTwo;
                }else {
                    image = Assets.EnemyOUpTwo;
                }
            }
        }
        if(move == 1 ){ // DOWN
            if (SPRITE_NUM == 1) {
                if(attacking){
                    image = Assets.EnemyOAttackDownOne;
                }else {
                    image = Assets.EnemyODownOne;
                }
            }
            if (SPRITE_NUM == 2) {
                if(attacking){
                    image = Assets.EnemyOAttackDownTwo;
                }else {
                    image = Assets.EnemyODownTwo;
                }
            }
            if (SPRITE_NUM == 3) {
                if(attacking){
                    image = Assets.EnemyOAttackDownTwo;
                }else {
                    image = Assets.EnemyODownTwo;
                }
            }
        }
        if(move == 2 ) // LEFT
        {
            if (SPRITE_NUM == 1) {
                if(attacking){
                    image = Assets.EnemyOAttackLeftOne;
                }else {
                    image = Assets.EnemyOLeftOne;
                }
            }
            if (SPRITE_NUM == 2) {
                if(attacking){
                    image = Assets.EnemyOAttackLeftTwo;
                }else {
                    image = Assets.EnemyOLeftTwo;
                }
            }
            if (SPRITE_NUM == 3) {
                if(attacking){
                    image = Assets.EnemyOAttackLeftTwo;
                }else {
                    image = Assets.EnemyOLeftTwo;
                }
            }
        }
        if(move == 3 ) { // RIGHT
            if (SPRITE_NUM == 1) {
                if (attacking) {
                    image = Assets.EnemyOAttackRightOne;
                } else {
                    image = Assets.EnemyORightOne;
                }
            }
            if (SPRITE_NUM == 2) {
                if (attacking) {
                    image = Assets.EnemyOAttackRightTwo;
                } else {
                    image = Assets.EnemyORightTwo;
                }
            }
            if (SPRITE_NUM == 3) {
                if (attacking) {
                    image = Assets.EnemyOAttackRightTwo;
                } else {
                    image = Assets.EnemyORightTwo;
                }
            }
        }
        if(attack && (atBoundsUD.intersects(GetHero().getNormalBounds()) || atBoundsLR.intersects(GetHero().getNormalBounds())) && checkAttackSprite()){
            oneTime++;
            if(oneTime > 15) {
                for(int i = 0; i < arr.length; i++){
                    if(arr[i] == null) {
                        arr[i] = new Arrow(refLink, x+32, y+32, 32, 32, move);
                        break;
                    }
                }
                oneTime = 0;
            }
        }
        UpCounter(playerNearby);
    }
    @Override
    public void NPCMove(){
        xMove = 0;
        yMove = 0;
        collisionOn = false;
        NPCCheckTile();
        if(!collisionOn) {
            if(playerNearby) {
                if (!intersect) {
                    if (GetHero().GetY() - 48 > this.GetY()) {
                        yMove = +speed;
                        move = 1;
                    } else if (GetHero().GetY() + 40 < this.GetY()) {
                        yMove = -speed;
                        move = 0;
                    } else if (GetHero().GetX() + 40 < this.GetX()) {
                        xMove = -speed;
                        move = 2;
                    } else if (GetHero().GetX() - 40 > this.GetX()) {
                        xMove = +speed;
                        move = 3;
                    } else {
                        yMove = 0;
                        xMove = 0;
                    }
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
    @Override
    public void Draw(Graphics g) {
        // Draw enemy sprite
        g.drawImage(image, (int) x, (int) y, width, height, null);
        for (Arrow arrow : arr) {
            if (arrow != null) {
                arrow.Draw(g);
            }
        }
    }
}
