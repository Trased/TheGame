package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class BushTile {
    public static class BushOne extends Tile
    {
        public BushOne(int id)
        {
            super(Assets.bushOne, id);
        }
    }
    public static class BushTwo extends Tile
    {
        public BushTwo(int id)
        {
            super(Assets.bushTwo, id);
        }
    }
    public static class BushThree extends Tile
    {
        public BushThree(int id)
        {
            super(Assets.bushThree, id);
        }
    }
    public static class CutTree extends Tile
    {
        public CutTree(int id)
        {
            super(Assets.cutTree, id);
        }
    }
}
