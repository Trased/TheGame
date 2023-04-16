package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage stone;
    public static BufferedImage sand;
    public static BufferedImage grass;
    public static BufferedImage topGrass;
    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;
    public static BufferedImage heroUp;
    public static BufferedImage heroDown;
    public static BufferedImage townGrass;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/HomeMadeTileSet.png"));
        SpriteSheet character = new SpriteSheet(ImageLoader.LoadImage("/textures/CharacterSpriteSheet.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.
        heroDown = character.crop(0,0);
        heroLeft = character.crop(0,1);
        heroRight = character.crop(0,2);
        heroUp = character.crop(0,3);


        stone = sheet.crop(9,5);
        sand = sheet.crop(6,4);
        grass = sheet.crop(5, 3);
        topGrass = sheet.crop(3,4);
        townGrass = sheet.crop(1, 2);
    }
}
