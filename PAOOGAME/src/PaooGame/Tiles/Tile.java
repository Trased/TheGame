package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 76;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie
    public static Tile stoneTile        =   new StoneTile(0);
    public static Tile grassTile        =   new GrassTile(1);
    public static Tile townGrass        =   new townGrassTile(2);
    public static Tile sandtile         =   new SandTile(3);
    public static Tile topGrass         =   new topGrassTile(4);
    public static Tile bottomGrass      =   new bottomGrassTile(5);

    public static Tile GreenTreeOne     =   new GreenTreeTile.GreenTreeTileOne(6);
    public static Tile GreenTreeTwo     =   new GreenTreeTile.GreenTreeTileTwo(7);
    public static Tile GreenTreeThree   =   new GreenTreeTile.GreenTreeTileThree(8);
    public static Tile GreenTreeFour    =   new GreenTreeTile.GreenTreeTileFour(9);
    public static Tile BigGreenTreeOne  =   new BigGreenTreeTile.BigGreenTreeTileOne(10);
    public static Tile BigGreenTreeTwo  =   new BigGreenTreeTile.BigGreenTreeTileTwo(11);
    public static Tile BigGreenTreeThree=   new BigGreenTreeTile.BigGreenTreeTileThree(12);
    public static Tile BigGreenTreeFour =   new BigGreenTreeTile.BigGreenTreeTileFour(13);
    public static Tile BigGreenTreeFive =   new BigGreenTreeTile.BigGreenTreeTileFive(14);
    public static Tile BigGreenTreeSix  =   new BigGreenTreeTile.BigGreenTreeTileSix(15);
    public static Tile OrangeTreeOne    =   new OrangeTreeTile.OrangeTreeTileOne(16);
    public static Tile OrangeTreeTwo    =   new OrangeTreeTile.OrangeTreeTileTwo(17);
    public static Tile OrangeTreeThree  =   new OrangeTreeTile.OrangeTreeTileThree(18);
    public static Tile OrangeTreeFour   =   new OrangeTreeTile.OrangeTreeTileFour(19);
    public static Tile GreenPineOne     =   new GreenTreeTile.GreenTreeTileOne(20);
    public static Tile GreenPineTwo     =   new GreenTreeTile.GreenTreeTileTwo(21);
    public static Tile GreenPineThree   =   new GreenTreeTile.GreenTreeTileThree(22);
    public static Tile GreenPineFour    =   new GreenTreeTile.GreenTreeTileFour(23);
    public static Tile PineOne          =   new PineTile.PineTileOne(24);
    public static Tile PineTwo          =   new PineTile.PineTileTwo(25);
    public static Tile PineThree        =   new PineTile.PineTileThree(26);
    public static Tile PineFour         =   new PineTile.PineTileFour(27);
    public static Tile FirstModelHouseOne=  new FirstModelHouseTile.FirstModelHouseTileOne(28);
    public static Tile FirstModelHouseTwo=  new FirstModelHouseTile.FirstModelHouseTileTwo(29);
    public static Tile FirstModelHouseThree=  new FirstModelHouseTile.FirstModelHouseTileThree(30);
    public static Tile FirstModelHouseFour=  new FirstModelHouseTile.FirstModelHouseTileFour(31);
    public static Tile FirstModelHouseFive=  new FirstModelHouseTile.FirstModelHouseTileFive(32);
    public static Tile FirstModelHouseSix=  new FirstModelHouseTile.FirstModelHouseTileSix(33);
    public static Tile SecondModelHouseOne=  new SecondModelHouseTile.SecondModelHouseTileOne(34);
    public static Tile SecondModelHouseTwo=  new SecondModelHouseTile.SecondModelHouseTileTwo(35);
    public static Tile SecondModelHouseThree=  new SecondModelHouseTile.SecondModelHouseTileThree(36);
    public static Tile SecondModelHouseFour=  new SecondModelHouseTile.SecondModelHouseTileFour(37);
    public static Tile SecondModelHouseFive=  new SecondModelHouseTile.SecondModelHouseTileFive(38);
    public static Tile SecondModelHouseSix=  new SecondModelHouseTile.SecondModelHouseTileSix(39);
    public static Tile ThirdModelHouseOne=  new ThirdModelHouseTile.ThirdModelHouseTileOne(40);
    public static Tile ThirdModelHouseTwo=  new ThirdModelHouseTile.ThirdModelHouseTileTwo(41);
    public static Tile ThirdModelHouseThree=  new ThirdModelHouseTile.ThirdModelHouseTileThree(42);
    public static Tile ThirdModelHouseFour=  new ThirdModelHouseTile.ThirdModelHouseTileFour(43);
    public static Tile ThirdModelHouseFive=  new ThirdModelHouseTile.ThirdModelHouseTileFive(44);
    public static Tile ThirdModelHouseSix=  new ThirdModelHouseTile.ThirdModelHouseTileSix(45);
    public static Tile ThirdModelHouseSeven=  new ThirdModelHouseTile.ThirdModelHouseTileSeven(46);
    public static Tile ThirdModelHouseEight=  new ThirdModelHouseTile.ThirdModelHouseTileEight(47);
    public static Tile ThirdModelHouseNine=  new ThirdModelHouseTile.ThirdModelHouseTileNine(48);
    public static Tile FourthModelHouseOne=  new FourthModelHouseTile.FourthModelHouseTileOne(49);
    public static Tile FourthModelHouseTwo=  new FourthModelHouseTile.FourthModelHouseTileTwo(50);
    public static Tile FourthModelHouseThree=  new FourthModelHouseTile.FourthModelHouseTileThree(51);
    public static Tile FourthModelHouseFour=  new FourthModelHouseTile.FourthModelHouseTileFour(52);
    public static Tile FourthModelHouseFive=  new FourthModelHouseTile.FourthModelHouseTileFive(53);
    public static Tile FourthModelHouseSix=  new FourthModelHouseTile.FourthModelHouseTileSix(54);
    public static Tile FourthModelHouseSeven=  new FourthModelHouseTile.FourthModelHouseTileSeven(55);
    public static Tile FourthModelHouseEight=  new FourthModelHouseTile.FourthModelHouseTileEight(56);
    public static Tile FourthModelHouseNine=  new FourthModelHouseTile.FourthModelHouseTileNine(57);
    public static Tile FifthModelHouseOne=  new FifthModelHouseTile.FifthModelHouseTileOne(58);
    public static Tile FifthModelHouseTwo=  new FifthModelHouseTile.FifthModelHouseTileTwo(59);
    public static Tile FifthModelHouseThree=  new FifthModelHouseTile.FifthModelHouseTileThree(60);
    public static Tile FifthModelHouseFour=  new FifthModelHouseTile.FifthModelHouseTileFour(61);
    public static Tile FifthModelHouseFive=  new FifthModelHouseTile.FifthModelHouseTileFive(62);
    public static Tile FifthModelHouseSix=  new FifthModelHouseTile.FifthModelHouseTileSix(63);

    public static Tile FenceTopLeftCorner = new Fence.FenceTopLeftCornerTile(64);
    public static Tile FenceLeftDownRight = new Fence.FenceLeftDownRightTile(65);
    public static Tile FenceTopRightCorner= new Fence.FenceTopRightCornerTile(66);
    public static Tile FenceLeftRight= new Fence.FenceLeftRightTile(67);
    public static Tile FenceBottomRightTop= new Fence.FenceBottomRightTopTile(68);
    public static Tile FenceMid= new Fence.FenceMidTile(69);
    public static Tile FenceBottomLeftTop= new Fence.FenceBottomLeftTopTile(70);
    public static Tile FenceBottomTop= new Fence.FenceBottomTopTile(71);
    public static Tile FenceBottomLeftCorner= new Fence.FenceBottomLeftCornerTile(72);
    public static Tile FenceLeftUpRight= new Fence.FenceLeftUpRightTile(73);
    public static Tile FenceBottomRightCorner= new Fence.FenceBottomRightCornerTile(74);
    public static Tile FenceBlock= new Fence.FenceBlockTile(75);
    public static Tile Invisible = new InvisibleTile(76);


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
