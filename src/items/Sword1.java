package items;

import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Item;

public class Sword1 extends Item implements Melee{
	public Sword1() {
		GImage image = new GImage("media/Items/Weapons/Sword_Left.png");
		GImage imageRight = new GImage("media/Items/Weapons/Sword_Right.png");
		image.setLocation(image.getLocation().getX()-60,image.getLocation().getY()-30);
		imageRight.setLocation(image.getLocation().getX()+90,image.getLocation().getY());
		image.setSize(75,75);
		imageRight.setSize(75,75);
		this.getItemBody().add(image);
		this.getItemBodyRight().add(imageRight);
	}

	@Override
	public void attackEvent(ArrayList<Enemy> enemies) {
		
	}
}
