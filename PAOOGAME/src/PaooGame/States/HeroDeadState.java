package PaooGame.States;

import PaooGame.RefLinks;

import java.awt.*;

public class HeroDeadState extends State{
    private static int commNum;
    private boolean upPressed = false;
    private boolean downPressed = false;
    public HeroDeadState(RefLinks refLink) {
        super(refLink);
    }

    @Override
    public void Update() {

    }

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
        text = "YOUR HERO DIED";
        g.setFont(g.getFont().deriveFont(Font.PLAIN, 48F));
        x = 280;
        y = 300;
        g.drawString(text, x, y);

        g.setFont(g.getFont().deriveFont(Font.PLAIN, 32F));
        text = "NEW GAME";
        x = 310;
        y = 350;
        g.drawString(text, x, y);

        text = "EXIT";
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