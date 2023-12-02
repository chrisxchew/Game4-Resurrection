package items;

import acm.graphics.GImage;
import game.Item;
import userinterface.ToolTip;
public class Cherries extends Item{
    private GImage cherriesImage;
    public Cherries() {
        this.toolTip = new ToolTip("Interact to heal 1 heart", this);
        cherriesImage = new GImage("media/Items/Cherries_Icon.png");
        cherriesImage.setSize(cherriesImage.getWidth()*3, cherriesImage.getHeight()*3);
        cherriesImage.setLocation(cherriesImage.getLocation().getX(),cherriesImage.getLocation().getY());
        this.getItemBody().add(cherriesImage);
    }

    public GImage getCherriesImage() {
        return cherriesImage;
    }
}
