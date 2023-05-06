package PaooGame.Maps;

import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map
{
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int [][][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    private int [][][] objectTiles; /*!< Referinta catre o matrice ce contine obiectele ce se vor afisa pe harta. */

    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map(RefLinks refLink)
    {
            /// Retine referinta "shortcut".
        this.refLink = refLink;
            ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        LoadWorld();
    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public  void Update()
    {

    }


    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g, Hero player) {
        int offsetX = (int) ((480) - player.GetX());
        int offsetY = (int) ((320) - player.GetY());
        g.translate(offsetX, offsetY);
        for (int y =-10; y < refLink.worldRow / Tile.TILE_HEIGHT + 9; y++) {
            for (int x = -13; x < refLink.worldCol / Tile.TILE_WIDTH+13; x++) {
                GetTile(x, y).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
            }
        }

    }
    public void DrawObjects(Graphics g, Hero player) {
        int offsetX = (int) ((960 / 2) - player.GetX());
        int offsetY = (int) ((640 / 2) - player.GetY());
        for (int y = 0; y < refLink.worldRow / Tile.TILE_HEIGHT; y++) {
            for (int x = 0; x < refLink.worldCol / Tile.TILE_WIDTH; x++) {
                GetObject(x, y).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
            }
        }
    }

    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= refLink.maxWorldCol || y >= refLink.maxWorldRow)
        {
            return Tile.townGrass;
        }
        Tile t = Tile.tiles[tiles[0][x][y]];
        if(t == null)
        {
            return Tile.townGrass;
        }
        return t;
    }
    public Tile GetObject(int x, int y)
    {
        if(x < 0 || y < 0 || x >= refLink.maxWorldCol || y >= refLink.maxWorldRow)
        {
            return Tile.Invisible;
        }
        Tile t = Tile.tiles[objectTiles[0][x][y]];
        if(t == null)
        {
            return Tile.Invisible;
        }
        return t;
    }
    private void LoadWorld()
    {
        tiles = new int[4][refLink.maxWorldCol][refLink.maxWorldRow];
        objectTiles = new int[4][refLink.maxWorldCol][refLink.maxWorldRow];
        for(int i = 0; i < 4; i++){
            for(int y = 0; y < refLink.maxWorldRow; y++)
            {
                for(int x = 0; x < refLink.maxWorldCol; x++)
                {
                    tiles[i][x][y] = LevelMap(i,x,y);
                }
            }
            for(int y = 0; y < refLink.maxWorldRow; y++)
            {
                for(int x = 0; x < refLink.maxWorldCol; x++)
                {
                    objectTiles[i][x][y] = LevelObjects(i,x,y);
                }
            }
        }
    }

    private int LevelMap(int i, int x ,int y)
    {
        int mapTile;
        try{
            mapTile = Integer.parseInt(Files.readAllLines(Paths.get("res/textures/Level"+i+"Map.txt")).get(y).split(" ")[x]);
        } catch(Exception e){
            mapTile = 1;
        }
        return mapTile;
    }
    private int LevelObjects(int i, int x ,int y)
    {
        ///Definire statica a matricei de coduri de dale.
        int mapTile;
        try{
            mapTile = Integer.parseInt(Files.readAllLines(Paths.get("res/textures/Level"+i+"Objects.txt")).get(y).split(" ")[x]);
        } catch(Exception e){
            mapTile = 1;
        }
        return mapTile;
    }
}