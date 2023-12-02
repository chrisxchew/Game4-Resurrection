package items;

import acm.graphics.GImage;
import game.Item;
import userinterface.ToolTip;
public class Arrow extends Item{
    private GImage arrowImage;
    public Arrow() {
        this.name = "Arrow";
        this.toolTip = new ToolTip("An arrow. Can only be used in a bow", this);
        arrowImage = new GImage("media/Projectiles/Arrow.png");
        arrowImage.setSize(arrowImage.getWidth()*3, arrowImage.getHeight()*3);
        arrowImage.setLocation(arrowImage.getLocation().getX(),arrowImage.getLocation().getY());
        this.getItemBody().add(arrowImage);
        
    }

    public GImage getArrowImage() {
        return arrowImage;
    }
}
