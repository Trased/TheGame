package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

public class Professor extends NPC{
    boolean up= false;

    public Professor(RefLinks refLink, float x, float y, int damage) {
        super(refLink, x, y, damage);
        image = Assets.FirstNpcOne;
    }

    @Override
    public void Update() {
        if (SPRITE_NUM == 1) {
            image = Assets.FirstNpcOne;
        }
        if (SPRITE_NUM == 2) {
            image = Assets.FirstNpcTwo;
        }
        if (SPRITE_NUM == 3) {
            image = Assets.FirstNpcThree;
        }
        if(up) {
            UpCounter(playerNearby);
            up = !up;
        }
        else {
            up = true;
        }
    }
}
