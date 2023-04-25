package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class GreenPineTile {
    public static class GreenPineTileOne extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public GreenPineTileOne(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.GreenPineOne, id);
        }
    }
    public static class GreenPineTileTwo extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public GreenPineTileTwo(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.GreenPineTwo, id);
        }
    }
    public static class GreenPineTileThree extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public GreenPineTileThree(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.GreenPineThree, id);
        }
    }
    public static class GreenPineTileFour extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public GreenPineTileFour(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.GreenPineFour, id);
        }
    }
}
