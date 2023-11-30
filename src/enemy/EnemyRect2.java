package enemy;


import acm.graphics.GImage;
import game.*;
import items.*;
public class EnemyRect2 extends Enemy{
	public EnemyRect2(int x, int y, Game game) {
		super(x, y, game);
		this.setHealth(40);
		this.isRanged = true;
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage("media/Characters/Blocka/Blocka_FaceFront2.png");
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
		
		EnemyProjectileFire p = new EnemyProjectileFire(x, y, angle, this.game);
		this.game.add(p.getCompound());
		this.game.getEnemyProjectiles().add(p);
	}
	int animationStage = 1;
	boolean finishedAnimation = true;
	public void animateShooting(int deltaTick){
		//loop from Blocka_FaceFront_Walk1 to Blocka_FaceFront_Walk3, then go back to Blocka_FaceFront
		if(deltaTick%5==0){
			if(!finishedAnimation){
				if(animationStage == 1){
					((GImage)this.bodyCompound.getElement(0)).setImage("media/Characters/Blocka/Blocka_FaceFront2_Walk1.png");
					animationStage = 2;
					((GImage) this.bodyCompound.getElement(0)).setSize(50,50);
				}else if(animationStage == 2){
					((GImage)this.bodyCompound.getElement(0)).setImage("media/Characters/Blocka/Blocka_FaceFront2_Walk2.png");
					((GImage) this.bodyCompound.getElement(0)).setSize(50,50);
					animationStage = 3;
				}else if(animationStage == 3){
					((GImage)this.bodyCompound.getElement(0)).setImage("media/Characters/Blocka/Blocka_FaceFront2_Walk3.png");
					((GImage) this.bodyCompound.getElement(0)).setSize(50,50);
					animationStage = 1;
					finishedAnimation = true;
				}
			}else{
				((GImage)this.bodyCompound.getElement(0)).setImage("media/Characters/Blocka/Blocka_FaceFront2.png");
				((GImage) this.bodyCompound.getElement(0)).setSize(50,50);
			}
		}

	}
//
	@Override
	public void attackPlayer(double targetx, double targety, int deltaTick){
		if(this.distanceTo(targetx, targety) > 400){
			this.moveToward(targetx, targety);
		}else{
			if(deltaTick%50 == 0){
				this.shootProjectile(targetx, targety);

				finishedAnimation = false;
			}
				this.animateShooting(deltaTick);
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
		if(percentChance(50)){
			return new Arrow();
		}
		if(percentChance(1)){
			return new IceStaff();
		}

		else{
			return null;
		}
		
	}

}
