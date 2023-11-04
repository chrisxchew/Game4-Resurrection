package game;

import acm.graphics.*;

public class Item {
	private GCompound itemBody;
	private GCompound itemBodyRight;
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
