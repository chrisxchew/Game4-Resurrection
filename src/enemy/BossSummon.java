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
	public void attackEvent(Player player){
		player.setHealth(player.getHealth()-2);
		player.getHealthPoints().updateHealthPointsIcons(player.getHealth());
		player.setInvurnerableCooldown(100);
		player.setVelX((int)((player.getPlayerCenter().getX() - this.x) /7));
		player.setVelY((int)((player.getPlayerCenter().getY() - this.y) / 7));
	}

	@Override
	protected Item calculateDrop() {
		return new BossSummonItem();
	}

}
