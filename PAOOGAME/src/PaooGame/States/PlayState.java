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
    private boolean drawDialog[] = new boolean[3];
    private boolean startGame = true;
    NPCFactory archerFactory = new ArcherFactory(refLink);
    NPCFactory warriorFactory = new WarriorFactory(refLink);
    private boolean npcSpawned[] = new boolean[3];
    private boolean bossSpawned[] = new boolean[3];


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
        npcSpawned[0] = false;
        npcSpawned[1] = false;
        npcSpawned[2] = false;
        bossSpawned[0] = false;
        bossSpawned[1] = false;
        bossSpawned[2] = false;

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

    private void checkMap() {
        if (map.getMapID() == 1 && !npcSpawned[0]) {
            npc[1][0] = archerFactory.createArcher(8 * Tile.TILE_HEIGHT, 4 * Tile.TILE_WIDTH, 1);
            npc[1][1] = archerFactory.createArcher(22 * Tile.TILE_HEIGHT, 19 * Tile.TILE_WIDTH, 1);
            npc[1][2] = archerFactory.createArcher(23 * Tile.TILE_HEIGHT, 31 * Tile.TILE_WIDTH, 1);
            npc[1][3] = archerFactory.createArcher(43 * Tile.TILE_HEIGHT, 28 * Tile.TILE_WIDTH, 1);
            npc[1][4] = archerFactory.createArcher(52 * Tile.TILE_HEIGHT, 16 * Tile.TILE_WIDTH, 1);
            npc[1][5] = archerFactory.createArcher(49 * Tile.TILE_HEIGHT, 3 * Tile.TILE_WIDTH, 1);
            npc[1][6] = archerFactory.createArcher(32 * Tile.TILE_HEIGHT, 22 * Tile.TILE_WIDTH, 1);
            npc[1][7] = archerFactory.createArcher(32 * Tile.TILE_HEIGHT, 22 * Tile.TILE_WIDTH, 1);
            npcSpawned[0] = true;
        } else if (map.getMapID() == 1 && !notEmpty && npcSpawned[0] && !bossSpawned[0]) {
            boss[0] = new Boss(refLink, 32 * Tile.TILE_HEIGHT, 22 * Tile.TILE_WIDTH, 1, 0);
            bossSpawned[0] = true;
        } else if (map.getMapID() == 2 && !npcSpawned[1]) {
            npc[2][1] = warriorFactory.createWarrior(15 * Tile.TILE_HEIGHT, 32 * Tile.TILE_WIDTH, 1);
            npc[2][2] = warriorFactory.createWarrior(2 * Tile.TILE_HEIGHT, 3 * Tile.TILE_WIDTH, 1);
            npc[2][3] = warriorFactory.createWarrior(34 * Tile.TILE_HEIGHT, 15 * Tile.TILE_WIDTH, 1);
            npc[2][4] = warriorFactory.createWarrior(41 * Tile.TILE_HEIGHT, 7 * Tile.TILE_WIDTH, 1);
            npc[2][5] = warriorFactory.createWarrior(53 * Tile.TILE_HEIGHT, 28 * Tile.TILE_WIDTH, 1);
            npc[2][6] = warriorFactory.createWarrior(42 * Tile.TILE_HEIGHT, 22 * Tile.TILE_WIDTH, 1);
            npc[2][7] = warriorFactory.createWarrior(45 * Tile.TILE_HEIGHT, 28 * Tile.TILE_WIDTH, 1);
            npcSpawned[1] = true;
        } else if (map.getMapID() == 2 && npcSpawned[1] && !notEmpty && !bossSpawned[1]) {
            boss[1] = new Boss(refLink, 47 * Tile.TILE_HEIGHT, 25 * Tile.TILE_WIDTH, 2, 1);
            bossSpawned[1] = true;
        } else if (map.getMapID() == 3 && !npcSpawned[2]) {
            npc[3][0] = warriorFactory.createWarrior(41 * Tile.TILE_HEIGHT, 5 * Tile.TILE_WIDTH, 1);
            npc[3][1] = warriorFactory.createWarrior(40 * Tile.TILE_HEIGHT, 31 * Tile.TILE_WIDTH, 1);
            npc[3][2] = warriorFactory.createWarrior(40 * Tile.TILE_HEIGHT, 16 * Tile.TILE_WIDTH, 1);
            npc[3][3] = warriorFactory.createWarrior(25 * Tile.TILE_HEIGHT, 5 * Tile.TILE_WIDTH, 1);
            npc[3][4] = warriorFactory.createWarrior(11 * Tile.TILE_HEIGHT, 18 * Tile.TILE_WIDTH, 1);
            npc[3][5] = archerFactory.createArcher(55 * Tile.TILE_HEIGHT, 14 * Tile.TILE_WIDTH, 1);
            npc[3][6] = archerFactory.createArcher(55 * Tile.TILE_HEIGHT, 16 * Tile.TILE_WIDTH, 1);
            npc[3][7] = archerFactory.createArcher(55 * Tile.TILE_HEIGHT, 31 * Tile.TILE_WIDTH, 1);
            npc[3][8] = archerFactory.createArcher(57 * Tile.TILE_HEIGHT, 33 * Tile.TILE_WIDTH, 1);
            npcSpawned[2] = true;
        } else if (map.getMapID() == 3 && !notEmpty && npcSpawned[2] && !bossSpawned[2]) {
            boss[2] = new Boss(refLink, 18 * Tile.TILE_HEIGHT, 11 * Tile.TILE_WIDTH, 3, 2);
            bossSpawned[2] = true;
        }
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    private void updateNPC(){
        checkMap();
        notEmpty = false;
        for( int i = 0; i<npc[map.getMapID()].length; i++){
            if(npc[map.getMapID()][i] != null) {
                npc[map.getMapID()][i].Update();
                notEmpty = true;
            }
        }
        if(!notEmpty){
            if(boss[map.getMapID()-1] == null){
                levelFinished[map.getMapID()-1] = true;
            }else {
                boss[map.getMapID() - 1].Update();
            }
        }
        if(npc[0][2].PlayerInteract() && refLink.GetKeyManager().enter){
            System.out.println("PLAYER INTERACT");
            if(levelFinished[1] == true){
                drawDialog[2] = true;
            }else if(levelFinished[0] == true){
                drawDialog[1] = true;
            }else{
                drawDialog[0] = true;
            }
        }
    }
    private void drawDialog(Graphics g){
        int x =(int) hero.GetX()-hero.screenX;
        int y =(int) hero.GetY()-hero.screenY;
        g.setFont(gameFont);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 24F));
        if(drawDialog[0]){
            startGame = false;
            g.setColor(Color.BLACK);
            g.fillRect(x,y,960,138);
            String text = "Hello Son! Welcome to a new journey.If you want to attack someone, please press 'E'.";
            y +=32;
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);
            text = "In order to start your journey, please follow the road to the North and receive";
            y +=32;
            g.drawString(text, x, y);
            text = "information about Yoru from The Jailer. After you've received the information,";
            y +=32;
            g.drawString(text, x, y);
            text = "take the road from top-right side to get home. Beware the Archers!";
            y +=32;
            g.drawString(text, x, y);
            if(!npc[0][2].PlayerInteract()){
                drawDialog[0] = false;
            }
        }else if(drawDialog[1]){
            g.fillRect(x,y,960,138);
            String text = "Well Done! As I've expected, The Jailer wouldn't talk much about it...";
            y +=32;
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);
            text = "Let's try to 'talk' with Razu, The Traitor... hope his information will help us.";
            y +=32;
            g.drawString(text, x, y);
            text = "He is hiding in the Necropolis Catacombs... heard rumours that no one went back";
            y +=32;
            g.drawString(text, x, y);
            text = "from there... All I can say is ... Good Luck Champion! Beware the Warriors!";
            y +=32;
            g.drawString(text, x, y);

        }else if(drawDialog[2]){
            g.fillRect(x,y,960,138);
            String text = "That's great news! I've always expected that the Yoru is hiding in ";
            y +=32;
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);
            text = "Brackenhide Hollow. Head there, you have my Blessing. Please get the crown";
            y +=32;
            g.drawString(text, x, y);
            text = "back to the King.";
            y +=32;
            g.drawString(text, x, y);
        }
        if(startGame){
            g.setFont(gameFont);
            g.setFont(g.getFont().deriveFont(Font.BOLD, 24F));
            g.setColor(Color.BLACK);
            g.fillRect(x,y,960,40);
            String text = "Please talk with the Professor Andrew. Go near him and press 'ENTER' ";
            y+=32;
            x+=64;
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);
        }
    }
    private void drawNPC(Graphics g){
        notEmpty = false;
        for(int i = 0; i<npc[map.getMapID()].length; i++){
            if(npc[map.getMapID()][i] !=null) {
                npc[map.getMapID()][i].Draw(g);
                npc[map.getMapID()][i].DrawHealth(g);
                notEmpty = true;
            }
        }
        if(!notEmpty){
            if(boss[map.getMapID() - 1] == null){
                levelFinished[map.getMapID()-1] = true;
            }else {
                boss[map.getMapID() - 1].Draw(g);
                boss[map.getMapID() - 1].DrawHealth(g);
            }
        }
    }
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();
        updateNPC();
        refLink.GetCollision().checkEntity(hero, npc[map.getMapID()]);
        refLink.GetCollision().checkEntity(hero,boss);
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g) {
        if(map.getMapID()==1){
            map.Draw(g, hero);
            map.DrawObjects(g);
            hero.Draw(g);
            drawNPC(g);
            hero.DrawHealth(g);
        }else {
            map.Draw(g, hero);
            hero.Draw(g);
            drawNPC(g);
            map.DrawObjects(g);
            hero.DrawHealth(g);
            drawDialog(g);
        }
    }
    public Hero GetHero(){
        return this.hero;
    }
}
