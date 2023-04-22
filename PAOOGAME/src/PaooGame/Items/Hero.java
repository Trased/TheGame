package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import static java.lang.Math.sqrt;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/

    ///Fixam caracterul pe mijlocul ecranului
    public final int screenX;
    public final int screenY;

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
            ///Seteaza imaginea de start a eroului
        image = Assets.heroLeftOne;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 35;
        normalBounds.y = 35;
        normalBounds.width = 24;
        normalBounds.height = 40;

            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 38;
        attackBounds.height = 38;

        screenX = refLink.GetWidth() / 2;
        screenY = refLink.GetHeight() / 2;

    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
            ///Verifica daca a fost apasata o tasta
        GetInput();
            ///Actualizeaza pozitia
        Move();
            ///Actualizeaza imaginea

        if(refLink.GetKeyManager().up){
            if(refLink.GetKeyManager().down){}
            else {
                if (SPRITE_NUM == 1) {
                    image = Assets.heroUpOne;
                }
                if (SPRITE_NUM == 2) {
                    image = Assets.heroUpTwo;
                }
                if (SPRITE_NUM == 3) {
                    image = Assets.heroUpThree;
                }
            }
        }
        if(refLink.GetKeyManager().down){
            if(refLink.GetKeyManager().up){}
            else {
                if (SPRITE_NUM == 1) {
                    image = Assets.heroDownOne;
                }
                if (SPRITE_NUM == 2) {
                    image = Assets.heroDownTwo;
                }
                if (SPRITE_NUM == 3) {
                    image = Assets.heroDownThree;
                }
            }
        }
        if(refLink.GetKeyManager().left)
        {
            if(refLink.GetKeyManager().right){}
            else {
                if (SPRITE_NUM == 1) {
                    image = Assets.heroLeftOne;
                }
                if (SPRITE_NUM == 2) {
                    image = Assets.heroLeftTwo;
                }
                if (SPRITE_NUM == 3) {
                    image = Assets.heroLeftThree;
                }
            }
        }
        if(refLink.GetKeyManager().right) {
            if(refLink.GetKeyManager().left){}
            else {
                if (SPRITE_NUM == 1) {
                    image = Assets.heroRightOne;
                }
                if (SPRITE_NUM == 2) {
                    image = Assets.heroRightTwo;
                }
                if (SPRITE_NUM == 3) {
                    image = Assets.heroRightThree;
                }
            }
        }
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
        refLink.cCol.checkTile(this);
        if(!collisionOn){
            if(refLink.GetKeyManager().left && refLink.GetKeyManager().right && refLink.GetKeyManager().up && refLink.GetKeyManager().down){}
            else if(refLink.GetKeyManager().left && refLink.GetKeyManager().right && refLink.GetKeyManager().up ){yMove = -speed;}
            else if(refLink.GetKeyManager().left && refLink.GetKeyManager().right && refLink.GetKeyManager().down ){yMove = speed;}
            else if(refLink.GetKeyManager().up && refLink.GetKeyManager().down && refLink.GetKeyManager().left ){xMove = -speed;}
            else if(refLink.GetKeyManager().up && refLink.GetKeyManager().down && refLink.GetKeyManager().right ){xMove = speed;}
            else if(refLink.GetKeyManager().up && refLink.GetKeyManager().left){
                yMove = (float) (-speed/sqrt(2.0));
                xMove = (float) (-speed/sqrt(2.0));
            }else if(refLink.GetKeyManager().up && refLink.GetKeyManager().right){
                yMove = (float) (-speed/sqrt(2.0));
                xMove = (float) (speed/sqrt(2.0));
            }else if(refLink.GetKeyManager().down && refLink.GetKeyManager().left){
                yMove = (float) (speed/sqrt(2.0));
                xMove = (float) (-speed/sqrt(2.0));
            }else if(refLink.GetKeyManager().down && refLink.GetKeyManager().right){
                yMove = (float) (speed/sqrt(2.0));
                xMove = (float) (speed/sqrt(2.0));
            }else if(refLink.GetKeyManager().up && refLink.GetKeyManager().down){}
            else if (refLink.GetKeyManager().left && refLink.GetKeyManager().right){}
            else if(refLink.GetKeyManager().up) {
                yMove  = -speed;
            }else if(refLink.GetKeyManager().down) {
                yMove = speed;
            }else if(refLink.GetKeyManager().left) {
                xMove = -speed;
            }else if(refLink.GetKeyManager().right) {
                xMove = speed;
            }
        }
        // Cream efectul de animatie, la fiecare 8 frame-uri modificam imaginea personajului
        // Numarul de frame-uri se poate mari/micsora pentru a modifica viteza de update a frame-urilor.
        SPRITE_COUNTER++;
        if(SPRITE_COUNTER > 8){
            if(SPRITE_NUM == 1){
                SPRITE_NUM = 2;
            }
            else if(SPRITE_NUM == 2) {
                SPRITE_NUM = 3;
            }else if(SPRITE_NUM == 3){
                SPRITE_NUM = 1;
            }
            SPRITE_COUNTER = 0;
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
        g.setColor(Color.blue);
        g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }
}
