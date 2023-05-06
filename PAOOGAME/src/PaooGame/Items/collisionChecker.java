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
}
// TO:DO
// GIMP -> BACKGROUND TILE, REDO MAP MATRIX WITH NEW TILES, COLLISION CHECK WITH NEW OBJECTS , 10 MIN WORK.
// ADD OBJECTS ON MAP
// CREATE MAP FOR LEVEL 1-2-3
// CREATE "TELEPORT" FOR LEVELS
// ADD NPC ON MAP
// ADD INTERACTIONS WITCH NPC
// ADD GAME MENU
// ADD MUSIC ??


// 3 DESIGN PATTERNS!!!