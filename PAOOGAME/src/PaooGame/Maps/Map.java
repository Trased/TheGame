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
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    private int [][] objectTiles; /*!< Referinta catre o matrice ce contine obiectele ce se vor afisa pe harta. */

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

    public void Draw(Graphics g) {
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for (int y = 0; y < refLink.worldCol / Tile.TILE_HEIGHT; y++) {
            for (int x = 0; x < refLink.worldRow / Tile.TILE_WIDTH; x++) {
                GetTile(x, y).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
            }
        }
    }
    /*
        public void Draw(Graphics g, Hero player){
            for (int y = 0; y < refLink.worldCol / Tile.TILE_HEIGHT; y++) {
                for (int x = 0; x < refLink.worldRow / Tile.TILE_WIDTH; x++) {
                    int worldX = y * 32;
                    int worldY = x * 32;
                    int screenX = (int) (worldX - player.GetX() + player.screenX);
                    int screenY = (int) (worldY - player.GetY() + player.screenY);
                    GetTile(x,y).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
                }
            }
        }
    */
    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= refLink.maxWorldCol || y >= refLink.maxWorldRow)
        {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.townGrass;
        }
        return t;
    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
     */
    private void LoadWorld()
    {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
            ///Se construieste matricea de coduri de dale
        tiles = new int[refLink.maxWorldCol][refLink.maxWorldRow];
            //Se incarca matricea cu coduri
        for(int y = 0; y < refLink.maxWorldRow; y++)
        {
            for(int x = 0; x < refLink.maxWorldCol; x++)
            {
                tiles[x][y] = HomeTownMap(x,y);
            }
        }
        objectTiles = new int[refLink.maxWorldCol][refLink.maxWorldRow];
        for(int y = 0; y < refLink.maxWorldRow; y++)
        {
            for(int x = 0; x < refLink.maxWorldCol; x++)
            {
                objectTiles[x][y] = HomeTownMapObjects(x,y);
            }
        }
    }

    /*! \fn private int MiddleEastMap(int x ,int y)
        \brief O harta incarcata static.

        \param x linia pe care se afla codul dalei de interes.
        \param y coloana pe care se afla codul dalei de interes.
     */
    private int HomeTownMap(int x ,int y)
    {
            ///Definire statica a matricei de coduri de dale.
        int mapTile;
        try{
            mapTile = Integer.parseInt(Files.readAllLines(Paths.get("res/textures/HomeTownMap.txt")).get(y).split(" ")[x]);
        } catch(Exception e){
            mapTile = 1;
        }

        return mapTile;
    }
    private int HomeTownMapObjects(int x ,int y)
    {
        ///Definire statica a matricei de coduri de dale.
        int mapTile;
        try{
            mapTile = Integer.parseInt(Files.readAllLines(Paths.get("res/textures/HomeTownMapObjects.txt")).get(y).split(" ")[x]);
        } catch(Exception e){
            mapTile = 1;
        }

        return mapTile;
    }
}