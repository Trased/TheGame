package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

public class Warrior extends NPC {
    private boolean attacking;
    public Warrior(RefLinks refLink, float x, float y, int damage) {
        super(refLink, x, y, damage);
        life = 30;
        movingAreaXL = x - 200;
        movingAreaXR = x + 200;
        movingAreaYU = y - 200;
        movingAreaYD = y + 200;
    }
    private boolean checkAttackSprite(){
        return image == Assets.EnemyTAttackUpTwo || image == Assets.EnemyTAttackDownTwo || image == Assets.EnemyTAttackLeftTwo || image == Assets.EnemyTAttackRightTwo;
    }
    @Override
    public void Update() {
        playerNearby = false;
        CheckForPlayer();
        NPCMove();
        Move();
        atBounds.setLocation((int) x + attackBounds.x, (int) y+attackBounds.y);
        attacking = attack && atBounds.intersects(GetHero().getNormalBounds());
        if(move == 0){ // UP
            if (SPRITE_NUM == 1) {
                if(attacking){
                    image = Assets.EnemyTAttackUpOne;
                }else {
                    image = Assets.EnemyTUpOne;
                }
            }
            if (SPRITE_NUM == 2) {
                if(attacking){
                    image = Assets.EnemyTAttackUpTwo;
                }else {
                    image = Assets.EnemyTUpTwo;
                }
            }
            if (SPRITE_NUM == 3) {
                if(attacking){
                    image = Assets.EnemyTAttackUpTwo;
                }else {
                    image = Assets.EnemyTUpTwo;
                }
            }
        }
        if(move == 1 ){ // DOWN
            if (SPRITE_NUM == 1) {
                if(attacking){
                    image = Assets.EnemyTAttackDownOne;
                }else {
                    image = Assets.EnemyTDownOne;
                }
            }
            if (SPRITE_NUM == 2) {
                if(attacking){
                    image = Assets.EnemyTAttackDownTwo;
                }else {
                    image = Assets.EnemyTDownTwo;
                }
            }
            if (SPRITE_NUM == 3) {
                if(attacking){
                    image = Assets.EnemyTAttackDownTwo;
                }else {
                    image = Assets.EnemyTDownTwo;
                }
            }
        }
        if(move == 2 ) // LEFT
        {
            if (SPRITE_NUM == 1) {
                if(attacking){
                    image = Assets.EnemyTAttackLeftOne;
                }else {
                    image = Assets.EnemyTLeftOne;
                }
            }
            if (SPRITE_NUM == 2) {
                if(attacking){
                    image = Assets.EnemyTAttackLeftTwo;
                }else {
                    image = Assets.EnemyTLeftTwo;
                }
            }
            if (SPRITE_NUM == 3) {
                if(attacking){
                    image = Assets.EnemyTAttackLeftTwo;
                }else {
                    image = Assets.EnemyTLeftTwo;
                }
            }
        }
        if(move == 3 ) { // RIGHT
            if (SPRITE_NUM == 1) {
                if (attacking) {
                    image = Assets.EnemyTAttackRightOne;
                } else {
                    image = Assets.EnemyTRightOne;
                }
            }
            if (SPRITE_NUM == 2) {
                if (attacking) {
                    image = Assets.EnemyTAttackRightTwo;
                } else {
                    image = Assets.EnemyTRightTwo;
                }
            }
            if (SPRITE_NUM == 3) {
                if (attacking) {
                    image = Assets.EnemyTAttackRightTwo;
                } else {
                    image = Assets.EnemyTRightTwo;
                }
            }
        }
        if(attack && atBounds.intersects(GetHero().getNormalBounds()) && checkAttackSprite()){
            GetHero().HeroDamage(damage);
        }
            UpCounter(playerNearby);
    }
}
