package PaooGame;

import PaooGame.GameWindow.GameWindow;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = new Game("Fiury's Adventures", 1920, 1280);
        paooGame.StartGame();
    }
}