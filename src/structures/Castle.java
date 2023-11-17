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
		GLine l3TopCastle = new GLine(285, 71, 255, 101);
		this.getColliders().add(l3TopCastle);
		GLine l4TopCastle = new GLine(255, 101, 255, 128);
		this.getColliders().add(l4TopCastle);
		GLine l5TopCastle = new GLine(255, 128, 285, 160);
		this.getColliders().add(l5TopCastle);
		GLine rTopCastle = new GLine(660, 103, 695, 71);
		this.getColliders().add(rTopCastle);
		GLine r2TopCastle = new GLine(695, 71, 713, 71);
		this.getColliders().add(r2TopCastle);
		GLine r3TopCastle = new GLine(713, 71, 745, 101);
		this.getColliders().add(r3TopCastle);
		GLine r4TopCastle = new GLine(745, 101, 745, 129);
		this.getColliders().add(r4TopCastle);

	}
}
