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
        image.setSize(50,50);
        imageRight.setSize(50,50);
        image.setLocation(image.getLocation().getX()+30,image.getLocation().getY()+10);
        imageRight.setLocation(imageRight.getLocation().getX()-20,imageRight.getLocation().getY()+10);
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
        game.getPlayer().getInventory().getInventory().remove(this);
        game.getPlayer().getInventory().updateGraphicalInterface();
        game.getPlayer().updateCurrentItemInHand();
        game.getHotbar().updateHotbar();
    

    }
}
