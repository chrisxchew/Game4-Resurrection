package items;

import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Item;
import userinterface.ToolTip;

public class Sword7 extends Item implements Melee{
	public Sword7() {
		this.name = "Heaven's Sword";
		this.damage = 1;
		GImage image = new GImage("media/Items/Weapons/Sword/Sword_Left7.png");
		GImage imageRight = new GImage("media/Items/Weapons/Sword/Sword_Right7.png");
		this.combinable = true;
		this.label.setLabel("21");
		image.setSize(75,75);
		imageRight.setSize(75,75);
		this.getItemBody().add(image);
		this.getItemBodyRight().add(imageRight);
		updateToolTip();
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
	@Override
	public void updateToolTip() {
		this.toolTip = new ToolTip("A Sword from the Heavens. Damage: " + String.valueOf(damage) + " +"+this.label.getLabel() + " damage per hit. Combine with another sword to upgrade it.", this);
	}
	@Override
	public void setLabel(String label) {
		super.setLabel(label);
		updateToolTip();
	}
}
