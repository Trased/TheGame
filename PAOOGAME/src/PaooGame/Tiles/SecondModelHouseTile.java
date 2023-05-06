package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class SecondModelHouseTile {
    public static class SecondModelHouseTileOne extends Tile
    {
        public SecondModelHouseTileOne(int id)
        {
            super(Assets.secondModelHouseOne, id);
        }
    }
    public static class SecondModelHouseTileTwo extends Tile
    {
        public SecondModelHouseTileTwo(int id)
        {
            super(Assets.secondModelHouseTwo, id);
        }
    }
    public static class SecondModelHouseTileThree extends Tile
    {
        public SecondModelHouseTileThree(int id)
        {
            super(Assets.secondModelHouseThree, id);
        }
    }
    public static class SecondModelHouseTileFour extends Tile
    {
        public SecondModelHouseTileFour(int id)
        {
            super(Assets.secondModelHouseFour, id);
        }
    }
    public static class SecondModelHouseTileFive extends Tile
    {
        public SecondModelHouseTileFive(int id)
        {
            super(Assets.secondModelHouseFive, id);
            this.collision = true;
        }
    }
    public static class SecondModelHouseTileSix extends Tile
    {
        public SecondModelHouseTileSix(int id)
        {
            super(Assets.secondModelHouseSix, id);
            this.collision = true;
        }
    }
}
