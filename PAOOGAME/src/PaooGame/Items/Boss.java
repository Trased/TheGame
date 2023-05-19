package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

public class Boss extends NPC{
    protected boolean attacking;
    private final int id;
    public Boss(RefLinks refLink, float x, float y, int damage,int id) {
        super(refLink, x, y, damage);
        switch (id) {
            case 0 -> speed = 3f;
            case 1 -> speed = 3.5f;
            case 2 -> speed = 4f;
        }
        life = 50;
        movingAreaXL = x - 900;
        movingAreaXR = x + 900;
        movingAreaYU = y - 900;
        movingAreaYD = y + 900;
        this.id = id;
    }
    private boolean checkAttackSprite(){
        return image == Assets.BossAttackLeftTwo[id] || image == Assets.BossAttackRightTwo[id];
    }

    @Override
    public void Update() {
        playerNearby = false;
        CheckForPlayer();
        NPCMove();
        Move();
        atBounds.setLocation((int) x + attackBounds.x, (int) y+attackBounds.y);
        attacking = attack && atBounds.intersects(GetHero().getNormalBounds());
        if(move == 0 || move == 3){ // UP-Right
            if (SPRITE_NUM == 1) {
                if(attacking){
                    image = Assets.BossAttackRightOne[id];
                }else {
                    image = Assets.BossRightOne[id];
                }
            }
            if (SPRITE_NUM == 2) {
                if(attacking){
                    image = Assets.BossAttackRightTwo[id];
                }else {
                    image = Assets.BossRightTwo[id];
                }
            }
            if (SPRITE_NUM == 3) {
                if(attacking){
                    image = Assets.BossAttackRightThree[id];
                }else {
                    image = Assets.BossRightThree[id];
                }
            }
        }
        if(move == 1 || move == 2 ){ // DOWN - LEFT
            if (SPRITE_NUM == 1) {
                if(attacking){
                    image = Assets.BossAttackLeftOne[id];
                }else {
                    image = Assets.BossLeftOne[id];
                }
            }
            if (SPRITE_NUM == 2) {
                if(attacking){
                    image = Assets.BossAttackLeftTwo[id];
                }else {
                    image = Assets.BossLeftTwo[id];
                }
            }
            if (SPRITE_NUM == 3) {
                if(attacking){
                    image = Assets.BossAttackLeftThree[id];
                }else {
                    image = Assets.BossLeftThree[id];
                }
            }
        }
        if(attack && atBounds.intersects(GetHero().getNormalBounds()) && checkAttackSprite()){
            GetHero().HeroDamage(damage);
        }
        UpCounter(playerNearby);
    }
}
