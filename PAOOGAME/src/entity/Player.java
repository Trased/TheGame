package entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try {
            move1 = ImageIO.read(getClass().getResourceAsStream("/player/Orc_Walking_000.png"));
            move2 = ImageIO.read(getClass().getResourceAsStream("/player/Orc_Walking_008.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed)
        {
            direction = "up";
            y -= speed;
        }
        else if(keyH.downPressed)
        {
            direction ="down";
            y += speed;
        }
        else if(keyH.leftPressed){
            direction ="left";
            x -= speed;
        } else if (keyH.rightPressed) {
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch(direction){
            case "up":
                image = move1;
                break;
            case "down":
                image = move1;
                break;
            case "left":
                image = move1;
                break;
            case "right":
                image = move1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize*3, gp.tileSize*3, null);
    }
}
