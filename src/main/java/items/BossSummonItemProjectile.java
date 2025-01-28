package items;

import game.Enemy;

import java.util.ArrayList;

import enemy.Boss;
import enemy.BossSummon;
public class BossSummonItemProjectile extends Projectile{
SoundManager soundManage = new SoundManager();
    public BossSummonItemProjectile(double x, double y, boolean isRight, ArrayList<Enemy> enemies) {
        super(x, y, isRight , enemies);

        image.scale(5);
        speed = 10;
        soundManage.init();
        soundManage.shortSound("fire");
    }
    @Override
    public void animate(){
        if(animationState >= 3){
            animationState = 1;
        }
        else{
            animationState++;
        }
        if(isRight){
            image.setImage("media/Items/Weapons/BossSummonItem.png");
        }else{
            image.setImage("media/Items/Weapons/BossSummonItemRight.png");
        }

    }
    @Override
    public void tick(){
        super.tick();
        if(loaded){
            for(Enemy e : enemies){
                //if fireball is a certain distance from enemies center
                if(!e.isDead()){
                    //if the projectile hit the boss shield
                    //we can check this by seeing 200 radius around the boss
                    if(e instanceof Boss){
                        if(Math.abs(x - e.getX()) < 200 && Math.abs(y - e.getY()) < 200){
                            Boss b = (Boss) e;
                            b.setShieldHealth(b.getShieldHealth() - 1);
                            image.setVisible(false);
                            loaded = false;
                        }
                    }

                    if(Math.abs(x - e.getX()) < 50 && Math.abs(y - e.getY()) < 50){
                            if(!(e instanceof BossSummon)){
                                e.setHealth(e.getHealth() - 8);
                                image.setVisible(false);
                                loaded = false;
                            

                        }
                    }
                }
                
            }
        }

    }
}
