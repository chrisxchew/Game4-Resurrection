package game;

import acm.graphics.*;

public class Item {
	private GCompound itemBody;
	public Item() {
		itemBody = new GCompound();
		
		//remove in prod
		GImage image = new GImage("src/images/k00tvpmql6d41.png");
		image.setLocation(image.getLocation().getX()-50,image.getLocation().getY()+65);

		image.setSize(100,100);
		image.rotate(90);
		itemBody.add(image);
	}
	public GCompound getItemBody() {
		return itemBody;
	}
}
