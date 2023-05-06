package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PineTile {
    public static class PineTileOne extends Tile
    {
        public PineTileOne(int id)
        {
            super(Assets.pineOne, id);
        }
    }
    public static class PineTileTwo extends Tile
    {
        public PineTileTwo(int id)
        {
            super(Assets.pineTwo, id);
        }
    }
    public static class PineTileThree extends Tile
    {
        public PineTileThree(int id)
        {
            super(Assets.pineThree, id);
            this.collision = true;
        }
    }
    public static class PineTileFour extends Tile
    {
        public PineTileFour(int id)
        {
            super(Assets.pineFour, id);
            this.collision = true;
        }
    }
}
