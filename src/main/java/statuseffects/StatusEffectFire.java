package statuseffects;

import acm.graphics.GImage;
import game.Enemy;

public class StatusEffectFire  extends StatusEffect{
    public StatusEffectFire(Enemy owner) {
        this.owner = owner;
        this.duration = 350;
        this.timeLeft = duration;
        this.imageEffect = new GImage("media/StatusEffects/Fire1.png");
        imageEffect.setSize(50,50);
        imageEffect.setLocation(owner.getBody().getElement(0).getLocation().getX(),owner.getBody().getElement(0).getLocation().getY());
        owner.getBody().add(imageEffect);
    }
    @Override
    public void tick() {
        timeLeft --;
        //fire image needs to change, we have image 1-6
        if(timeLeft % 100 == 0){
            owner.setHealth(owner.getHealth() - 1);
        }if(timeLeft % 10 == 0){
            int imageNumber = (int) (Math.random() * 6) + 1;
            imageEffect.setImage("media/StatusEffects/Fire" + imageNumber + ".png");
            imageEffect.setSize(50,50);
        }


        
        if(timeLeft <= 0){
            owner.addStatusEffect(null);
            owner.getBody().remove(imageEffect);
        }
         
    }
    
}
