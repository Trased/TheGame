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
        int entityLeft = (int) (entity.GetX() + entity.normalBounds.x);
        int entityRight = (int) (entity.GetX() + entity.normalBounds.x + entity.normalBounds.width);
        int entityUp = (int) (entity.GetY() + entity.normalBounds.y);
        int entityDown = (int) (entity.GetY() + entity.normalBounds.y + entity.normalBounds.height);

        int entityLeftCol = (int) ((entityLeft - entity.speed) / 32);
        int entityRightCol = (int) ((entityRight - entity.speed) / 32);
        int entityUpCol = (int) ((entityUp - entity.speed) / 32);
        int entityDownCol = (int) ((entityDown - entity.speed) / 32);


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
