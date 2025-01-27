package items;

import acm.graphics.GImage;
import game.Enemy;
import java.util.ArrayList;
public abstract class Projectile {
    protected boolean isRight;
    protected int animationState = 1;
    protected double x;
    protected double y;
    protected GImage image;
    protected double speed;
    protected ArrayList <Enemy> enemies;
    protected boolean loaded = true;
    public Projectile(double x, double y, boolean isRight, ArrayList<Enemy> enemies) {
        this.x = x;
        this.y = y;
        this.isRight = isRight;
        this.enemies = enemies;
        image = new GImage("");
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public boolean getIsRight() {
        return isRight;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
    	this.y = y;
    }
    public void setIsRight(boolean isRight) {
    	this.isRight = isRight;
    }
    public GImage getImage(){
        return image;
    }
    public void animate(){
        if(loaded){
            if(animationState >= 3){
                animationState = 1;
            }
            else{
                animationState++;
            }
        }


    }
    public void tick(){
        if(loaded){
            if(isRight){
                x += speed;
                image.setLocation(x, y);
                if(x > 1500){
                    image.setVisible(false);
                }

            }else{
                x -= speed;
                image.setLocation(x, y);
                if(x < -500){
                    image.setVisible(false);
                }
            }
        }

    }
}
