package structures;

import acm.graphics.GImage;
import game.Structure;

public class Castle extends Structure {

	public Castle(int x, int y) {
		super(x, y);
		GImage tree = new GImage("media/terrain/grassyBiomeRegularTree.png");
		tree.setLocation(x,y);
		tree.setSize(150,150);
		this.getObjects().add(tree);
	}
}
