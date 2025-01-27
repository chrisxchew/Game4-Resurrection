package structures;

import acm.graphics.GImage;
import game.Structure;

public class cactus_1 extends Structure{

	public cactus_1(int x, int y) {
		super(x, y);
		GImage tree = new GImage("media/terrain/cactus_1.png");
		tree.setLocation(x,y);
		tree.setSize(150,150);
		this.getObjects().add(tree);
	}

}
