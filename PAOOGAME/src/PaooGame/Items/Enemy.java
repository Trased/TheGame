package PaooGame.Items;

import PaooGame.RefLinks;
import java.awt.*;

public class Enemy extends Item {
    private int health;
    private int damage;

    public Enemy(RefLinks refLink, float x, float y, int width, int height, int health, int damage) {
        super(refLink, x, y, width, height);
        this.health = health;
        this.damage = damage;
    }

    @Override
    public void Update() {
        // Update enemy behavior
    }

    @Override
    public void Draw(Graphics g) {
        // Draw enemy sprite
    }

    public void Attack(Hero player) {
        // Reduce player health by the enemy's damage
    }
}
