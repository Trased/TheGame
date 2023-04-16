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
    public static BufferedImage heroLeftOne;
    public static BufferedImage heroLeftTwo;
    public static BufferedImage heroLeftThree;
    public static BufferedImage heroRightOne;
    public static BufferedImage heroRightTwo;
    public static BufferedImage heroRightThree;
    public static BufferedImage heroUpOne;
    public static BufferedImage heroUpTwo;
    public static BufferedImage heroUpThree;
    public static BufferedImage heroDownOne;
    public static BufferedImage heroDownTwo;
    public static BufferedImage heroDownThree;
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
        heroDownOne = character.crop(0,0);
        heroDownTwo = character.crop(1,0);
        heroDownThree = character.crop(2,0);
        heroLeftOne = character.crop(0,1);
        heroLeftTwo = character.crop(1,1);
        heroLeftThree = character.crop(2,1);
        heroRightOne = character.crop(0,2);
        heroRightTwo = character.crop(1,2);
        heroRightThree = character.crop(2,2);
        heroUpOne = character.crop(0,3);
        heroUpTwo = character.crop(1,3);
        heroUpThree = character.crop(2,3);


        stone = sheet.crop(9,5);
        sand = sheet.crop(6,4);
        grass = sheet.crop(5, 3);
        topGrass = sheet.crop(3,4);
        townGrass = sheet.crop(1, 2);
    }
}
