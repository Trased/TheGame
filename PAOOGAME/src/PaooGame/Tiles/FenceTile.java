package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class FenceTile {
    public static class FenceTopLeftCornerTile extends Tile
    {
        public FenceTopLeftCornerTile(int id)
        {
            super(Assets.fenceTopLeftCorner, id);
            this.collision = true;
        }

    }
    public static class FenceLeftDownRightTile extends Tile
    {
        public FenceLeftDownRightTile(int id)
        {
            super(Assets.fenceLeftDownRight, id);
            this.collision = true;
        }
    }
    public static class FenceTopRightCornerTile extends Tile
    {
        public FenceTopRightCornerTile(int id)
        {
            super(Assets.fenceTopRightCorner, id);
            this.collision = true;
        }
    }
    public static class FenceLeftRightTile extends Tile
    {
        public FenceLeftRightTile(int id)
        {
            super(Assets.fenceLeftRight, id);
            this.collision = true;
        }
    }
    public static class FenceBottomRightTopTile extends Tile
    {
        public FenceBottomRightTopTile(int id)
        {
            super(Assets.fenceBottomRightTop, id);
            this.collision = true;
        }
    }
    public static class FenceMidTile extends Tile
    {
        public FenceMidTile(int id)
        {
            super(Assets.fenceMid, id);
            this.collision = true;
        }
    }
    public static class FenceBottomLeftTopTile extends Tile
    {
        public FenceBottomLeftTopTile(int id)
        {
            super(Assets.fenceBottomLeftTop, id);
            this.collision = true;
        }
    }
    public static class FenceBottomTopTile extends Tile
    {
        public FenceBottomTopTile(int id)
        {
            super(Assets.fenceBottomTop, id);
            this.collision = true;
        }
    }
    public static class FenceBottomLeftCornerTile extends Tile
    {
        public FenceBottomLeftCornerTile(int id)
        {
            super(Assets.fenceBottomLeftCorner, id);
            this.collision = true;
        }
    }
    public static class FenceLeftUpRightTile extends Tile
    {
        public FenceLeftUpRightTile(int id)
        {
            super(Assets.fenceLeftUpRight, id);
            this.collision = true;
        }
    }
    public static class FenceBottomRightCornerTile extends Tile
    {
        public FenceBottomRightCornerTile(int id)
        {
            super(Assets.fenceBottomRightCorner, id);
            this.collision = true;
        }
    }
    public static class FenceBlockTile extends Tile
    {
        public FenceBlockTile(int id)
        {
            super(Assets.fenceBlock, id);
            this.collision = true;
        }
    }
}
