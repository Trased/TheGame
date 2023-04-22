package PaooGame.Items;

import PaooGame.Maps.Map;
import PaooGame.RefLinks;

import static java.lang.Math.sqrt;

public class collisionChecker {
    RefLinks ref;
    public collisionChecker(RefLinks reflink){
        ref = reflink;
    }
    public void checkTile(Character entity) {
        int entityLeftOne = (int) (entity.GetX() + entity.normalBounds.x);
        int entityLeftTwo = entityLeftOne + 5;
        int entityRightOne = (int) (entity.GetX() + entity.normalBounds.x + entity.normalBounds.width);
        int entityRightTwo = entityRightOne - 5;
        int entityUpOne = (int) (entity.GetY() + entity.normalBounds.y);
        int entityUpTwo = entityUpOne - 5;
        int entityDownOne = (int) (entity.GetY() + entity.normalBounds.y + entity.normalBounds.height);
        int entityDownTwo = entityDownOne +5;

        int entityLeftColOne = (int) ((entityLeft - entity.speed) / 32);
        int entityLeftColTwo;
        int entityRightCol = (int) ((entityRight - entity.speed) / 32);
        int entityRightColTwo;
        int entityUpCol = (int) ((entityUp - entity.speed) / 32);
        int entityUpColTwo;
        int entityDownCol = (int) ((entityDown - entity.speed) / 32);
        int entityDownColTwo;


        if (ref.GetKeyManager().up) {
            if (ref.GetMap().GetTile(entityLeftCol, entityUpCol).IsSolid() && ref.GetMap().GetTile(entityRightCol, entityUpCol).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().down) {
            if (ref.GetMap().GetTile(entityLeftCol, entityDownCol).IsSolid() && ref.GetMap().GetTile(entityRightCol, entityDownCol).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().right) {
            if (ref.GetMap().GetTile(entityRightCol, entityUpCol).IsSolid() && ref.GetMap().GetTile(entityRightCol, entityDownCol).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().left) {
            if (ref.GetMap().GetTile(entityLeftCol, entityUpCol).IsSolid() && ref.GetMap().GetTile(entityLeftCol, entityDownCol).IsSolid()) {
                entity.collisionOn = true;
            }
        }
    }
}
