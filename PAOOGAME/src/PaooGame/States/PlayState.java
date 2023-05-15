package PaooGame.States;

import PaooGame.Items.Enemy;
import PaooGame.Items.Hero;
import PaooGame.Observer.PlayerLocationObserver;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;
import PaooGame.Tiles.Tile;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State implements PlayerLocationObserver
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Enemy enem;
    private Map map;    /*!< Referinta catre harta curenta.*/

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
            ///Construieste eroul
        hero = new Hero(refLink,30* Tile.TILE_HEIGHT, 20*Tile.TILE_WIDTH); // x, y sunt coordonatele unde se spawneaza :: TO DO in viitor: SQL care retine unde e personajul la log-out!!
        hero.registerObserver(this);
        enem = new Enemy(refLink, 32*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
    }
    public void ObserverUpdate() {
        int check = playerIsInCertainLocation();
        if (check != 0 ) {
            swapLevel(check);
        }
    }

    private int playerIsInCertainLocation() {
        if(map.getMapID() == 0) {
            if (hero.GetX() > 870 && hero.GetX() < 940 && hero.GetY() > 48 && hero.GetY() < 115) {
                hero.SetX(65);
                hero.SetY(586);
                return 2;
            }
            if (hero.GetX() > 1730 && hero.GetX() < 1829 && hero.GetY() > 557 && hero.GetY() < 621) {
                hero.SetX(70);
                hero.SetY(600);
                return 3;
            }

            if (hero.GetX() > 883 && hero.GetX() < 947 && hero.GetY() > 1085 && hero.GetY() < 1143) {
                hero.SetX(70);
                hero.SetY(1056);
                return 4;
            }
        }
        if(map.getMapID() == 1){
            if(hero.GetX() > 1826 && hero.GetY() >110 && hero.GetY()<150){
                hero.SetX(960);
                hero.SetY(640);
                return 1;
            }
        }
        if(map.getMapID() == 2){
            if(hero.GetX() > 1790 && hero.GetY() >1125 && hero.GetY()<1181){
                hero.SetX(960);
                hero.SetY(640);
                return 1;
            }
        }
        if(map.getMapID() == 3){
            if(hero.GetX() > 1826 && hero.GetY() >466 && hero.GetY()<515){
                hero.SetX(960);
                hero.SetY(640);
                return 1;
            }
        }
        return 0;
    }

    private void swapLevel(int level) {
        map.setMapID(level-1);
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();
        enem.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        if(map.getMapID()==1){
            map.Draw(g, hero);
            map.DrawObjects(g);
            hero.Draw(g);
            enem.Draw(g);
        }else {
            map.Draw(g, hero);
            enem.Draw(g);
            hero.Draw(g);
            map.DrawObjects(g);

        }
    }
}
