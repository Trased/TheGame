package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PineTile {
    public static class PineTileOne extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public PineTileOne(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.PineOne, id);
        }
    }
    public static class PineTileTwo extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public PineTileTwo(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.PineTwo, id);
        }
    }
    public static class PineTileThree extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public PineTileThree(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.PineThree, id);
        }
    }
    public static class PineTileFour extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        public PineTileFour(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.PineFour, id);
        }
    }
}
