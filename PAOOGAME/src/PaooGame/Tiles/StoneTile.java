package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class StoneTile extends Tile {
    public StoneTile(int id)
    {
        super(Assets.stone, id);
        this.collision = true;
    }
}
