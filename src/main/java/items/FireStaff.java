package items;

import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Game;
import game.Item;
import userinterface.ToolTip;

public class FireStaff extends Item implements Ranged{
	public FireStaff() {
		this.name = "Fire Staff";
		this.toolTip = new ToolTip("A staff that shoots fireballs. Does 3 damage per hit and lights enemies on fire", this);
		GImage image = new GImage("media/Items/Weapons/FireStaff/FireStaff_Left.png");
		GImage imageRight = new GImage("media/Items/Weapons/FireStaff/FireStaff_Right.png");

		image.setSize(75,75);
		imageRight.setSize(75,75);
		this.getItemBody().add(image);
		this.getItemBodyRight().add(imageRight);
	}

	@Override
	public void attackEvent(ArrayList<Enemy> enemies, boolean isRight, double x, double y, Game game) {
		Fireball fireball = new Fireball(x, y, isRight, enemies);
		game.getProjectiles().add(fireball);
		game.getGraphicsProgram().add(fireball.getImage());
	}
	
}
	
