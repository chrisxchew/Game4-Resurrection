package structures;

import acm.graphics.GImage;

import game.Structure;

public class boulder_1 extends Structure{

	public boulder_1(int x, int y) {
		super(x, y);
		
		GImage boulder_1 = new GImage("media/terrain/boulder_1.png");
			boulder_1.setLocation(x, y);
			boulder_1.setSize(150, 150);
			this.getObjects().add(boulder_1);
	}

}
