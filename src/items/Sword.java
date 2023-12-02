package items;

import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Item;

public class Sword extends Item implements Melee{
	public Sword() {

		GImage image = new GImage("src/images/swordLeft.png");
		image.setLocation(image.getLocation().getX()-60,image.getLocation().getY()-30);
		image.setSize(75,75);
		this.getItemBody().add(image);
	}

	@Override
	public void attackEvent(ArrayList<Enemy> enemies) {
		
	}

	@Override
	public int getKnockback() {
		return 5;
	}
	@Override
	public int getDamage() {
		return 0;
	}
}
