package structures;
import acm.graphics.GImage;

import game.Structure;

public class winter_cavern extends Structure{
	public winter_cavern(int x, int y) {
		super (x, y);
		
		GImage winter_cavern = new GImage("media/terrain/winter_cavern.png");
		winter_cavern.setLocation(x, y);
		winter_cavern.setSize(100, 100);
		this.getObjects().add(winter_cavern);
	}
}
