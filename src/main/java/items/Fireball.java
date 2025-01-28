package items;

import game.Enemy;
import statuseffects.StatusEffectFire;

import java.util.ArrayList;

import enemy.Boss;
public class Fireball extends Projectile{
	SoundManager soundManage = new SoundManager();
    public Fireball(double x, double y, boolean isRight, ArrayList<Enemy> enemies) {
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
            image.setImage("media/Projectiles/Fireball/Fireball_FaceRight" + animationState + ".png");
        }else{
            image.setImage("media/Projectiles/Fireball/Fireball_FaceLeft" + animationState + ".png");
        }

    }
    @Override
    public void tick(){
        super.tick();
        if(loaded){
            for(Enemy e : enemies){
                if(!e.isDead()){
                    if(Math.abs(x - e.getX()) < 50 && Math.abs(y - e.getY()) < 50){
                        if(e instanceof Boss){
                            if(((Boss) e).isShielded()){
                                return;
                            }
                            }
                        e.setHealth(e.getHealth() - 3);
                        e.addStatusEffect(new StatusEffectFire(e));
                        e.knockback(-5);
                        image.setVisible(false);
                        loaded = false;
                        }    

                }
                }
                
            }
        }

    }

