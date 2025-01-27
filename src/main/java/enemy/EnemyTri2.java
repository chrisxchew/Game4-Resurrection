package enemy;


import acm.graphics.GImage;
import game.*;
import items.*;
public class EnemyTri2 extends Enemy{
	public EnemyTri2(int x, int y, Game game) {
		super(x, y, game);
		this.setHealth(8);
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage("media/Characters/DoritoSV/DoritoSV_FaceFront2.png");
		body.setSize(50,50);
		this.bodyCompound.add(body,x-25,y-25);
	}
	


	@Override
	protected Item calculateDrop() {
		//enemy 1 has a 10% chance of dropping a cherry, 5% chance of dropping a level 3 sword, 5% chance of dropping an arrow, 1% chance of dropping a level 4 sword
		if(percentChance(10)){
			return new Cherries();
		}else if(percentChance(10)){
			return new Sword3();
		}
		else if(percentChance(5)){
			return new Arrow();
		}
		else if(percentChance(1)){
			return new Sword4();
		}
		else{
			return null;
		}

	}
}
