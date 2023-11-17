package structures;

import acm.graphics.GImage;
import acm.graphics.GLine;
import game.Structure;

public class Castle extends Structure {

	public Castle(int x, int y) {
		super(x, y);
		GImage castle = new GImage("media/Buildings/Castle2.0-1.png.png");
		castle.setLocation(x,y);
		castle.setSize(600,400);
		this.getObjects().add(castle);
		GLine topCastle = new GLine(340, 103, 660, 103);
		this.getColliders().add(topCastle);
		GLine botCastle = new GLine(340, 384, 660, 384);
		this.getColliders().add(botCastle);
		GLine rSideCastle = new GLine(716, 160, 716, 330);
		this.getColliders().add(rSideCastle);
		GLine lTopCastle = new GLine(305, 71, 340, 103);
		this.getColliders().add(lTopCastle);
		GLine l2TopCastle = new GLine(305, 71, 285, 71);
		this.getColliders().add(l2TopCastle);
	}
}
