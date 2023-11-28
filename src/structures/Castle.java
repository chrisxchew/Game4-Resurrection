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
		
		//Top castle collider
		GLine topCastle = new GLine(340, 103, 660, 103);
		this.getColliders().add(topCastle);
		
		//Bottom castle collider
		GLine botCastle = new GLine(340, 384, 660, 384);
		this.getColliders().add(botCastle);
		
		//Right side castle collider
		GLine rSideCastle = new GLine(716, 160, 716, 330);
		this.getColliders().add(rSideCastle);
		
		//Top left tower colliders
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
		
		//Top right tower colliders
		GLine rTopCastle = new GLine(660, 103, 695, 71);
		this.getColliders().add(rTopCastle);
		GLine r2TopCastle = new GLine(695, 71, 713, 71);
		this.getColliders().add(r2TopCastle);
		GLine r3TopCastle = new GLine(713, 71, 745, 101);
		this.getColliders().add(r3TopCastle);
		GLine r4TopCastle = new GLine(745, 101, 745, 129);
		this.getColliders().add(r4TopCastle);
		GLine r5TopCastle = new GLine(745, 129, 716, 160);
		this.getColliders().add(r5TopCastle);
		
		//Bottom left tower colliders
		GLine lBotCastle = new GLine(310, 415, 340, 384);
		this.getColliders().add(lBotCastle);
		GLine l2BotCastle = new GLine(280, 415, 310, 415);
		this.getColliders().add(l2BotCastle);
		GLine l3BotCastle = new GLine(252, 385, 282, 415);
		this.getColliders().add(l3BotCastle);
		GLine l4BotCastle = new GLine(252, 385, 252, 360);
		this.getColliders().add(l4BotCastle);
		GLine l5BotCastle = new GLine(252, 360, 290, 320);
		this.getColliders().add(l5BotCastle);
		
		//Bottom right tower colliders
		GLine rBotCastle = new GLine(660, 384, 695, 415);
		this.getColliders().add(rBotCastle);
		GLine r2BotCastle = new GLine(695, 415, 716, 415);
		this.getColliders().add(r2BotCastle);
		GLine r3BotCastle = new GLine(716, 415, 746, 380);
		this.getColliders().add(r3BotCastle);
		GLine r4BotCastle = new GLine(746, 380, 746, 360);
		this.getColliders().add(r4BotCastle);
		GLine r5BotCastle = new GLine(716, 330, 746, 360);
		this.getColliders().add(r5BotCastle);
//bruh
		//Entrance to castle
		GLine door = new GLine(285, 160, 290, 320);
		this.setDoor(door);
	}
}
