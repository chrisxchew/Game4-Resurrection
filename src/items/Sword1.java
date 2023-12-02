package items;

import java.awt.Label;
import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Item;

public class Sword1 extends Item implements Melee{
	public Sword1() {
		this.damage = 2;
		this.combinable = true;
		GImage image = new GImage("media/Items/Weapons/Sword/Sword_Left1.png");
		GImage imageRight = new GImage("media/Items/Weapons/Sword/Sword_Right1.png");
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
		return this.damage + Integer.parseInt(this.label.getLabel());
	}

}
