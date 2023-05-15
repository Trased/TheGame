package PaooGame.States;

import PaooGame.RefLinks;

import java.awt.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    private static int commNum;
    private boolean upPressed = false;
    private boolean downPressed = false;
    Font gameFont;
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        gameFont = new Font("Bahnschrift", Font.PLAIN, 40);
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g) {
        // Title
        String text = "Fiury's Adventures";
        int x = 50;
        int y = 100;
        g.setFont(gameFont);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 96F));
        g.setColor(Color.black);
        g.fillRect(0, 0, 960, 640);
        g.setColor(Color.white);
        g.drawString(text, x, y);

        //Menu
        text = "GAME IS PAUSED";
        g.setFont(g.getFont().deriveFont(Font.PLAIN, 48F));
        x = 280;
        y = 300;
        g.drawString(text, x, y);

        g.setFont(g.getFont().deriveFont(Font.PLAIN, 32F));
        text = "RESUME";
        x = 310;
        y = 350;
        g.drawString(text, x, y);

        text = "SAVE AND EXIT";
        x = 310;
        y = 400;
        g.drawString(text, x, y);
        checkInput();

        switch (commNum) {
            case 0 -> g.drawString(">", 295, 350);
            case 1 -> g.drawString(">", 295, 400);
            }
    }

    private void checkInput(){
        if(refLink.GetKeyManager().up && !upPressed){
            upPressed = true;
            if (commNum == 0){
                commNum = 1;
            }else{
                commNum--;
            }
        }else if(!refLink.GetKeyManager().up){
            upPressed= false;
        }
        if (refLink.GetKeyManager().down && !downPressed) {
            downPressed = true;
            if(commNum == 1){
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
