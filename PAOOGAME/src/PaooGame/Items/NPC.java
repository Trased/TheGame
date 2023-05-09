package PaooGame.Items;

import PaooGame.RefLinks;
import java.awt.*;

public class NPC extends Item {
    private String message;

    public NPC(RefLinks refLink, float x, float y, int width, int height, String message) {
        super(refLink, x, y, width, height);
        this.message = message;
    }

    @Override
    public void Update() {
        // Update NPC behavior
    }

    @Override
    public void Draw(Graphics g) {
        // Draw NPC sprite
    }

    public void Interact(Hero player) {
        // Display NPC message to the player
    }
}
