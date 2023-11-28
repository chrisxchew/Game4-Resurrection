package items;

import game.Enemy;
import statuseffects.StatusEffectIce;

import java.util.ArrayList;
public class iceGem extends Projectile{

    public iceGem(double x, double y, boolean isRight, ArrayList<Enemy> enemies) {
        super(x, y, isRight , enemies);

        image.scale(3);
        speed = 10;
    }
    @Override
    public void animate(){
        if(animationState >= 2){
            animationState = 1;
        }
        else{
            animationState++;
        }
        if(isRight){
            image.setImage("media/Projectiles/iceGem/iceGemAnimation_" + animationState + ".png");
        }else{
            image.setImage("media/Projectiles/iceGem/iceGemAnimation_" + animationState + ".png");
        }

    }
    @Override
    public void tick(){
        super.tick();
        if(loaded){
            for(Enemy e : enemies){
                //if the iceGem is a certain distance from enemies center
                if(!e.isDead()){
                    if(Math.abs(x - e.getX()) < 50 && Math.abs(y - e.getY()) < 50){
                        e.setHealth(e.getHealth() - 3);
                        e.knockback(-5);
                        image.setVisible(false);
                        loaded = false;
                        e.addStatusEffect(new StatusEffectIce(e));
                }
                }
                
            }
        }

    }
}
