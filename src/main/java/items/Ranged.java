package items;

import java.util.ArrayList;

import game.Enemy;
import game.Game;

public interface Ranged {
	public void attackEvent(ArrayList<Enemy> enemies, boolean isRight, double x, double y, Game game);
}
