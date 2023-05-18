package PaooGame.Factory;

import PaooGame.Items.NPC;

public interface NPCFactory {
    NPC createArcher(int x, int y, int damage);
    NPC createWarrior(int x, int y, int damage);
}
