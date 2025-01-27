package structures;

import acm.graphics.GImage;
import game.Structure;

public class grassyBiomeRegularTree extends Structure{

	public grassyBiomeRegularTree(int x, int y) {
		super(x, y);
		GImage tree = new GImage("media/terrain/grassyBiomeRegularTree.png");
		tree.setLocation(x,y);
		tree.setSize(300,300);
		this.getObjects().add(tree);
	}

}
