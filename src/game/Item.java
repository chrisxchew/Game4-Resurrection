package game;

import acm.graphics.*;

public class Item {
	private GCompound itemBody;
	public Item() {
		itemBody = new GCompound();
		
		//remove in prod
		GRect rect = new GRect(5,5);
		itemBody.add(rect);
	}
	public GCompound getItemBody() {
		return itemBody;
	}
}
