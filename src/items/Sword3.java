package items;

import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Item;

public class Sword3 extends Item implements Melee{
	public Sword3() {
		this.damage = 8;
		GImage image = new GImage("media/Items/Weapons/Sword/Sword_Left3.png");
		GImage imageRight = new GImage("media/Items/Weapons/Sword/Sword_Right3.png");
		this.combinable = true;
		this.label.setLabel("1");
		image.setSize(75,75);
		imageRight.setSize(75,75);
		this.getItemBody().add(image);
		this.getItemBodyRight().add(imageRight);
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
		return this.damage;
	}
}
