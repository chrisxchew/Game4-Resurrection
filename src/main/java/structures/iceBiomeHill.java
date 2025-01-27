package structures;

import acm.graphics.GImage;
import game.Structure;

public class iceBiomeHill extends Structure {

	public iceBiomeHill(int x, int y) {
		super(x, y);
		GImage castle = new GImage("media/terrain/iceBiomeHill.png");
		castle.setLocation(x,y);
		castle.setSize(150,150);
		this.getObjects().add(castle);
	}
}
