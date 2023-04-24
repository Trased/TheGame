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

        int entityXLeftBorder = (int) (entity.GetX() + entity.normalBounds.x);
        int entityXNearLeftBorder = (int) (entity.GetX() + entity.normalBounds.x)+10;
        int entityXRightBorder = (int) (entity.GetX() + entity.normalBounds.x + entity.normalBounds.width);
        int entityXNearRightBorder = (int) (entity.GetX() + entity.normalBounds.x + entity.normalBounds.width) - 10;
        int entityYTopBorder = (int) (entity.GetY() + entity.normalBounds.y);
        int entityYNearTopBorder = (int) (entity.GetY() + entity.normalBounds.y) + 10;
        int entityYBottomBorder = (int) (entity.GetY() + entity.normalBounds.y + entity.normalBounds.height);
        int entityYNearBottomBorder = (int) (entity.GetY() + entity.normalBounds.y + entity.normalBounds.height) - 10;


        int entityColXLeftBorder = (int) ((entityXLeftBorder - entity.speed) / 32);
        int entityColXNearLeftBorder = (int) ((entityXNearLeftBorder - entity.speed) / 32);
        int entityColXRightBorder = (int) ((entityXRightBorder - entity.speed) / 32);
        int entityColXNearRightBorder = (int) ((entityXNearRightBorder - entity.speed) / 32);
        int entityColYTopBorder = (int) ((entityYTopBorder - entity.speed) / 32);
        int entityColYNearTopBorder = (int) ((entityYNearTopBorder - entity.speed) / 32);
        int entityColYBottomBorder = (int) ((entityYBottomBorder - entity.speed) / 32);
        int entityColYNearBottomBorder = (int) ((entityYNearBottomBorder - entity.speed) / 32);


        if (ref.GetKeyManager().up) {
            if (ref.GetMap().GetTile(entityColXLeftBorder, entityColYTopBorder).IsSolid() &&
                ref.GetMap().GetTile(entityColXNearLeftBorder, entityColYTopBorder).IsSolid() ||
                ref.GetMap().GetTile(entityColXNearRightBorder, entityColYTopBorder).IsSolid() &&
                ref.GetMap().GetTile(entityColXRightBorder, entityColYTopBorder).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().down) {
            if (ref.GetMap().GetTile(entityColXLeftBorder, entityColYBottomBorder).IsSolid() &&
                ref.GetMap().GetTile(entityColXNearLeftBorder, entityColYBottomBorder).IsSolid() ||
                ref.GetMap().GetTile(entityColXNearRightBorder, entityColYBottomBorder).IsSolid() &&
                ref.GetMap().GetTile(entityColXRightBorder, entityColYBottomBorder).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().right) {
            if (ref.GetMap().GetTile(entityColXRightBorder, entityColYTopBorder).IsSolid() &&
                ref.GetMap().GetTile(entityColXRightBorder, entityColYNearTopBorder).IsSolid() ||
                ref.GetMap().GetTile(entityColXRightBorder, entityColYNearBottomBorder).IsSolid() &&
                ref.GetMap().GetTile(entityColXRightBorder, entityColYBottomBorder).IsSolid()) {
                entity.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().left) {
            if (ref.GetMap().GetTile(entityColXLeftBorder, entityColYTopBorder).IsSolid() &&
                ref.GetMap().GetTile(entityColXLeftBorder, entityColYNearTopBorder).IsSolid() ||
                ref.GetMap().GetTile(entityColXLeftBorder, entityColYNearBottomBorder).IsSolid() &&
                ref.GetMap().GetTile(entityColXLeftBorder, entityColYBottomBorder).IsSolid()) {
                entity.collisionOn = true;
            }
        }
    }
}
