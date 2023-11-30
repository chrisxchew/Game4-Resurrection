package items;

import java.util.ArrayList;

import acm.graphics.GImage;
import game.Enemy;
import game.Game;
import game.Item;
public class BossSummonItem extends Item implements Ranged{
    private GImage image;
    public BossSummonItem() {

        GImage image = new GImage("media/Items/Weapons/BossSummonItemRight.png");
        GImage imageRight = new GImage("media/Items/Weapons/BossSummonItem.png");
        image.setSize(75,75);
        imageRight.setSize(75,75);
        image.setLocation(image.getLocation().getX(),image.getLocation().getY());
        this.getItemBody().add(image);
        this.getItemBodyRight().add(imageRight);
        
    }

    public GImage getArrowImage() {
        return image;
    }

    @Override
    public void attackEvent(ArrayList<Enemy> enemies, boolean isRight, double x, double y, Game game) {
		BossSummonItemProjectile ice_gem = new BossSummonItemProjectile(x, y, isRight, enemies);
		game.getProjectiles().add(ice_gem);
		game.getGraphicsProgram().add(ice_gem.getImage());
        game.getPlayer().removeItemInHand();
        game.getPlayer().setCurrentlyEquippedItem(null);
        game.getPlayer().getInventory().getInventory().remove(this);
        game.getPlayer().getInventory().updateGraphicalInterface();
        game.getHotbar().updateHotbar();

    }
}
