package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class GreenTreeTile {
    public static class GreenTreeTileOne extends Tile
    {
        public GreenTreeTileOne(int id)
        {
            super(Assets.greenTreeOne, id);
        }
    }
    public static class GreenTreeTileTwo extends Tile
    {
        public GreenTreeTileTwo(int id)
        {
            super(Assets.greenTreeTwo, id);
        }
    }
    public static class GreenTreeTileThree extends Tile
    {
        public GreenTreeTileThree(int id)
        {
            super(Assets.greenTreeThree, id);
        }
    }
    public static class GreenTreeTileFour extends Tile
    {
        public GreenTreeTileFour(int id)
        {
            super(Assets.greenTreeFour, id);
        }
    }
}
