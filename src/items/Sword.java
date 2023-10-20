package items;

import acm.graphics.*;
import game.Item;

public class Sword extends Item implements Melee{
	public Sword() {
		GImage image = new GImage("src/images/k00tvpmql6d41.png");
		image.setLocation(image.getLocation().getX()-50,image.getLocation().getY()+65);

		image.setSize(100,100);
		image.rotate(90);
		this.getItemBody().add(image);
	}

	@Override
	public void attackEvent() {
		System.out.println(((GCompound) this.getItemBody().getParent()).getLocation());
		
	}
}
