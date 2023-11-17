package structures;

import acm.graphics.GImage;
import game.Structure;

public class tree1 extends Structure{

	public tree1(int x, int y) {
		super(x, y);
		GImage tree = new GImage("media/terrain/tree1.png");
		tree.setLocation(x,y);
		tree.setSize(300,300);
		this.getObjects().add(tree);
	}

}
