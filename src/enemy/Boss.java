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
			if(deltaTick%51 == 0){
				this.shootProjectile(targetx, targety);
			}
		    if(deltaTick%49 == 0){
				this.shootProjectile(targetx, targety+100);
			}
            if(deltaTick%47 == 0){
				this.shootProjectile(targetx, targety-100);
			}
            if(deltaTick%20 == 0){
                //has a 10% chance to summon 3 BossSummon enemies
                int chance = (int)(Math.random()*10);
                if(chance == 1){
                    this.summonEnemy();
                }
			}
	}
    public void summonEnemy(){
        //summons 3 BossSummon enemies at random Ys and at the same X as the boss
        int y = (int)(Math.random()*500);
        int y2 = (int)(Math.random()*500);
        int y3 = (int)(Math.random()*500);
        BossSummon b = new BossSummon((int)this.getX(), y, this.game);
        this.game.getCastle().getCastleTile().getEnemies().add(b);
        BossSummon b2 = new BossSummon((int)this.getX(), y2, this.game);
        this.game.getCastle().getCastleTile().getEnemies().add(b2);
        BossSummon b3 = new BossSummon((int)this.getX(), y3, this.game);
        this.game.getCastle().getCastleTile().getEnemies().add(b3);
        this.game.add(b.getBody());
        this.game.add(b2.getBody());
        this.game.add(b3.getBody());

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
