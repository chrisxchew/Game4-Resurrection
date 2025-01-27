package items;

import game.Item;
import game.Player;

public abstract class Artifact extends Item{
    public Artifact() {
        super();
    }
    public abstract void activate(Player player);
}
