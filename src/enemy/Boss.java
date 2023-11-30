package enemy;


import acm.graphics.GImage;
import game.*;
import items.*;
public class Boss extends Enemy{
	public Boss(int x, int y, Game game) {
		super(x, y, game);
		this.setHealth(20);
		this.isRanged = true;
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage("media/Characters/SuperMegaUltraChicken/MegaUltraChicken.png");
		body.setSize(150,150);
		this.bodyCompound.add(body,x-50,y-100);
	}
	
	@Override
	public void shootProjectile(double targetx, double targety){
		//shoots a projectile at the player
		double x = this.getX();
		double y = this.getY();
		double dx = targetx - x;
		double dy = targety - y;
		double angle = Math.atan2(dy, dx);
		
		EnemyProjectileFire p = new EnemyProjectileFire(x, y, angle, this.game);
		this.game.add(p.getCompound());
		this.game.getEnemyProjectiles().add(p);
	}
	@Override
	public void attackPlayer(double targetx, double targety, int deltaTick){
            moveToward(this.getX(), targety);
			if(deltaTick%50 == 0){
				this.shootProjectile(targetx, targety);
			}
        	if(deltaTick%55 == 0){
				this.shootProjectile(targetx, targety);
			}
		    if(deltaTick%40 == 0){
				this.shootProjectile(targetx, targety+100);
			}
            if(deltaTick%35 == 0){
				this.shootProjectile(targetx, targety-100);
			}
	}

	@Override
	protected Item calculateDrop() {
		if(percentChance(5)){
			return new Bow();
		}
		if(percentChance(15)){
			return new Cherries();
		}
		if(percentChance(75)){
			return new Arrow();
		}

		else{
			return null;
		}
		
	}

}
