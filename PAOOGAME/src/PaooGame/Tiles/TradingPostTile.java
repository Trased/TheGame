package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class TradingPostTile {
    public static class TradingPostTileOne extends Tile
    {
        public TradingPostTileOne(int id)
        {
            super(Assets.tradingPostOne, id);
        }
    }
    public static class TradingPostTileTwo extends Tile
    {
        public TradingPostTileTwo(int id)
        {
            super(Assets.tradingPostTwo, id);
        }
    }
    public static class TradingPostTileThree extends Tile
    {
        public TradingPostTileThree(int id)
        {
            super(Assets.tradingPostThree, id);
            this.collision = true;
        }
    }
    public static class TradingPostTileFour extends Tile
    {
        public TradingPostTileFour(int id)
        {
            super(Assets.tradingPostFour, id);
            this.collision = true;
        }
    }
}
