package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class ThirdModelHouseTile {
    public static class ThirdModelHouseTileOne extends Tile
    {
        public ThirdModelHouseTileOne(int id)
        {
            super(Assets.thirdModelHouseOne, id);
        }
    }
    public static class ThirdModelHouseTileTwo extends Tile
    {
        public ThirdModelHouseTileTwo(int id)
        {
            super(Assets.thirdModelHouseTwo, id);
        }
    }
    public static class ThirdModelHouseTileThree extends Tile
    {
        public ThirdModelHouseTileThree(int id)
        {
            super(Assets.thirdModelHouseThree, id);
        }
    }
    public static class ThirdModelHouseTileFour extends Tile
    {
        public ThirdModelHouseTileFour(int id)
        {
            super(Assets.thirdModelHouseFour, id);
        }
    }
    public static class ThirdModelHouseTileFive extends Tile
    {
        public ThirdModelHouseTileFive(int id)
        {
            super(Assets.thirdModelHouseFive, id);
        }
    }
    public static class ThirdModelHouseTileSix extends Tile
    {
        public ThirdModelHouseTileSix(int id)
        {
            super(Assets.thirdModelHouseSix, id);
        }
    }
    public static class ThirdModelHouseTileSeven extends Tile
    {
        public ThirdModelHouseTileSeven(int id)
        {
            super(Assets.thirdModelHouseSeven, id);
            this.collision = true;
        }
    }
    public static class ThirdModelHouseTileEight extends Tile
    {
        public ThirdModelHouseTileEight(int id)
        {
            super(Assets.thirdModelHouseEight, id);
            this.collision = true;
        }
    }
    public static class ThirdModelHouseTileNine extends Tile
    {
        public ThirdModelHouseTileNine(int id)
        {
            super(Assets.thirdModelHouseNine, id);
            this.collision = true;
        }
    }
}
