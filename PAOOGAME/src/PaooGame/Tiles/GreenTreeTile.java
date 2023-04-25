package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class GreenTreeTile {
    public static class GreenTreeTileOne extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public GreenTreeTileOne(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.GreenTreeOne, id);
        }
    }
    public static class GreenTreeTileTwo extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public GreenTreeTileTwo(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.GreenTreeTwo, id);
        }
    }
    public static class GreenTreeTileThree extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public GreenTreeTileThree(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.GreenTreeThree, id);
        }
    }
    public static class GreenTreeTileFour extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public GreenTreeTileFour(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.GreenTreeFour, id);
        }
    }
}
