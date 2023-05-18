package PaooGame.States;

import PaooGame.Factory.ArcherFactory;
import PaooGame.Factory.NPCFactory;
import PaooGame.Factory.WarriorFactory;
import PaooGame.Items.*;
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

    private NPC[][] npc;
    private NPC[] boss;
    private Map map;    /*!< Referinta catre harta curenta.*/
    private boolean[] levelFinished = new boolean[4];
    private boolean notEmpty;

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
        npc = new NPC[4][10];
        boss = new NPC[3];
        NPCFactory archerFactory = new ArcherFactory(refLink);
        NPCFactory warriorFactory = new WarriorFactory(refLink);

        npc[1][0] = archerFactory.createArcher(32*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[1][1] = archerFactory.createArcher(32*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[1][2] = archerFactory.createArcher(32*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[1][3] = archerFactory.createArcher(32*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[1][4] = archerFactory.createArcher(32*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[1][5] = archerFactory.createArcher(32*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[1][6] = archerFactory.createArcher(32*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[1][7] = archerFactory.createArcher(32*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        boss[0] = new Boss(refLink,32* Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 2, 0);

        npc[2][1] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[2][2] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[2][3] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[2][4] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[2][5] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[2][6] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[2][7] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        boss[1] = new Boss(refLink,32* Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 2, 1);

        npc[3][0] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[3][1] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[3][2] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[3][3] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[3][4] = warriorFactory.createWarrior(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[3][5] = archerFactory.createArcher(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[3][6] = archerFactory.createArcher(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);
        npc[3][7] = archerFactory.createArcher(34*Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 1);

        boss[2] = new Boss(refLink,32* Tile.TILE_HEIGHT, 22*Tile.TILE_WIDTH, 2, 2);

        npc[0][2] = new Professor(refLink, 36*Tile.TILE_HEIGHT, 11*Tile.TILE_WIDTH, 0);
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
                hero.ResetHealth();
                return 2;
            }
            if (hero.GetX() > 1730 && hero.GetX() < 1829 && hero.GetY() > 557 && hero.GetY() < 621 && levelFinished[0]) {
                hero.SetX(70);
                hero.SetY(600);
                hero.ResetHealth();
                return 3;
            }

            if (hero.GetX() > 883 && hero.GetX() < 947 && hero.GetY() > 1085 && hero.GetY() < 1143 && levelFinished[1]) {
                hero.SetX(70);
                hero.SetY(1056);
                hero.ResetHealth();
                return 4;
            }
        }
        if(map.getMapID() == 1){
            if(hero.GetX() > 1826 && hero.GetY() >110 && hero.GetY()<150 && levelFinished[0]){
                hero.SetX(960);
                hero.SetY(640);
                hero.ResetHealth();
                return 1;
            }
        }
        if(map.getMapID() == 2){
            if(hero.GetX() > 1790 && hero.GetY() >1125 && hero.GetY()<1181 && levelFinished[1]){
                hero.SetX(960);
                hero.SetY(640);
                hero.ResetHealth();
                return 1;
            }
        }
        if(map.getMapID() == 3){
            if(hero.GetX() > 1826 && hero.GetY() >466 && hero.GetY()<515 && levelFinished[2]){
                hero.SetX(960);
                hero.SetY(640);
                hero.ResetHealth();
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
    private void updateNPC(){
        notEmpty = false;
        for( int i = 0; i<npc.length; i++){
            if(npc[map.getMapID()][i] != null) {
                npc[map.getMapID()][i].Update();
                notEmpty = true;
            }
        }
        if(!notEmpty){
            if(boss[map.getMapID()] == null){
                levelFinished[map.getMapID()-1] = true;
            }
            boss[map.getMapID()-1].Update();
        }
    }
    private void drawNPC(Graphics g){
        notEmpty = false;
        for(int i = 0; i<npc.length; i++){
            if(npc[map.getMapID()][i] !=null) {
                npc[map.getMapID()][i].Draw(g);
                notEmpty = true;
            }
        }
        if(!notEmpty){
            if(boss[map.getMapID()] == null){
                levelFinished[map.getMapID()-1] = true;
            }
            boss[map.getMapID()-1].Draw(g);
        }
    }
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();
        updateNPC();
        refLink.GetCollision().checkEntity(hero, npc[map.getMapID()]);
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
            drawNPC(g);
        }else {
            map.Draw(g, hero);
            hero.Draw(g);
            drawNPC(g);
            map.DrawObjects(g);
        }
    }
    public Hero GetHero(){
        return this.hero;
    }
}
