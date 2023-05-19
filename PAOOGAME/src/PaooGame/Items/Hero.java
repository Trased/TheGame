package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import PaooGame.Observer.LocationSubject;
import PaooGame.Observer.PlayerLocationObserver;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

import static java.lang.Math.sqrt;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character implements LocationSubject
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private int damage;
    private int health;
    private int maxHealth;

    ///Fixam caracterul pe mijlocul ecranului
    public final int screenX;
    public final int screenY;
    private ArrayList<PlayerLocationObserver> observers;

    private int spriteCounter = 1;
    private int spriteNum = 1;
    private boolean attacking = false;
    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;

    private Rectangle trueBounds;

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        observers = new ArrayList<PlayerLocationObserver>();
            ///Seteaza imaginea de start a eroului
        image = Assets.heroLeftOne;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 35;
        normalBounds.y = 35;
        normalBounds.width = 24;
        normalBounds.height = 40;

        damage = 5;
        health = 500;
        maxHealth = health;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x =30;
        attackBounds.y = 0;
        attackBounds.width = 32;
        attackBounds.height = 32;

        trueBounds = new Rectangle((int) x + normalBounds.x, (int) y+normalBounds.y, normalBounds.width, normalBounds.height);

        screenX = refLink.GetWidth() / 2;
        screenY = refLink.GetHeight() / 2;

    }
    public void CheckIfAlive(){
        if(health <= 0){
            refLink.GetGame().SetHeroDeadState();
        }
    }
    @Override
    public void registerObserver(PlayerLocationObserver observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(PlayerLocationObserver observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    public void playerMoved() {
        notifyObservers();
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            PlayerLocationObserver observer = (PlayerLocationObserver) observers.get(i);
            observer.ObserverUpdate();
        }
    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
        CheckIfAlive();
            ///Verifica daca a fost apasata o tasta
        GetInput();
            ///Actualizeaza pozitia
        Move();
            ///Actualizeaza imaginea

        if(refLink.GetKeyManager().up && !refLink.GetKeyManager().down){
           {
               if(attacking){
                   if(!rightPressed && !leftPressed && !downPressed){
                       upPressed = true;
                   }
               }else {
                   if (spriteNum == 1) {
                       image = Assets.heroUpOne;
                   }
                   if (spriteNum == 2) {
                       image = Assets.heroUpTwo;
                   }
                   if (spriteNum == 3) {
                       image = Assets.heroUpThree;
                   }
               }
            }
        }
        if(refLink.GetKeyManager().down && !refLink.GetKeyManager().up){
            if(attacking){
                if(!upPressed && !leftPressed && !rightPressed){

                    downPressed = true;
                }
            }
            else {
                if (spriteNum == 1) {
                    image = Assets.heroDownOne;
                }
                if (spriteNum == 2) {
                    image = Assets.heroDownTwo;
                }
                if (spriteNum == 3) {
                    image = Assets.heroDownThree;
                }
            }
        }
        if(refLink.GetKeyManager().left && !refLink.GetKeyManager().right)
        {
            if(attacking){
                if(!upPressed && !rightPressed && !downPressed){

                    leftPressed = true;
                }
            }
            else {
                if (spriteNum == 1) {
                    image = Assets.heroLeftOne;
                }
                if (spriteNum == 2) {
                    image = Assets.heroLeftTwo;
                }
                if (spriteNum == 3) {
                    image = Assets.heroLeftThree;
                }
            }
        }
        if(refLink.GetKeyManager().right && !refLink.GetKeyManager().left) {
            if(attacking){
                if(!upPressed && !leftPressed && !downPressed){

                    rightPressed = true;
                }
            }
            else {
                if (spriteNum == 1) {
                    image = Assets.heroRightOne;
                }
                if (spriteNum == 2) {
                    image = Assets.heroRightTwo;
                }
                if (spriteNum == 3) {
                    image = Assets.heroRightThree;
                }
            }
        }
        if(attacking) {
            if (checkHeroUp() || upPressed) {
                attackBounds.setLocation(30,0);
                upPressed = true;
                if (spriteNum == 1) {
                    image = Assets.heroAttackUpOne;
                } else if (spriteNum == 2) {
                    image = Assets.heroAttackUpTwo;
                } else if (spriteNum == 3) {
                    image = Assets.heroAttackUpThree;
                } else {
                    image = Assets.heroUpOne;
                    upPressed = false;
                }
            } else if (checkHeroDown() || downPressed) {
                attackBounds.setLocation(30,60);
                downPressed = true;
                if (spriteNum == 1) {
                    image = Assets.heroAttackDownOne;
                } else if (spriteNum == 2) {
                    image = Assets.heroAttackDownTwo;
                } else if (spriteNum == 3) {
                    image = Assets.heroAttackDownThree;
                } else {
                    image = Assets.heroDownOne;
                    downPressed = false;
                }
            } else if (checkHeroLeft() || leftPressed) {
                attackBounds.setLocation(0,30);
                leftPressed = true;
                if (spriteNum == 1) {
                    image = Assets.heroAttackLeftOne;
                } else if (spriteNum == 2) {
                    image = Assets.heroAttackLeftTwo;
                } else if (spriteNum == 3) {
                    image = Assets.heroAttackLeftThree;
                } else {
                    image = Assets.heroLeftOne;
                    leftPressed = false;
                }
            } else if (checkHeroRight() || rightPressed) {
                attackBounds.setLocation(60,30);
                rightPressed = true;
                if (spriteNum == 1) {
                    image = Assets.heroAttackRightOne;
                } else if (spriteNum == 2) {
                    image = Assets.heroAttackRightTwo;
                } else if (spriteNum == 3) {
                    image = Assets.heroAttackRightThree;
                } else {
                    image = Assets.heroRightOne;
                    rightPressed = false;
                }
            }
        }
    }
    private boolean checkHeroUp(){
        if(image == Assets.heroUpOne || image == Assets.heroUpTwo || image == Assets.heroUpThree)
            return true;
        else
            return false;
    }
    private boolean checkHeroDown(){
        if(image == Assets.heroDownOne || image == Assets.heroDownTwo || image == Assets.heroDownThree)
            return true;
        else
            return false;
    }
    private boolean checkHeroLeft(){
        if(image == Assets.heroLeftOne || image == Assets.heroLeftTwo || image == Assets.heroLeftThree)
            return true;
        else
            return false;
    }
    private boolean checkHeroRight(){
        if(image == Assets.heroRightOne || image == Assets.heroRightTwo || image == Assets.heroRightThree)
            return true;
        else
            return false;
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
            ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        // Verificam coliziunea
        collisionOn = false;
        refLink.GetCollision().checkTile(this);
        if(!collisionOn){
            if(refLink.GetKeyManager().left && refLink.GetKeyManager().right && refLink.GetKeyManager().up && refLink.GetKeyManager().down){}
            else if(refLink.GetKeyManager().left && refLink.GetKeyManager().right && refLink.GetKeyManager().up ){yMove = -speed;playerMoved();}
            else if(refLink.GetKeyManager().left && refLink.GetKeyManager().right && refLink.GetKeyManager().down ){yMove = speed;playerMoved();}
            else if(refLink.GetKeyManager().up && refLink.GetKeyManager().down && refLink.GetKeyManager().left ){xMove = -speed;playerMoved();}
            else if(refLink.GetKeyManager().up && refLink.GetKeyManager().down && refLink.GetKeyManager().right ){xMove = speed;playerMoved();}
            else if(refLink.GetKeyManager().up && refLink.GetKeyManager().left){
                yMove = (float) (-speed/sqrt(2.0));
                xMove = (float) (-speed/sqrt(2.0));
                playerMoved();
            }else if(refLink.GetKeyManager().up && refLink.GetKeyManager().right){
                yMove = (float) (-speed/sqrt(2.0));
                xMove = (float) (speed/sqrt(2.0));
                playerMoved();
            }else if(refLink.GetKeyManager().down && refLink.GetKeyManager().left){
                yMove = (float) (speed/sqrt(2.0));
                xMove = (float) (-speed/sqrt(2.0));
                playerMoved();
            }else if(refLink.GetKeyManager().down && refLink.GetKeyManager().right){
                yMove = (float) (speed/sqrt(2.0));
                xMove = (float) (speed/sqrt(2.0));
                playerMoved();
            }else if(refLink.GetKeyManager().up && refLink.GetKeyManager().down){}
            else if (refLink.GetKeyManager().left && refLink.GetKeyManager().right){}
            else if(refLink.GetKeyManager().up) {
                yMove  = -speed;
                playerMoved();
            }else if(refLink.GetKeyManager().down) {
                yMove = speed;
                playerMoved();
            }else if(refLink.GetKeyManager().left) {
                xMove = -speed;
                playerMoved();
            }else if(refLink.GetKeyManager().right) {
                xMove = speed;
                playerMoved();
            }
        }
        if(refLink.GetKeyManager().ability){
            attacking = true;
        }
        // Cream efectul de animatie, la fiecare 8 frame-uri modificam imaginea personajului
        // Numarul de frame-uri se poate mari/micsora pentru a modifica viteza de update a frame-urilor.
        if(!attacking) {
            spriteCounter++;
            if (spriteCounter > 8) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }else{
            spriteCounter++;
            if (spriteCounter <= 5) {
                spriteNum = 1;
            }if(spriteCounter > 5 && spriteCounter <= 15 ){
                spriteNum = 2;
            }
            if(spriteCounter > 15 && spriteCounter < 25 ){
                spriteNum = 3;
                if(spriteCounter == 20){
                    checkAttack = true;
                }else{
                    checkAttack=false;
                }
            }
            if(spriteCounter > 25 && spriteCounter < 30){
                spriteNum = 4;
            }
            if(spriteCounter > 30){
                spriteNum = 1;
                spriteCounter = 0;
                attacking = false;
            }
        }
    }
    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y, width, height, null);
            ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        /*
        g.setColor(Color.green);
        g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
        g.setColor(Color.blue);
        g.fillRect((int)(x + attackBounds.x), (int)(y + attackBounds.y), attackBounds.width, attackBounds.height);
         */
    }
    public void DrawHealth(Graphics g){
        for(int i = 0; i< health/100; i++){
            g.drawImage(heart, (int)x+i*26-screenX, (int)y-screenY, 25, 25, null);
        }
    }
    public int getDamage(){
        checkAttack = false;
        return damage;
    }
    public void HeroDamage(int damage){
        health -= damage;
    }
    public void ResetHealth(){
        health = maxHealth;
    }
    public void SetHealth(int hp){ health = hp;}
    public int GetHealth(){ return health;}
    public Rectangle getNormalBounds(){
        trueBounds.setLocation((int) x + normalBounds.x, (int) y+normalBounds.y);
        return trueBounds;
    }
}
