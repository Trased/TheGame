package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;

public class Collision {
    RefLinks ref;
    private boolean enemCol = false;
    Rectangle heroAttackBounds, heroNormalBounds, enemAttackBounds, enemNormalBounds;
    public Collision(RefLinks reflink){
        ref = reflink;
        heroAttackBounds = new Rectangle(0,0,38,38);
        heroNormalBounds  = new Rectangle(0,0,38,38);
        enemAttackBounds  = new Rectangle(0,0,38,38);
        enemNormalBounds  = new Rectangle(0,0,38,38);
    }
    public boolean GetEnemCol(){
        return enemCol;
    }
    public void checkTile(Character entity) {
        if(enemCol){
            entity.collisionOn = true;
            enemCol = false;
        }
        int entityXLeftBorder = (int) (entity.GetX() + entity.normalBounds.x);
        int entityXNearLeftBorder = (int) (entity.GetX() + entity.normalBounds.x)+10;
        int entityXRightBorder = (int) (entity.GetX() + entity.normalBounds.x + entity.normalBounds.width)+10;
        int entityXNearRightBorder = (int) (entity.GetX() + entity.normalBounds.x + entity.normalBounds.width);
        int entityYTopBorder = (int) (entity.GetY() + entity.normalBounds.y);
        int entityYNearTopBorder = (int) (entity.GetY() + entity.normalBounds.y) + 10;
        int entityYBottomBorder = (int) (entity.GetY() + entity.normalBounds.y + entity.normalBounds.height)+5;
        int entityYNearBottomBorder = (int) (entity.GetY() + entity.normalBounds.y + entity.normalBounds.height);


        int entityColXLeftBorder = (int) ((entityXLeftBorder - entity.speed) / 32);
        int entityColXNearLeftBorder = (int) ((entityXNearLeftBorder - entity.speed) / 32);
        int entityColXRightBorder = (int) ((entityXRightBorder - entity.speed) / 32);
        int entityColXNearRightBorder = (int) ((entityXNearRightBorder - entity.speed) / 32);
        int entityColYTopBorder = (int) ((entityYTopBorder - entity.speed) / 32);
        int entityColYNearTopBorder = (int) ((entityYNearTopBorder - entity.speed) / 32);
        int entityColYBottomBorder = (int) ((entityYBottomBorder - entity.speed) / 32);
        int entityColYNearBottomBorder = (int) ((entityYNearBottomBorder - entity.speed) / 32);


        if (ref.GetKeyManager().up) {
            if (ref.GetMap().GetObject(entityColXLeftBorder, entityColYTopBorder).IsSolid() &&
                ref.GetMap().GetObject(entityColXNearLeftBorder, entityColYTopBorder).IsSolid() ||
                ref.GetMap().GetObject(entityColXNearRightBorder, entityColYTopBorder).IsSolid() &&
                ref.GetMap().GetObject(entityColXRightBorder, entityColYTopBorder).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().down) {
            if (ref.GetMap().GetObject(entityColXLeftBorder, entityColYBottomBorder).IsSolid() &&
                ref.GetMap().GetObject(entityColXNearLeftBorder, entityColYBottomBorder).IsSolid() ||
                ref.GetMap().GetObject(entityColXNearRightBorder, entityColYBottomBorder).IsSolid() &&
                ref.GetMap().GetObject(entityColXRightBorder, entityColYBottomBorder).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().right) {
            if (ref.GetMap().GetObject(entityColXRightBorder, entityColYTopBorder).IsSolid() &&
                ref.GetMap().GetObject(entityColXRightBorder, entityColYNearTopBorder).IsSolid() ||
                ref.GetMap().GetObject(entityColXRightBorder, entityColYNearBottomBorder).IsSolid() &&
                ref.GetMap().GetObject(entityColXRightBorder, entityColYBottomBorder).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().left) {
            if (ref.GetMap().GetObject(entityColXLeftBorder, entityColYTopBorder).IsSolid() &&
                ref.GetMap().GetObject(entityColXLeftBorder, entityColYNearTopBorder).IsSolid() ||
                ref.GetMap().GetObject(entityColXLeftBorder, entityColYNearBottomBorder).IsSolid() &&
                ref.GetMap().GetObject(entityColXLeftBorder, entityColYBottomBorder).IsSolid()) {
                entity.collisionOn = true;
            }
        }
    }
    public void checkEntity(Hero hero, NPC[] enem){
        int heroAttackBoundsX = (int) (hero.GetX() + hero.attackBounds.x);
        int heroAttackBoundsY = (int) (hero.GetY() + hero.attackBounds.y);
        int heroNormalBoundsX = (int) (hero.GetX() + hero.normalBounds.x);
        int heroNormalBoundsY = (int) (hero.GetY() + hero.normalBounds.y);
        int enemAttackBoundsX, enemAttackBoundsY,enemNormalBoundsX, enemNormalBoundsY;
        heroAttackBounds.setLocation(heroAttackBoundsX,heroAttackBoundsY);
        heroNormalBounds.setLocation(heroNormalBoundsX,heroNormalBoundsY);
        for(int i = 0; i < enem.length; i++) {
            if (enem[i] != null) {
                enemAttackBoundsX = (int) (enem[i].GetX() + enem[i].attackBounds.x);
                enemAttackBoundsY = (int) (enem[i].GetY() + enem[i].attackBounds.y);
                enemNormalBoundsX = (int) (enem[i].GetX() + enem[i].normalBounds.x);
                enemNormalBoundsY = (int) (enem[i].GetY() + enem[i].normalBounds.y);
                enemAttackBounds.setLocation(enemAttackBoundsX, enemAttackBoundsY);
                enemNormalBounds.setLocation(enemNormalBoundsX, enemNormalBoundsY);
                if (heroAttackBounds.intersects(enemNormalBounds)) {
                    if (hero.checkAttack) {
                        enem[i].Damaged(hero);
                        if (enem[i].life <= 0) {
                            enem[i] = null;
                        }
                    }
                }

                if(heroNormalBounds.intersects(enemNormalBounds)){
                    enemCol =true;
                    hero.SetX(hero.GetX()-1);
                    hero.SetY(hero.GetY()-1);
                }
            }
        }
    }
}