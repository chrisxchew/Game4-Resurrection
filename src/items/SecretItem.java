package items;

import acm.graphics.GImage;
import game.Item;
import userinterface.ToolTip;
public class SecretItem extends Item{
    private GImage cherriesImage;
    public SecretItem() {
        this.name = "Sebastian Dziallas";
        this.toolTip = new ToolTip("Sebastian Dziallas", this);
        cherriesImage = new GImage("media/Items/75752.png");
        cherriesImage.setSize(cherriesImage.getWidth()/9, cherriesImage.getHeight()/9);
        cherriesImage.setLocation(cherriesImage.getLocation().getX(),cherriesImage.getLocation().getY());
        this.getItemBody().add(cherriesImage);
        
    }

    public GImage getCherriesImage() {
        return cherriesImage;
    }
}
