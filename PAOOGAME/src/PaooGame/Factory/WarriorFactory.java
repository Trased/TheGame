package PaooGame.Factory;

import PaooGame.Items.NPC;
import PaooGame.Items.Warrior;
import PaooGame.RefLinks;

public class WarriorFactory implements NPCFactory {
    private final RefLinks refLink;

    public WarriorFactory(RefLinks refLink) {
        this.refLink = refLink;
    }

    public NPC createArcher(int x, int y, int damage) {
        throw new UnsupportedOperationException("WarriorFactory cannot create Archer NPCs");
    }

    public NPC createWarrior(int x, int y, int damage) {
        return new Warrior(refLink, x, y, damage);
    }
}