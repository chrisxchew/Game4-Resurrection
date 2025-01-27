package statuseffects;

import acm.graphics.GImage;
import game.Enemy;

public class StatusEffectIce  extends StatusEffect{
    public StatusEffectIce(Enemy owner) {
        this.owner = owner;
        this.duration = 350;
        this.timeLeft = duration;
        this.imageEffect = new GImage("media/StatusEffects/Ice.png");
        imageEffect.setSize(50,50);
        imageEffect.setLocation(owner.getBody().getElement(0).getLocation().getX(),owner.getBody().getElement(0).getLocation().getY());
        owner.getBody().add(imageEffect);
        owner.setVelocityMultiplier(0);
    }
    @Override
    public void tick() {
        owner.setVelocityMultiplier(0);
        timeLeft --;     
        if(timeLeft <= 0){
            owner.setVelocityMultiplier(-2);
            owner.addStatusEffect(null);
            owner.getBody().remove(imageEffect);
        }
         
    }
    
}
