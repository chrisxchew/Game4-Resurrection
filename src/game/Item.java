package game;

import acm.graphics.*;

public abstract class Item {
	private GCompound itemBody;
	private GCompound itemBodyRight;
	public double x;
	public double y;
	public Item() {
		itemBody = new GCompound();
		itemBodyRight = new GCompound();
		//remove in prod


	}
	public GCompound getItemBody() {
		return itemBody;
	}
	public GCompound getItemBodyRight() {
		return itemBodyRight;
	}
}
