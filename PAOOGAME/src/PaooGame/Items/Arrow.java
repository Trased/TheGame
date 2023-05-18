package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Arrow extends Item {
    private final BufferedImage image;
    private final int dir;
    private Rectangle trueBounds = new Rectangle(0,0,32,32);

    public Arrow(RefLinks refLink, float x, float y, int width, int height, int direction) {
        super(refLink, x, y, width, height);
        image = Assets.arrow[direction];
        dir = direction;
    }
    protected Hero GetHero(){
        return refLink.GetGame().GetPlayState().GetHero();
    }
    public boolean IsHit(){
        //System.out.println(" CHECK CHECK "+ x + " " + y);
        trueBounds.setLocation((int)x,(int)y);
        if(trueBounds.intersects(GetHero().getNormalBounds()))
        {
            GetHero().HeroDamage(10);
            return true;
        }
        return x < 0 || x > 1920 || y < 0 || y > 1680;
    }

    @Override
    public void Update() {
        IsHit();
        if(dir == 0 ){
            y-=5;

        }
        if(dir == 1){
            y+=5;
        }
        if(dir == 2){
            x-=5;
        }
        if(dir == 3){
            x+=5;
        }
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(image, (int)x, (int)y, width, height, null);
        //g.setColor(Color.green);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }
}
