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
    public static BufferedImage bottomGrass;
    public static BufferedImage townGrass;
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
    public static BufferedImage heroAttackDownOne;
    public static BufferedImage heroAttackDownTwo;
    public static BufferedImage heroAttackDownThree;
    public static BufferedImage heroAttackLeftOne;
    public static BufferedImage heroAttackLeftTwo;
    public static BufferedImage heroAttackLeftThree;
    public static BufferedImage heroAttackRightOne;
    public static BufferedImage heroAttackRightTwo;
    public static BufferedImage heroAttackRightThree;
    public static BufferedImage heroAttackUpOne;
    public static BufferedImage heroAttackUpTwo;
    public static BufferedImage heroAttackUpThree;


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
        heroDownOne = character.characterCrop(0,0);
        heroDownTwo = character.characterCrop(1,0);
        heroDownThree = character.characterCrop(2,0);
        heroAttackDownOne = character.characterCrop(3,0);
        heroAttackDownTwo = character.characterCrop(4,0);
        heroAttackDownThree = character.characterCrop(5,0);
        heroLeftOne = character.characterCrop(0,1);
        heroLeftTwo = character.characterCrop(1,1);
        heroLeftThree = character.characterCrop(2,1);
        heroAttackLeftOne = character.characterCrop(3,1);
        heroAttackLeftTwo = character.characterCrop(4,1);
        heroAttackLeftThree = character.characterCrop(5,1);
        heroRightOne = character.characterCrop(0,2);
        heroRightTwo = character.characterCrop(1,2);
        heroRightThree = character.characterCrop(2,2);
        heroAttackRightOne = character.characterCrop(3,2);
        heroAttackRightTwo = character.characterCrop(4,2);
        heroAttackRightThree = character.characterCrop(5,2);
        heroUpOne = character.characterCrop(0,3);
        heroUpTwo = character.characterCrop(1,3);
        heroUpThree = character.characterCrop(2,3);
        heroAttackUpOne = character.characterCrop(3,3);
        heroAttackUpTwo = character.characterCrop(4,3);
        heroAttackUpThree = character.characterCrop(5,3);


        stone = sheet.crop(9,5);
        sand = sheet.crop(6,4);
        grass = sheet.crop(5, 3);
        topGrass = sheet.crop(3,4);
        bottomGrass = sheet.crop(0,4);
        townGrass = sheet.crop(1, 2);

    }
}
