package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class OrangeTreeTile {
    public static class OrangeTreeTileOne extends Tile
    {
        public OrangeTreeTileOne(int id)
        {
            super(Assets.orangeTreeOne, id);
        }
    }
    public static class OrangeTreeTileTwo extends Tile
    {
        public OrangeTreeTileTwo(int id)
        {
            super(Assets.orangeTreeTwo, id);
        }
    }
    public static class OrangeTreeTileThree extends Tile
    {
        public OrangeTreeTileThree(int id)
        {
            super(Assets.orangeTreeThree, id);
            this.collision = true;
        }
    }
    public static class OrangeTreeTileFour extends Tile
    {
        public OrangeTreeTileFour(int id)
        {
            super(Assets.orangeTreeFour, id);
            this.collision = true;
        }
    }
}
