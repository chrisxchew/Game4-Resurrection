package items;

import acm.graphics.GImage;

public class Fireball extends Projectile{
    public Fireball(double x, double y, boolean isRight) {
        super(x, y, isRight);
        image = new GImage("");
        image.scale(5);
        speed = 10;
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
}
