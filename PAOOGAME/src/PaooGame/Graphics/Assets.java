package PaooGame.Graphics;

import PaooGame.Items.Arrow;

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
    public static BufferedImage mud;
    public static BufferedImage petrifiedSand;
    public static BufferedImage heart;
    public static BufferedImage coin;
    public static BufferedImage chestOneClose;
    public static BufferedImage chestOneOpen;
    public static BufferedImage chestTwoClose;
    public static BufferedImage chestTwoOpen;
    public static BufferedImage bushOne;
    public static BufferedImage bushTwo;
    public static BufferedImage bushThree;
    public static BufferedImage cutTree;

    public static BufferedImage greenTreeOne;
    public static BufferedImage greenTreeTwo;
    public static BufferedImage greenTreeThree;
    public static BufferedImage greenTreeFour;
    public static BufferedImage bigGreenTreeOne;
    public static BufferedImage bigGreenTreeTwo;
    public static BufferedImage bigGreenTreeThree;
    public static BufferedImage bigGreenTreeFour;
    public static BufferedImage bigGreenTreeFive;
    public static BufferedImage bigGreenTreeSix;
    public static BufferedImage orangeTreeOne;
    public static BufferedImage orangeTreeTwo;
    public static BufferedImage orangeTreeThree;
    public static BufferedImage orangeTreeFour;
    public static BufferedImage greenPineOne;
    public static BufferedImage greenPineTwo;
    public static BufferedImage greenPineThree;
    public static BufferedImage greenPineFour;
    public static BufferedImage pineOne;
    public static BufferedImage pineTwo;
    public static BufferedImage pineThree;
    public static BufferedImage pineFour;
    public static BufferedImage firstModelHouseOne;
    public static BufferedImage firstModelHouseTwo;
    public static BufferedImage firstModelHouseThree;
    public static BufferedImage firstModelHouseFour;
    public static BufferedImage firstModelHouseFive;
    public static BufferedImage firstModelHouseSix;
    public static BufferedImage secondModelHouseOne;
    public static BufferedImage secondModelHouseTwo;
    public static BufferedImage secondModelHouseThree;
    public static BufferedImage secondModelHouseFour;
    public static BufferedImage secondModelHouseFive;
    public static BufferedImage secondModelHouseSix;
    public static BufferedImage thirdModelHouseOne;
    public static BufferedImage thirdModelHouseTwo;
    public static BufferedImage thirdModelHouseThree;
    public static BufferedImage thirdModelHouseFour;
    public static BufferedImage thirdModelHouseFive;
    public static BufferedImage thirdModelHouseSix;
    public static BufferedImage thirdModelHouseSeven;
    public static BufferedImage thirdModelHouseEight;
    public static BufferedImage thirdModelHouseNine;
    public static BufferedImage fourthModelHouseOne;
    public static BufferedImage fourthModelHouseTwo;
    public static BufferedImage fourthModelHouseThree;
    public static BufferedImage fourthModelHouseFour;
    public static BufferedImage fourthModelHouseFive;
    public static BufferedImage fourthModelHouseSix;
    public static BufferedImage fourthModelHouseSeven;
    public static BufferedImage fourthModelHouseEight;
    public static BufferedImage fourthModelHouseNine;
    public static BufferedImage fifthModelHouseOne;
    public static BufferedImage fifthModelHouseTwo;
    public static BufferedImage fifthModelHouseThree;
    public static BufferedImage fifthModelHouseFour;
    public static BufferedImage fifthModelHouseFive;
    public static BufferedImage fifthModelHouseSix;
    public static BufferedImage fenceTopLeftCorner;
    public static BufferedImage fenceLeftDownRight;
    public static BufferedImage fenceTopRightCorner;
    public static BufferedImage fenceLeftRight;
    public static BufferedImage fenceBottomRightTop;
    public static BufferedImage fenceMid;
    public static BufferedImage fenceBottomLeftTop;
    public static BufferedImage fenceBottomTop;
    public static BufferedImage fenceBottomLeftCorner;
    public static BufferedImage fenceLeftUpRight;
    public static BufferedImage fenceBottomRightCorner;
    public static BufferedImage fenceBlock;
    public static BufferedImage tradingPostOne;
    public static BufferedImage tradingPostTwo;
    public static BufferedImage tradingPostThree;
    public static BufferedImage tradingPostFour;
    public static BufferedImage invisible;
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

    //FirstEnemyTiles
    public static BufferedImage EnemyTLeftOne;
    public static BufferedImage EnemyTLeftTwo;
    public static BufferedImage EnemyTLeftThree;
    public static BufferedImage EnemyTRightOne;
    public static BufferedImage EnemyTRightTwo;
    public static BufferedImage EnemyTRightThree;
    public static BufferedImage EnemyTUpOne;
    public static BufferedImage EnemyTUpTwo;
    public static BufferedImage EnemyTUpThree;
    public static BufferedImage EnemyTDownOne;
    public static BufferedImage EnemyTDownTwo;
    public static BufferedImage EnemyTDownThree;
    public static BufferedImage EnemyTAttackDownOne;
    public static BufferedImage EnemyTAttackDownTwo;
    public static BufferedImage EnemyTAttackDownThree;
    public static BufferedImage EnemyTAttackLeftOne;
    public static BufferedImage EnemyTAttackLeftTwo;
    public static BufferedImage EnemyTAttackLeftThree;
    public static BufferedImage EnemyTAttackRightOne;
    public static BufferedImage EnemyTAttackRightTwo;
    public static BufferedImage EnemyTAttackRightThree;
    public static BufferedImage EnemyTAttackUpOne;
    public static BufferedImage EnemyTAttackUpTwo;
    public static BufferedImage EnemyTAttackUpThree;

    //Second Enemy Tiles
    public static BufferedImage EnemyOLeftOne;
    public static BufferedImage EnemyOLeftTwo;
    public static BufferedImage EnemyOLeftThree;
    public static BufferedImage EnemyORightOne;
    public static BufferedImage EnemyORightTwo;
    public static BufferedImage EnemyORightThree;
    public static BufferedImage EnemyOUpOne;
    public static BufferedImage EnemyOUpTwo;
    public static BufferedImage EnemyOUpThree;
    public static BufferedImage EnemyODownOne;
    public static BufferedImage EnemyODownTwo;
    public static BufferedImage EnemyODownThree;
    public static BufferedImage EnemyOAttackDownOne;
    public static BufferedImage EnemyOAttackDownTwo;
    public static BufferedImage EnemyOAttackDownThree;
    public static BufferedImage EnemyOAttackLeftOne;
    public static BufferedImage EnemyOAttackLeftTwo;
    public static BufferedImage EnemyOAttackLeftThree;
    public static BufferedImage EnemyOAttackRightOne;
    public static BufferedImage EnemyOAttackRightTwo;
    public static BufferedImage EnemyOAttackRightThree;
    public static BufferedImage EnemyOAttackUpOne;
    public static BufferedImage EnemyOAttackUpTwo;
    public static BufferedImage EnemyOAttackUpThree;


    public static BufferedImage[] BossLeftOne= new BufferedImage[3];
    public static BufferedImage[] BossLeftTwo= new BufferedImage[3];
    public static BufferedImage[] BossLeftThree= new BufferedImage[3];
    public static BufferedImage[] BossAttackLeftOne= new BufferedImage[3];
    public static BufferedImage[] BossAttackLeftTwo= new BufferedImage[3];
    public static BufferedImage[] BossAttackLeftThree= new BufferedImage[3];
    public static BufferedImage[] BossRightOne= new BufferedImage[3];
    public static BufferedImage[] BossRightTwo= new BufferedImage[3];
    public static BufferedImage[] BossRightThree= new BufferedImage[3];
    public static BufferedImage[] BossAttackRightOne= new BufferedImage[3];
    public static BufferedImage[] BossAttackRightTwo= new BufferedImage[3];
    public static BufferedImage[] BossAttackRightThree= new BufferedImage[3];
    public static BufferedImage FirstNpcOne;
    public static BufferedImage FirstNpcTwo;
    public static BufferedImage FirstNpcThree;
    public static BufferedImage SecondNpcOne;
    public static BufferedImage SecondNpcTwo;
    public static BufferedImage SecondNpcThree;
    public static BufferedImage[] arrow = new BufferedImage[4];


    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/HomeMadeTileSet.png"));
        SpriteSheet character = new SpriteSheet(ImageLoader.LoadImage("/textures/CharacterSpriteSheet.png"));
        SpriteSheet enemyOne = new SpriteSheet(ImageLoader.LoadImage("/textures/Enemy1.png"));
        SpriteSheet enemyTwo = new SpriteSheet(ImageLoader.LoadImage("/textures/Enemy2.png"));
        SpriteSheet bossOne = new SpriteSheet(ImageLoader.LoadImage("/textures/Boss1.png"));
        SpriteSheet bossTwo = new SpriteSheet(ImageLoader.LoadImage("/textures/Boss2.png"));
        SpriteSheet bossThree = new SpriteSheet(ImageLoader.LoadImage("/textures/Boss3.png"));
        SpriteSheet npc = new SpriteSheet(ImageLoader.LoadImage("/textures/Npc.png"));

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


        EnemyODownOne = enemyOne.characterCrop(0, 0);
        EnemyODownTwo = enemyOne.characterCrop(1, 0);
        EnemyODownThree = enemyOne.characterCrop(2, 0);
        EnemyOAttackDownOne = enemyOne.characterCrop(3, 0);
        EnemyOAttackDownTwo = enemyOne.characterCrop(4, 0);
        EnemyOAttackDownThree = enemyOne.characterCrop(5, 0);
        EnemyOLeftOne = enemyOne.characterCrop(0, 1);
        EnemyOLeftTwo = enemyOne.characterCrop(1, 1);
        EnemyOLeftThree = enemyOne.characterCrop(2, 1);
        EnemyOAttackLeftOne = enemyOne.characterCrop(3, 1);
        EnemyOAttackLeftTwo = enemyOne.characterCrop(4, 1);
        EnemyOAttackLeftThree = enemyOne.characterCrop(5, 1);
        EnemyORightOne = enemyOne.characterCrop(0, 2);
        EnemyORightTwo = enemyOne.characterCrop(1, 2);
        EnemyORightThree = enemyOne.characterCrop(2, 2);
        EnemyOAttackRightOne = enemyOne.characterCrop(3, 2);
        EnemyOAttackRightTwo = enemyOne.characterCrop(4, 2);
        EnemyOAttackRightThree = enemyOne.characterCrop(5, 2);
        EnemyOUpOne = enemyOne.characterCrop(0, 3);
        EnemyOUpTwo = enemyOne.characterCrop(1, 3);
        EnemyOUpThree = enemyOne.characterCrop(2, 3);
        EnemyOAttackUpOne = enemyOne.characterCrop(3, 3);
        EnemyOAttackUpTwo = enemyOne.characterCrop(4, 3);
        EnemyOAttackUpThree = enemyOne.characterCrop(5, 3);

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        EnemyTDownOne = enemyTwo.characterCrop(0, 0);
        EnemyTDownTwo = enemyTwo.characterCrop(1, 0);
        EnemyTDownThree = enemyTwo.characterCrop(2, 0);
        EnemyTAttackDownOne = enemyTwo.characterCrop(3, 0);
        EnemyTAttackDownTwo = enemyTwo.characterCrop(4, 0);
        EnemyTAttackDownThree = enemyTwo.characterCrop(5, 0);
        EnemyTLeftOne = enemyTwo.characterCrop(0, 1);
        EnemyTLeftTwo = enemyTwo.characterCrop(1, 1);
        EnemyTLeftThree = enemyTwo.characterCrop(2, 1);
        EnemyTAttackLeftOne = enemyTwo.characterCrop(3, 1);
        EnemyTAttackLeftTwo = enemyTwo.characterCrop(4, 1);
        EnemyTAttackLeftThree = enemyTwo.characterCrop(5, 1);
        EnemyTRightOne = enemyTwo.characterCrop(0, 2);
        EnemyTRightTwo = enemyTwo.characterCrop(1, 2);
        EnemyTRightThree = enemyTwo.characterCrop(2, 2);
        EnemyTAttackRightOne = enemyTwo.characterCrop(3, 2);
        EnemyTAttackRightTwo = enemyTwo.characterCrop(4, 2);
        EnemyTAttackRightThree = enemyTwo.characterCrop(5, 2);
        EnemyTUpOne = enemyTwo.characterCrop(0, 3);
        EnemyTUpTwo = enemyTwo.characterCrop(1, 3);
        EnemyTUpThree = enemyTwo.characterCrop(2, 3);
        EnemyTAttackUpOne = enemyTwo.characterCrop(3, 3);
        EnemyTAttackUpTwo = enemyTwo.characterCrop(4, 3);
        EnemyTAttackUpThree = enemyTwo.characterCrop(5, 3);

        BossLeftOne[0]  = bossOne.bossCrop(0,1);
        BossLeftTwo[0]  = bossOne.bossCrop(1,1);
        BossLeftThree[0] = bossOne.bossCrop(2,1);
        BossAttackLeftOne[0] = bossOne.bossCrop(3,1);
        BossAttackLeftTwo[0] = bossOne.bossCrop(4,1);
        BossAttackLeftThree[0] = bossOne.bossCrop(5,1);
        BossRightOne[0] = bossOne.bossCrop(0,0);
        BossRightTwo[0] = bossOne.bossCrop(1,0);
        BossRightThree[0] = bossOne.bossCrop(2,0);
        BossAttackRightOne[0] = bossOne.bossCrop(3,0);
        BossAttackRightTwo[0] = bossOne.bossCrop(4,0);
        BossAttackRightThree[0]= bossOne.bossCrop(5,0);

        BossLeftOne[1]= bossTwo.bossCrop(0,1);
        BossLeftTwo[1]= bossTwo.bossCrop(1,1);
        BossLeftThree[1]= bossTwo.bossCrop(2,1);
        BossAttackLeftOne[1]= bossTwo.bossCrop(3,1);
        BossAttackLeftTwo[1]= bossTwo.bossCrop(4,1);
        BossAttackLeftThree[1]= bossTwo.bossCrop(5,1);
        BossRightOne[1]= bossTwo.bossCrop(0,0);
        BossRightTwo[1]= bossTwo.bossCrop(1,0);
        BossRightThree[1]= bossTwo.bossCrop(2,0);
        BossAttackRightOne[1]= bossTwo.bossCrop(3,0);
        BossAttackRightTwo[1]= bossTwo.bossCrop(4,0);
        BossAttackRightThree[1]= bossTwo.bossCrop(5,0);

        BossLeftOne[2] = bossThree.bossCrop(0,1);
        BossLeftTwo[2] = bossThree.bossCrop(1,1);
        BossLeftThree[2]= bossThree.bossCrop(2,1);
        BossAttackLeftOne[2]= bossThree.bossCrop(3,1);
        BossAttackLeftTwo[2]= bossThree.bossCrop(4,1);
        BossAttackLeftThree[2]= bossThree.bossCrop(5,1);
        BossRightOne[2]= bossThree.bossCrop(0,0);
        BossRightTwo[2]= bossThree.bossCrop(1,0);
        BossRightThree[2]= bossThree.bossCrop(2,0);
        BossAttackRightOne[2]= bossThree.bossCrop(3,0);
        BossAttackRightTwo[2]= bossThree.bossCrop(4,0);
        BossAttackRightThree[2]= bossThree.bossCrop(5,0);

        FirstNpcOne = npc.characterCrop(0,0) ;
        FirstNpcTwo = npc.characterCrop(1,0) ;
        FirstNpcThree = npc.characterCrop(2,0) ;

        SecondNpcOne= npc.characterCrop(0,1) ;
        SecondNpcTwo= npc.characterCrop(1,1) ;
        SecondNpcThree= npc.characterCrop(2,1) ;

        stone = sheet.crop(9, 5);
        sand = sheet.crop(6, 4);
        grass = sheet.crop(5, 3);
        mud = sheet.crop(3,3);
        petrifiedSand = sheet.crop(9,6);
        topGrass = sheet.crop(3, 4);
        bottomGrass = sheet.crop(0, 4);
        townGrass = sheet.crop(1, 2);
        heart = sheet.crop(7,5);
        coin = sheet.crop(8,5);
        chestOneClose = sheet.crop(7,6);
        chestOneOpen = sheet.crop(8,6);
        chestTwoClose = sheet.crop(7,7);
        chestTwoOpen = sheet.crop(8,7);
        bushOne = sheet.crop(4,0);
        bushTwo = sheet.crop(5,0);
        cutTree = sheet.crop(4,1);
        bushThree = sheet.crop(5,1);


        greenTreeOne = sheet.crop(5, 8);
        greenTreeTwo = sheet.crop(6, 8);
        greenTreeThree = sheet.crop(5, 9);
        greenTreeFour = sheet.crop(6, 9);

        bigGreenTreeOne = sheet.crop(7, 10);
        bigGreenTreeTwo = sheet.crop(8, 10);
        bigGreenTreeThree = sheet.crop(7, 11);
        bigGreenTreeFour = sheet.crop(8, 11);
        bigGreenTreeFive = sheet.crop(7, 12);
        bigGreenTreeSix = sheet.crop(8, 12);

        orangeTreeOne = sheet.crop(5, 10);
        orangeTreeTwo = sheet.crop(5, 11);
        orangeTreeThree = sheet.crop(6, 10);
        orangeTreeFour = sheet.crop(6, 11);

        greenPineOne = sheet.crop(0, 0);
        greenPineTwo = sheet.crop(1, 0);
        greenPineThree = sheet.crop(0, 1);
        greenPineFour = sheet.crop(1, 1);

        pineOne = sheet.crop(2, 0);
        pineTwo = sheet.crop(3, 0);
        pineThree = sheet.crop(2, 1);
        pineFour = sheet.crop(3, 1);

        firstModelHouseOne = sheet.crop(0, 5);
        firstModelHouseTwo = sheet.crop(1, 5);
        firstModelHouseThree = sheet.crop(0, 6);
        firstModelHouseFour = sheet.crop(1, 6);
        firstModelHouseFive = sheet.crop(0, 7);
        firstModelHouseSix = sheet.crop(1, 7);

        secondModelHouseOne = sheet.crop(2, 5);
        secondModelHouseTwo = sheet.crop(3, 5);
        secondModelHouseThree = sheet.crop(2, 6);
        secondModelHouseFour = sheet.crop(3, 6);
        secondModelHouseFive = sheet.crop(2, 7);
        secondModelHouseSix = sheet.crop(3, 7);

        thirdModelHouseOne = sheet.crop(4, 5);
        thirdModelHouseTwo = sheet.crop(5, 5);
        thirdModelHouseThree = sheet.crop(6, 5);
        thirdModelHouseFour = sheet.crop(4, 6);
        thirdModelHouseFive = sheet.crop(5, 6);
        thirdModelHouseSix = sheet.crop(6, 6);
        thirdModelHouseSeven = sheet.crop(4, 7);
        thirdModelHouseEight = sheet.crop(5, 7);
        thirdModelHouseNine = sheet.crop(6, 7);

        fourthModelHouseOne = sheet.crop(0, 8);
        fourthModelHouseTwo = sheet.crop(1, 8);
        fourthModelHouseThree = sheet.crop(2, 8);
        fourthModelHouseFour = sheet.crop(0, 9);
        fourthModelHouseFive = sheet.crop(1, 9);
        fourthModelHouseSix = sheet.crop(2, 9);
        fourthModelHouseSeven = sheet.crop(0, 10);
        fourthModelHouseEight = sheet.crop(1, 10);
        fourthModelHouseNine = sheet.crop(2, 10);

        fifthModelHouseOne = sheet.crop(3, 8);
        fifthModelHouseTwo = sheet.crop(4, 8);
        fifthModelHouseThree = sheet.crop(3, 9);
        fifthModelHouseFour = sheet.crop(4, 9);
        fifthModelHouseFive = sheet.crop(3, 10);
        fifthModelHouseSix = sheet.crop(4, 10);

        fenceTopLeftCorner  = sheet.crop(0,11);
        fenceLeftDownRight = sheet.crop(1,11);
        fenceTopRightCorner = sheet.crop(2,11);
        fenceLeftRight = sheet.crop(3,11);
        fenceBottomRightTop= sheet.crop(0,12);
        fenceMid= sheet.crop(1,12);
        fenceBottomLeftTop= sheet.crop(2,12);
        fenceBottomTop= sheet.crop(3,12);
        fenceBottomLeftCorner= sheet.crop(0,13);
        fenceLeftUpRight= sheet.crop(1,13);
        fenceBottomRightCorner= sheet.crop(2,13);
        fenceBlock= sheet.crop(3,13);

        tradingPostOne= sheet.crop(6,0) ;
        tradingPostTwo= sheet.crop(7,0);
        tradingPostThree= sheet.crop(6,1);
        tradingPostFour= sheet.crop(7,1);

        invisible = sheet.crop(0,14);

        arrow[0] = sheet.crop(9,7);
        arrow[1] = sheet.crop(9,8);
        arrow[2] = sheet.crop(9,10);
        arrow[3] = sheet.crop(9,9);
    }
}