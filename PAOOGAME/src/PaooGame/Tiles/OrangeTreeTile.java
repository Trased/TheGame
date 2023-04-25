package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class OrangeTreeTile {
    public static class OrangeTreeTileOne extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public OrangeTreeTileOne(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.OrangeTreeOne, id);
        }
    }
    public static class OrangeTreeTileTwo extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public OrangeTreeTileTwo(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.OrangeTreeTwo, id);
        }
    }
    public static class OrangeTreeTileThree extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public OrangeTreeTileThree(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.OrangeTreeThree, id);
        }
    }
    public static class OrangeTreeTileFour extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public OrangeTreeTileFour(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.OrangeTreeFour, id);
        }
    }
}
