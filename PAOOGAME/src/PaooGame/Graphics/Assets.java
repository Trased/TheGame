package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets {
    /// Referinte catre elementele grafice (dale) utilizate in joc.
    //MAP Tiles
    public static BufferedImage stone;
    public static BufferedImage sand;
    public static BufferedImage grass;
    public static BufferedImage topGrass;
    public static BufferedImage bottomGrass;
    public static BufferedImage townGrass;
    public static BufferedImage GreenTreeOne;
    public static BufferedImage GreenTreeTwo;
    public static BufferedImage GreenTreeThree;
    public static BufferedImage GreenTreeFour;
    public static BufferedImage BigGreenTreeOne;
    public static BufferedImage BigGreenTreeTwo;
    public static BufferedImage BigGreenTreeThree;
    public static BufferedImage BigGreenTreeFour;
    public static BufferedImage BigGreenTreeFive;
    public static BufferedImage BigGreenTreeSix;
    public static BufferedImage OrangeTreeOne;
    public static BufferedImage OrangeTreeTwo;
    public static BufferedImage OrangeTreeThree;
    public static BufferedImage OrangeTreeFour;
    public static BufferedImage GreenPineOne;
    public static BufferedImage GreenPineTwo;
    public static BufferedImage GreenPineThree;
    public static BufferedImage GreenPineFour;
    public static BufferedImage PineOne;
    public static BufferedImage PineTwo;
    public static BufferedImage PineThree;
    public static BufferedImage PineFour;
    public static BufferedImage FirstModelHouseOne;
    public static BufferedImage FirstModelHouseTwo;
    public static BufferedImage FirstModelHouseThree;
    public static BufferedImage FirstModelHouseFour;
    public static BufferedImage FirstModelHouseFive;
    public static BufferedImage FirstModelHouseSix;
    public static BufferedImage SecondModelHouseOne;
    public static BufferedImage SecondModelHouseTwo;
    public static BufferedImage SecondModelHouseThree;
    public static BufferedImage SecondModelHouseFour;
    public static BufferedImage SecondModelHouseFive;
    public static BufferedImage SecondModelHouseSix;
    public static BufferedImage ThirdModelHouseOne;
    public static BufferedImage ThirdModelHouseTwo;
    public static BufferedImage ThirdModelHouseThree;
    public static BufferedImage ThirdModelHouseFour;
    public static BufferedImage ThirdModelHouseFive;
    public static BufferedImage ThirdModelHouseSix;
    public static BufferedImage ThirdModelHouseSeven;
    public static BufferedImage ThirdModelHouseEight;
    public static BufferedImage ThirdModelHouseNine;
    public static BufferedImage FourthModelHouseOne;
    public static BufferedImage FourthModelHouseTwo;
    public static BufferedImage FourthModelHouseThree;
    public static BufferedImage FourthModelHouseFour;
    public static BufferedImage FourthModelHouseFive;
    public static BufferedImage FourthModelHouseSix;
    public static BufferedImage FourthModelHouseSeven;
    public static BufferedImage FourthModelHouseEight;
    public static BufferedImage FourthModelHouseNine;
    public static BufferedImage FifthModelHouseOne;
    public static BufferedImage FifthModelHouseTwo;
    public static BufferedImage FifthModelHouseThree;
    public static BufferedImage FifthModelHouseFour;
    public static BufferedImage FifthModelHouseFive;
    public static BufferedImage FifthModelHouseSix;

    public static BufferedImage FenceTopLeftCorner;
    public static BufferedImage FenceLeftDownRight;
    public static BufferedImage FenceTopRightCorner;
    public static BufferedImage FenceLeftRight;
    public static BufferedImage FenceBottomRightTop;
    public static BufferedImage FenceMid;
    public static BufferedImage FenceBottomLeftTop;
    public static BufferedImage FenceBottomTop;
    public static BufferedImage FenceBottomLeftCorner;
    public static BufferedImage FenceLeftUpRight;
    public static BufferedImage FenceBottomRightCorner;
    public static BufferedImage FenceBlock;


    public static BufferedImage Invisible;
    //Hero Tiles
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
    public static void Init() {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/HomeMadeTileSet.png"));
        SpriteSheet character = new SpriteSheet(ImageLoader.LoadImage("/textures/CharacterSpriteSheet.png"));

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        heroDownOne = character.characterCrop(0, 0);
        heroDownTwo = character.characterCrop(1, 0);
        heroDownThree = character.characterCrop(2, 0);
        heroAttackDownOne = character.characterCrop(3, 0);
        heroAttackDownTwo = character.characterCrop(4, 0);
        heroAttackDownThree = character.characterCrop(5, 0);
        heroLeftOne = character.characterCrop(0, 1);
        heroLeftTwo = character.characterCrop(1, 1);
        heroLeftThree = character.characterCrop(2, 1);
        heroAttackLeftOne = character.characterCrop(3, 1);
        heroAttackLeftTwo = character.characterCrop(4, 1);
        heroAttackLeftThree = character.characterCrop(5, 1);
        heroRightOne = character.characterCrop(0, 2);
        heroRightTwo = character.characterCrop(1, 2);
        heroRightThree = character.characterCrop(2, 2);
        heroAttackRightOne = character.characterCrop(3, 2);
        heroAttackRightTwo = character.characterCrop(4, 2);
        heroAttackRightThree = character.characterCrop(5, 2);
        heroUpOne = character.characterCrop(0, 3);
        heroUpTwo = character.characterCrop(1, 3);
        heroUpThree = character.characterCrop(2, 3);
        heroAttackUpOne = character.characterCrop(3, 3);
        heroAttackUpTwo = character.characterCrop(4, 3);
        heroAttackUpThree = character.characterCrop(5, 3);


        stone = sheet.crop(9, 5);
        sand = sheet.crop(6, 4);
        grass = sheet.crop(5, 3);
        topGrass = sheet.crop(3, 4);
        bottomGrass = sheet.crop(0, 4);
        townGrass = sheet.crop(1, 2);

        GreenTreeOne = sheet.crop(5, 8);
        GreenTreeTwo = sheet.crop(6, 8);
        GreenTreeThree = sheet.crop(5, 9);
        GreenTreeFour = sheet.crop(6, 9);
        BigGreenTreeOne = sheet.crop(7, 10);
        BigGreenTreeTwo = sheet.crop(8, 10);
        BigGreenTreeThree = sheet.crop(7, 11);
        BigGreenTreeFour = sheet.crop(8, 11);
        BigGreenTreeFive = sheet.crop(7, 12);
        BigGreenTreeSix = sheet.crop(8, 12);
        OrangeTreeOne = sheet.crop(5, 10);
        OrangeTreeTwo = sheet.crop(5, 11);
        OrangeTreeThree = sheet.crop(6, 10);
        OrangeTreeFour = sheet.crop(6, 11);
        GreenPineOne = sheet.crop(0, 0);
        GreenPineTwo = sheet.crop(1, 0);
        GreenPineThree = sheet.crop(0, 1);
        GreenPineFour = sheet.crop(1, 1);
        PineOne = sheet.crop(2, 0);
        PineTwo = sheet.crop(3, 0);
        PineThree = sheet.crop(2, 1);
        PineFour = sheet.crop(3, 1);
        FirstModelHouseOne = sheet.crop(0, 5);
        FirstModelHouseTwo = sheet.crop(1, 5);
        FirstModelHouseThree = sheet.crop(0, 6);
        FirstModelHouseFour = sheet.crop(1, 6);
        FirstModelHouseFive = sheet.crop(0, 7);
        FirstModelHouseSix = sheet.crop(1, 7);
        SecondModelHouseOne = sheet.crop(2, 5);
        SecondModelHouseTwo = sheet.crop(3, 5);
        SecondModelHouseThree = sheet.crop(2, 6);
        SecondModelHouseFour = sheet.crop(3, 6);
        SecondModelHouseFive = sheet.crop(2, 7);
        SecondModelHouseSix = sheet.crop(3, 7);
        ThirdModelHouseOne = sheet.crop(4, 5);
        ThirdModelHouseTwo = sheet.crop(5, 5);
        ThirdModelHouseThree = sheet.crop(6, 5);
        ThirdModelHouseFour = sheet.crop(4, 6);
        ThirdModelHouseFive = sheet.crop(5, 6);
        ThirdModelHouseSix = sheet.crop(6, 6);
        ThirdModelHouseSeven = sheet.crop(4, 7);
        ThirdModelHouseEight = sheet.crop(5, 7);
        ThirdModelHouseNine = sheet.crop(6, 7);
        FourthModelHouseOne = sheet.crop(0, 8);
        FourthModelHouseTwo = sheet.crop(1, 8);
        FourthModelHouseThree = sheet.crop(2, 8);
        FourthModelHouseFour = sheet.crop(0, 9);
        FourthModelHouseFive = sheet.crop(1, 9);
        FourthModelHouseSix = sheet.crop(2, 9);
        FourthModelHouseSeven = sheet.crop(0, 10);
        FourthModelHouseEight = sheet.crop(1, 10);
        FourthModelHouseNine = sheet.crop(2, 10);
        FifthModelHouseOne = sheet.crop(3, 8);
        FifthModelHouseTwo = sheet.crop(4, 8);
        FifthModelHouseThree = sheet.crop(3, 9);
        FifthModelHouseFour = sheet.crop(4, 9);
        FifthModelHouseFive = sheet.crop(3, 10);
        FifthModelHouseSix = sheet.crop(4, 10);

        FenceTopLeftCorner  = sheet.crop(0,11);
        FenceLeftDownRight = sheet.crop(1,11);
        FenceTopRightCorner = sheet.crop(2,11);
        FenceLeftRight = sheet.crop(3,11);
        FenceBottomRightTop= sheet.crop(0,12);;
        FenceMid= sheet.crop(1,12);;
        FenceBottomLeftTop= sheet.crop(2,12);;
        FenceBottomTop= sheet.crop(3,12);;
        FenceBottomLeftCorner= sheet.crop(0,13);;
        FenceLeftUpRight= sheet.crop(1,13);;
        FenceBottomRightCorner= sheet.crop(2,13);;
        FenceBlock= sheet.crop(3,13);;

        Invisible = sheet.crop(0,14);
    }
}