package userinterface;
import acm.graphics.*;
public class HealthPoints {
    private GCompound healthPointsIcons;
    public HealthPoints(){
        //The player will start with 5 health, can change later
        healthPointsIcons = new GCompound();
        for(int i = 0; i < 5; i++){
            GImage healthPoint = new GImage("media/UI/Heart/heart.png");
            healthPoint.setSize(healthPoint.getWidth()*2, healthPoint.getHeight()*2);
            healthPoint.setLocation(1000-healthPoint.getWidth()*(i+1), 500-healthPoint.getHeight());
            healthPointsIcons.add(healthPoint);
        }
    }

    public GCompound getHealthPointsIcons(){
        return healthPointsIcons;
    }
    public void updateHealthPointsIcons(int health){
        //player starts with 20 health, 19 health is 4 hearts and one 3/4 heart and so on
        healthPointsIcons.removeAll();
        for(int i = 0; i < health/4; i++){
            GImage healthPoint = new GImage("media/UI/Heart/Heart.png");
            healthPoint.setSize(healthPoint.getWidth()*2, healthPoint.getHeight()*2);
            healthPoint.setLocation(1000-healthPoint.getWidth()*(i+1), 500-healthPoint.getHeight());
            healthPointsIcons.add(healthPoint);
        }
        if(health%4 == 3){
            GImage healthPoint = new GImage("media/UI/Heart/Heart_Three_Quarters.png");
            healthPoint.setSize(healthPoint.getWidth()*2, healthPoint.getHeight()*2);
            healthPoint.setLocation(1000-healthPoint.getWidth()*(health/4+1), 500-healthPoint.getHeight());
            healthPointsIcons.add(healthPoint);
        }
        if(health%4 == 2){
            GImage healthPoint = new GImage("media/UI/Heart/Heart_Half.png");
            healthPoint.setSize(healthPoint.getWidth()*2, healthPoint.getHeight()*2);
            healthPoint.setLocation(1000-healthPoint.getWidth()*(health/4+1), 500-healthPoint.getHeight());
            healthPointsIcons.add(healthPoint);
        }
        if(health%4 == 1){
            GImage healthPoint = new GImage("media/UI/Heart/Heart_One_Quarter.png");
            healthPoint.setSize(healthPoint.getWidth()*2, healthPoint.getHeight()*2);
            healthPoint.setLocation(1000-healthPoint.getWidth()*(health/4+1), 500-healthPoint.getHeight());
            healthPointsIcons.add(healthPoint);
        }
    }

}
