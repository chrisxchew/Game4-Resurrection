package enemy;


import acm.graphics.GImage;
import game.*;
import items.*;
public class EnemyRect1 extends Enemy{
	public EnemyRect1(int x, int y, Game game) {
		super(x, y, game);
		this.setHealth(20);
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage("media/Characters/Blocka/Blocka_FaceFront.png");
		body.setSize(50,50);
		this.bodyCompound.add(body,x-25,y-25);
	}
	
	@Override
	public void shootProjectile(double targetx, double targety){
		//shoots a projectile at the player
		double x = this.getX();
		double y = this.getY();
		double dx = targetx - x;
		double dy = targety - y;
		double angle = Math.atan2(dy, dx);
		/* 
		Projectile p = new Projectile(x, y, angle, this.game);
		this.game.add(p);
		*/
	}

	@Override
	public void attackPlayer(double targetx, double targety, int deltaTick){
		//ranged enemy moves toward the player until it is within 200 pixels of the player, then it stops moving and shoots an projectile at the player
		if(this.distanceTo(targetx, targety) > 200){
			this.moveToward(targetx, targety);
		}else{
			if(deltaTick%100 == 0){
				this.shootProjectile(targetx, targety);
			}

		}
	}

	@Override
	protected Item calculateDrop() {
		if(percentChance(7)){
			return new Cherries();
		}else if(percentChance(7)){
			return new Arrow();
		}
		else if(percentChance(1)){
			return new Bow();
		}
		else{
			return null;
		}
		
	}

}
