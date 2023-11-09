package userinterface;
import acm.graphics.*;
public class HealthPoints {
    private GCompound healthPointsIcons;
    public HealthPoints(){
        //The player will start with 5 health, can change later
        healthPointsIcons = new GCompound();
        for(int i = 0; i < 5; i++){
            GImage healthPoint = new GImage("media/UI/heart.png");
            healthPoint.setSize(healthPoint.getWidth()*2, healthPoint.getHeight()*2);
            healthPoint.setLocation(healthPoint.getWidth()*i+275, 500-healthPoint.getHeight());
            healthPointsIcons.add(healthPoint);
        }
    }

    public GCompound getHealthPointsIcons(){
        return healthPointsIcons;
    }

}
