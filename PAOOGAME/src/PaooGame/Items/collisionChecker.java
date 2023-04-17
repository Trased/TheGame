package PaooGame.Items;

import PaooGame.Maps.Map;
import PaooGame.RefLinks;

import static java.lang.Math.sqrt;

public class collisionChecker {
    RefLinks ref;
    Map map;
    public collisionChecker(RefLinks reflink){
        ref = reflink;
        map = new Map(reflink);
    }
    public void checkTile(Hero entity) {
        int entityLeft = (int) (entity.GetX() + entity.normalBounds.x);
        int entityRight = (int) (entity.GetX() + entity.normalBounds.x + entity.normalBounds.width);
        int entityUp = (int) (entity.GetY() + entity.normalBounds.y);
        int entityDown = (int) (entity.GetY() + entity.normalBounds.y + entity.normalBounds.height);

        int entityLeftCol = (int) ((entityLeft - entity.speed) / 32);
        int entityRightCol = (int) ((entityRight - entity.speed) / 32);
        int entityUpCol = (int) ((entityUp - entity.speed) / 32);
        int entityDownCol = (int) ((entityDown - entity.speed) / 32);


        if (ref.GetKeyManager().up) {
            if (map.GetTile(entityLeftCol, entityUpCol).IsSolid() && map.GetTile(entityRightCol, entityUpCol).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().down) {
            if (map.GetTile(entityLeftCol, entityDownCol).IsSolid() && map.GetTile(entityRightCol, entityDownCol).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().right) {
            if (map.GetTile(entityRightCol, entityUpCol).IsSolid() && map.GetTile(entityRightCol, entityDownCol).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().left) {
            if (map.GetTile(entityLeftCol, entityUpCol).IsSolid() && map.GetTile(entityLeftCol, entityDownCol).IsSolid()) {
                entity.collisionOn = true;
            }
        }
    }
}
