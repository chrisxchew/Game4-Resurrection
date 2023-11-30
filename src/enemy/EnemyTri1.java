package enemy;


import acm.graphics.GImage;
import game.*;
import items.*;
public class EnemyTri1 extends Enemy{
	public EnemyTri1(int x, int y, Game game) {
		super(x, y, game);
		this.setHealth(4);
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage("media/Characters/DoritoSV/DoritoSV_FaceFront.png");
		body.setSize(50,50);
		this.bodyCompound.add(body,x-25,y-25);
	}
	


	@Override
	protected Item calculateDrop() {
		//enemy 1 has a 10% chance of dropping a cherry, 5% chance of dropping a level 2 sword, 5% chance of dropping an arrow, 1% chance of dropping a level 3 sword
		if(percentChance(10)){
			return new Cherries();
		}else if(percentChance(10)){
			return new Sword2();
		}
		else if(percentChance(5)){
			return new Arrow();
		}
		else if(percentChance(1)){
			return new Sword3();
		}
		else{
			return null;
		}
		
	}

}
