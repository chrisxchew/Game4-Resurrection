package enemy;


import acm.graphics.GImage;
import game.*;
import items.BossSummonItem;
public class BossSummon extends Enemy{
	public BossSummon(int x, int y, Game game) {
		super(x, y, game);
		this.setHealth(52);
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage("media/Characters/SuperMegaUltraChicken/BossSummon.png");
		body.setSize(50,50);
		this.bodyCompound.add(body,x-25,y-25);
	}
	


	@Override
	protected Item calculateDrop() {
		return new BossSummonItem();
		
	}

}
