package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 134;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie
    public static Tile stoneTile        =   new StoneTile(59);
    public static Tile grassTile        =   new GrassTile(35);
    public static Tile townGrass        =   new TownGrassTile(38);
    public static Tile sandtile         =   new SandTile(46);
    public static Tile topGrass         =   new TopGrassTile(43);
    public static Tile bottomGrass      =   new BottomGrassTile(40);

    public static Tile GreenTreeOne     =   new GreenTreeTile.GreenTreeTileOne(85);
    public static Tile GreenTreeTwo     =   new GreenTreeTile.GreenTreeTileTwo(86);
    public static Tile GreenTreeThree   =   new GreenTreeTile.GreenTreeTileThree(95);
    public static Tile GreenTreeFour    =   new GreenTreeTile.GreenTreeTileFour(96);
    public static Tile BigGreenTreeOne  =   new BigGreenTreeTile.BigGreenTreeTileOne(107);
    public static Tile BigGreenTreeTwo  =   new BigGreenTreeTile.BigGreenTreeTileTwo(108);
    public static Tile BigGreenTreeThree=   new BigGreenTreeTile.BigGreenTreeTileThree(117);
    public static Tile BigGreenTreeFour =   new BigGreenTreeTile.BigGreenTreeTileFour(118);
    public static Tile BigGreenTreeFive =   new BigGreenTreeTile.BigGreenTreeTileFive(127);
    public static Tile BigGreenTreeSix  =   new BigGreenTreeTile.BigGreenTreeTileSix(128);
    public static Tile OrangeTreeOne    =   new OrangeTreeTile.OrangeTreeTileOne(105);
    public static Tile OrangeTreeTwo    =   new OrangeTreeTile.OrangeTreeTileTwo(115);
    public static Tile OrangeTreeThree  =   new OrangeTreeTile.OrangeTreeTileThree(106);
    public static Tile OrangeTreeFour   =   new OrangeTreeTile.OrangeTreeTileFour(116);
    public static Tile GreenPineOne     =   new GreenPineTile.GreenPineTileOne(0);
    public static Tile GreenPineTwo     =   new GreenPineTile.GreenPineTileTwo(1);
    public static Tile GreenPineThree   =   new GreenPineTile.GreenPineTileThree(10);
    public static Tile GreenPineFour    =   new GreenPineTile.GreenPineTileFour(11);
    public static Tile PineOne          =   new PineTile.PineTileOne(2);
    public static Tile PineTwo          =   new PineTile.PineTileTwo(3);
    public static Tile PineThree        =   new PineTile.PineTileThree(12);
    public static Tile PineFour         =   new PineTile.PineTileFour(13);
    public static Tile FirstModelHouseOne=  new FirstModelHouseTile.FirstModelHouseTileOne(50);
    public static Tile FirstModelHouseTwo=  new FirstModelHouseTile.FirstModelHouseTileTwo(51);
    public static Tile FirstModelHouseThree=  new FirstModelHouseTile.FirstModelHouseTileThree(60);
    public static Tile FirstModelHouseFour=  new FirstModelHouseTile.FirstModelHouseTileFour(61);
    public static Tile FirstModelHouseFive=  new FirstModelHouseTile.FirstModelHouseTileFive(70);
    public static Tile FirstModelHouseSix=  new FirstModelHouseTile.FirstModelHouseTileSix(71);
    public static Tile SecondModelHouseOne=  new SecondModelHouseTile.SecondModelHouseTileOne(52);
    public static Tile SecondModelHouseTwo=  new SecondModelHouseTile.SecondModelHouseTileTwo(53);
    public static Tile SecondModelHouseThree=  new SecondModelHouseTile.SecondModelHouseTileThree(62);
    public static Tile SecondModelHouseFour=  new SecondModelHouseTile.SecondModelHouseTileFour(63);
    public static Tile SecondModelHouseFive=  new SecondModelHouseTile.SecondModelHouseTileFive(72);
    public static Tile SecondModelHouseSix=  new SecondModelHouseTile.SecondModelHouseTileSix(73);
    public static Tile ThirdModelHouseOne=  new ThirdModelHouseTile.ThirdModelHouseTileOne(54);
    public static Tile ThirdModelHouseTwo=  new ThirdModelHouseTile.ThirdModelHouseTileTwo(55);
    public static Tile ThirdModelHouseThree=  new ThirdModelHouseTile.ThirdModelHouseTileThree(56);
    public static Tile ThirdModelHouseFour=  new ThirdModelHouseTile.ThirdModelHouseTileFour(64);
    public static Tile ThirdModelHouseFive=  new ThirdModelHouseTile.ThirdModelHouseTileFive(65);
    public static Tile ThirdModelHouseSix=  new ThirdModelHouseTile.ThirdModelHouseTileSix(66);
    public static Tile ThirdModelHouseSeven=  new ThirdModelHouseTile.ThirdModelHouseTileSeven(74);
    public static Tile ThirdModelHouseEight=  new ThirdModelHouseTile.ThirdModelHouseTileEight(75);
    public static Tile ThirdModelHouseNine=  new ThirdModelHouseTile.ThirdModelHouseTileNine(76);
    public static Tile FourthModelHouseOne=  new FourthModelHouseTile.FourthModelHouseTileOne(80);
    public static Tile FourthModelHouseTwo=  new FourthModelHouseTile.FourthModelHouseTileTwo(81);
    public static Tile FourthModelHouseThree=  new FourthModelHouseTile.FourthModelHouseTileThree(82);
    public static Tile FourthModelHouseFour=  new FourthModelHouseTile.FourthModelHouseTileFour(90);
    public static Tile FourthModelHouseFive=  new FourthModelHouseTile.FourthModelHouseTileFive(91);
    public static Tile FourthModelHouseSix=  new FourthModelHouseTile.FourthModelHouseTileSix(92);
    public static Tile FourthModelHouseSeven=  new FourthModelHouseTile.FourthModelHouseTileSeven(100);
    public static Tile FourthModelHouseEight=  new FourthModelHouseTile.FourthModelHouseTileEight(101);
    public static Tile FourthModelHouseNine=  new FourthModelHouseTile.FourthModelHouseTileNine(102);
    public static Tile FifthModelHouseOne=  new FifthModelHouseTile.FifthModelHouseTileOne(83);
    public static Tile FifthModelHouseTwo=  new FifthModelHouseTile.FifthModelHouseTileTwo(84);
    public static Tile FifthModelHouseThree=  new FifthModelHouseTile.FifthModelHouseTileThree(93);
    public static Tile FifthModelHouseFour=  new FifthModelHouseTile.FifthModelHouseTileFour(94);
    public static Tile FifthModelHouseFive=  new FifthModelHouseTile.FifthModelHouseTileFive(103);
    public static Tile FifthModelHouseSix=  new FifthModelHouseTile.FifthModelHouseTileSix(104);

    public static Tile FenceTopLeftCorner = new FenceTile.FenceTopLeftCornerTile(110);
    public static Tile FenceLeftDownRight = new FenceTile.FenceLeftDownRightTile(111);
    public static Tile FenceTopRightCorner= new FenceTile.FenceTopRightCornerTile(112);
    public static Tile FenceLeftRight= new FenceTile.FenceLeftRightTile(113);
    public static Tile FenceBottomRightTop= new FenceTile.FenceBottomRightTopTile(120);
    public static Tile FenceMid= new FenceTile.FenceMidTile(121);
    public static Tile FenceBottomLeftTop= new FenceTile.FenceBottomLeftTopTile(122);
    public static Tile FenceBottomTop= new FenceTile.FenceBottomTopTile(123);
    public static Tile FenceBottomLeftCorner= new FenceTile.FenceBottomLeftCornerTile(130);
    public static Tile FenceLeftUpRight= new FenceTile.FenceLeftUpRightTile(131);
    public static Tile FenceBottomRightCorner= new FenceTile.FenceBottomRightCornerTile(132);
    public static Tile FenceBlock= new FenceTile.FenceBlockTile(133);
    public static Tile Invisible = new InvisibleTile(114);
    public static Tile TradingPostTileOne = new TradingPostTile.TradingPostTileOne(6);
    public static Tile TradingPostTileTwo = new TradingPostTile.TradingPostTileTwo(7);
    public static Tile TradingPostTileThree = new TradingPostTile.TradingPostTileThree(16);
    public static Tile TradingPostTileFour = new TradingPostTile.TradingPostTileFour(17);
    public static Tile PetrifiedSandTile = new PetrifiedSandTile.PetrifiedSand(69);
    public static Tile HeartTile = new ObjectTiles.HeartTile(57);
    public static Tile CoinTile = new ObjectTiles.CoinTile(58);
    public static Tile ChestOneOpen = new ObjectTiles.ChestOneOpen(68);
    public static Tile ChestOneClose = new ObjectTiles.ChestOneClosed(67);
    public static Tile ChestTwoOpen = new ObjectTiles.ChestTwoOpen(78);
    public static Tile ChestTwoClose = new ObjectTiles.ChestTwoClose(77);
    public static Tile BushOne = new BushTile.BushOne(4);
    public static Tile BushTwo = new BushTile.BushTwo(5);
    public static Tile BushThree = new BushTile.BushThree(15);
    public static Tile CutTree = new BushTile.CutTree(14);
    public static Tile Mud = new MudTile(33);



    public static final int TILE_WIDTH  = 32;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 32;                       /*!< Inaltimea unei dale.*/

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;/*!< Id-ul unic aferent tipului de dala.*/
    public boolean collision = false;

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {
            /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return collision;
    }

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */
    public int GetId()
    {
        return id;
    }
}
