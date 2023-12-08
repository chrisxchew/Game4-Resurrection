package structures;

import acm.graphics.GImage;

import game.Structure;

public class boulder_2 extends Structure{
	
	public boulder_2(int x, int y) {
		super (x, y);
		
		GImage boulder_2 = new GImage("media/terrain/boulder_2.png");
		boulder_2.setLocation(x, y);
		boulder_2.setSize(150, 150);
		this.getObjects().add(boulder_2);
	}

}
