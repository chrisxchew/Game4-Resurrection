package items;

import acm.graphics.GImage;
import game.Item;
public class SecretItem extends Item{
    private GImage cherriesImage;
    public SecretItem() {

        cherriesImage = new GImage("media/Items/75752.png");
        cherriesImage.setSize(cherriesImage.getWidth()/9, cherriesImage.getHeight()/9);
        cherriesImage.setLocation(cherriesImage.getLocation().getX(),cherriesImage.getLocation().getY());
        this.getItemBody().add(cherriesImage);
        
    }

    public GImage getCherriesImage() {
        return cherriesImage;
    }
}
