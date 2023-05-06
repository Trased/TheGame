package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class GreenPineTile {
    public static class GreenPineTileOne extends Tile
    {
        public GreenPineTileOne(int id)
        {
            super(Assets.greenPineOne, id);
        }
    }
    public static class GreenPineTileTwo extends Tile
    {
        public GreenPineTileTwo(int id)
        {
            super(Assets.greenPineTwo, id);
        }
    }
    public static class GreenPineTileThree extends Tile
    {
        public GreenPineTileThree(int id)
        {
            super(Assets.greenPineThree, id);
            this.collision = true;
        }

    }
    public static class GreenPineTileFour extends Tile
    {
        public GreenPineTileFour(int id) {
            super(Assets.greenPineFour, id);
            this.collision = true;
        }
    }
}
