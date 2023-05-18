package PaooGame.Factory;

import PaooGame.Items.Archer;
import PaooGame.Items.NPC;
import PaooGame.RefLinks;

public class ArcherFactory implements NPCFactory {
    private final RefLinks refLink;

    public ArcherFactory(RefLinks refLink) {
        this.refLink = refLink;
    }

    public NPC createArcher(int x, int y, int damage) {
        return new Archer(refLink, x, y, damage);
    }

    public NPC createWarrior(int x, int y, int damage) {
        throw new UnsupportedOperationException("ArcherFactory cannot create Warrior NPCs");
    }
}
