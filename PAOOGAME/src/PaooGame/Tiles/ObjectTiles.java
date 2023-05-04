package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class ObjectTiles {
    public static class HeartTile extends Tile
    {
        public HeartTile(int id)
        {
            super(Assets.heart, id);
        }
    }
    public static class CoinTile extends Tile
    {
        public CoinTile(int id)
        {
            super(Assets.coin, id);
        }
    }
    public static class ChestOneClosed extends Tile
    {
        public ChestOneClosed(int id)
        {
            super(Assets.chestOneClose, id);
        }
    }
    public static class ChestOneOpen extends Tile
    {
        public ChestOneOpen(int id)
        {
            super(Assets.chestOneOpen, id);
        }
    }
    public static class ChestTwoClose extends Tile
    {
        public ChestTwoClose(int id)
        {
            super(Assets.chestTwoClose, id);
        }
    }
    public static class ChestTwoOpen extends Tile
    {
        public ChestTwoOpen(int id)
        {
            super(Assets.chestTwoOpen, id);
        }
    }
}
