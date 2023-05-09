package PaooGame.States;

import PaooGame.RefLinks;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/*! \class public class AboutState extends State
    \brief Implementeaza notiunea de credentiale (about)
 */
public class AboutState extends State
{
    private static int commNum;
    private boolean upPressed = false;
    private boolean downPressed = false;
    Font gameFont;
    /*! \fn public AboutState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public AboutState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        gameFont = new Font("Bahnschrift", Font.PLAIN, 40);

    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniu about.
     */
    @Override
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniu about.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        // Title
        String text = "Fiury's Adventures";
        int x= 50;
        int y= 100;
        g.setFont(gameFont);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 96F));
        g.setColor(Color.black);
        g.fillRect(0,0,960,640);
        g.setColor(Color.white);
        g.drawString(text,x,y);

        //Menu

        text = "NEW GAME";
        g.setFont(g.getFont().deriveFont(Font.PLAIN,48F));
        x = 360;
        y = 310;
        g.drawString(text,x,y);

        text = "LOAD GAME";
        x = 350;
        y = 360;
        g.drawString(text,x,y);

        text = "EXIT";
        x = 430;
        y = 410;
        g.drawString(text,x,y);
        checkInput();
        switch (commNum) {
            case 0 -> {
                g.drawString(">", 340, 310);
            }
            case 1 -> {
                g.drawString(">", 330, 360);
            }
            case 2 -> {
                g.drawString(">", 410, 410);
            }
        }

    }
    private void checkInput(){
        if(refLink.GetKeyManager().up && !upPressed){
            upPressed = true;
            if (commNum == 0){
                commNum = 2;
            }else{
                commNum--;
            }
        }else if(!refLink.GetKeyManager().up){
            upPressed= false;
        }
        if (refLink.GetKeyManager().down && !downPressed) {
            downPressed = true;
            if(commNum == 2){
                commNum = 0;
            }else{
                commNum++;
            }
        }
        else if(!refLink.GetKeyManager().down){
            downPressed = false;
        }
    }

    public static int getCommNum(){
        return commNum;
    }
}
