package structures;

import acm.graphics.GImage;
import acm.graphics.GLine;
import game.Structure;
import game.Tile;

public class Castle extends Structure {
	private Tile parentTile;
	private CastleTile castleTile;
	private boolean bossCastle = false;
	private int type = 1;
	private String picture;
	public Castle(int x, int y, Tile parentTile, int t) {
		super(x, y);
		//boss castle cant spawn within 15 difficulty of spawn
		//after that boss castle has a 1%-10% chance to spawn increasing by a bit every 5 difficulty
		//lmao this solution sucks but ive been coding all week let me take the easy route for once
		if(parentTile.getDifficulty() >= 15) {
			int chance = (int) (Math.random() * 100);
			if(parentTile.getDifficulty() >= 50){
				if(chance <= 10){
					bossCastle = true;
				}
			}else if(parentTile.getDifficulty() >= 40){
				if(chance <= 8){
					bossCastle = true;
				}
			}else if(parentTile.getDifficulty() >= 30){
				if(chance <= 7){
					bossCastle = true;
				}
			}else if(parentTile.getDifficulty() >= 20){
				if(chance <= 3){
					bossCastle = true;
				}
			}else{
				if(chance <= 1){
					bossCastle = true;
				}
			}

		}
		this.parentTile = parentTile;
		this.castleTile = new CastleTile(this);
		
		type = t;

		this.castleTile.setParentCastle(this);
		
		String pic1 = "media/Buildings/Castle2.0-1.png.png";
		String pic2 = "media/Buildings/Sand Castle 2.0-1.png.png";
		String pic3 = "media/Buildings/Castle 2.0 iced out-1.png.png";

		if(type == 1) {
			picture = pic1;
		}
		else if(type == 2) {
			picture = pic2;
		}
		else {
			picture = pic3;
		}
		
		GImage castle = new GImage(picture);
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
		
		//Entrance to castle
		GLine door = new GLine(285, 160, 290, 320);
		this.setDoor(door);
	}
	public CastleTile getCastleTile() {
		return castleTile;
	}
	public boolean isBossCastle() {
		return bossCastle;
	}
	public Tile getParentTile() {
		return parentTile;
	}
	public int getType() {
		return type;
	}
	public void setType(int t) {
		type = t;
	}
}
