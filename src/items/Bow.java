package items;

import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Game;
import game.Item;
import userinterface.Inventory;
import userinterface.ToolTip;

public class Bow extends Item implements Ranged{
	public Bow() {
		this.name = "Bow";
		this.toolTip = new ToolTip("A bow that shoots arrows. Does 10 damage per hit.", this);
		GImage image = new GImage("media/Items/Weapons/Bow/Bow_FaceLeft.png");
		GImage imageRight = new GImage("media/Items/Weapons/Bow/Bow_FaceRight.png");

		image.setSize(75,75);
		imageRight.setSize(75,75);
		this.getItemBody().add(image);
		this.getItemBodyRight().add(imageRight);
	}

	@Override
	public void attackEvent(ArrayList<Enemy> enemies, boolean isRight, double x, double y, Game game) {
		Inventory inventory = game.getPlayer().getInventory();
		for(Item i : inventory.getInventory()){
			if(i instanceof Arrow){
				inventory.remove(i);
				inventory.updateGraphicalInterface();
				game.getHotbar().updateHotbar();
				ArrowProjectile arrow = new ArrowProjectile(x, y, isRight, enemies);
				game.getProjectiles().add(arrow);
				game.getGraphicsProgram().add(arrow.getImage());
				break;
			}
		}
		

	}
	
}
	
