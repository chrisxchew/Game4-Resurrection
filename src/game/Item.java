package game;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.*;

public abstract class Item {
	private GCompound itemBody;
	private GCompound itemBodyRight;
	public double x;
	public double y;
	public int damage;
	public boolean combinable = false;
	public GLabel label = new GLabel("");

	public Item() {
		Font font = new Font("Arial", Font.BOLD, 20);
		//make the color of the label white
		Color c = new Color(0, 0, 0);
		label.setColor(c);
		label.setFont(font);
		itemBody = new GCompound();
		itemBodyRight = new GCompound();
	}
	public GCompound getItemBody() {
		return itemBody;
	}
	public GCompound getItemBodyRight() {
		return itemBodyRight;
	}
}
