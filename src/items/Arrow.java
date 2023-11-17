package items;

import acm.graphics.GImage;
import game.Item;
public class Arrow extends Item{
    private GImage arrowImage;
    public Arrow() {

        arrowImage = new GImage("media/Projectiles/Arrow.png");
        arrowImage.setSize(arrowImage.getWidth()*3, arrowImage.getHeight()*3);
        arrowImage.setLocation(arrowImage.getLocation().getX(),arrowImage.getLocation().getY());
        this.getItemBody().add(arrowImage);
        
    }

    public GImage getArrowImage() {
        return arrowImage;
    }
}
