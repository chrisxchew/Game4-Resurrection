package items;

import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Item;

public class FireStaff extends Item implements Ranged{
	public FireStaff() {

		GImage image = new GImage("media/Items/Weapons/FireStaff/FireStaff_Left.png");
		GImage imageRight = new GImage("media/Items/Weapons/FireStaff/FireStaff_Right.png");

		image.setSize(75,75);
		imageRight.setSize(75,75);
		this.getItemBody().add(image);
		this.getItemBodyRight().add(imageRight);
	}

	@Override
	public void attackEvent(ArrayList<Enemy> enemies) {
		
	}
}
