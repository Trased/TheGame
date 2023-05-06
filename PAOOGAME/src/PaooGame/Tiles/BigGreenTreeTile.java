package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class BigGreenTreeTile {
    public static class BigGreenTreeTileOne extends Tile
    {
        public BigGreenTreeTileOne(int id)
        {
            super(Assets.bigGreenTreeOne, id);
        }
    }
    public static class BigGreenTreeTileTwo extends Tile
    {
        public BigGreenTreeTileTwo(int id)
        {
            super(Assets.bigGreenTreeTwo, id);
        }
    }
    public static class BigGreenTreeTileThree extends Tile
    {
        public BigGreenTreeTileThree(int id)
        {
            super(Assets.bigGreenTreeThree, id);
        }
    }
    public static class BigGreenTreeTileFour extends Tile
    {
        public BigGreenTreeTileFour(int id)
        {
            super(Assets.bigGreenTreeFour, id);
        }
    }
    public static class BigGreenTreeTileFive extends Tile
    {
        public BigGreenTreeTileFive(int id)
        {
            super(Assets.bigGreenTreeFive, id);
            this.collision = true;
        }
    }
    public static class BigGreenTreeTileSix extends Tile
    {
        public BigGreenTreeTileSix(int id)
        {
            super(Assets.bigGreenTreeSix, id);
            this.collision = true;
        }
    }
}
