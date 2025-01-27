package enemy;


import acm.graphics.GImage;
import game.*;
import items.*;
public class EnemyTri3 extends Enemy{
	public EnemyTri3(int x, int y, Game game) {
		super(x, y, game);
		this.setHealth(24);
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage("media/Characters/DoritoSV/DoritoSV_FaceFront3.png");
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
		if(percentChance(10)){
			return new Cherries();
		}else if(percentChance(10)){
			return new Sword4();
		}
		else if(percentChance(25)){
			return new Arrow();
		}
		else if(percentChance(1)){
			return new Sword5();
		}
		else{
			return null;
		}
	}
}
