package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class InvisibleTile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public InvisibleTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.Invisible, id);
    }
}
