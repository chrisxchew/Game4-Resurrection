package items;

import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Game;
import game.Item;
import userinterface.ToolTip;

public class IceStaff extends Item implements Ranged{
	public IceStaff() {
		this.name = "Ice Staff";
		this.toolTip = new ToolTip("A staff that shoots ice shards. Does 3 damage per hit.", this);
		GImage image = new GImage("media/Items/Weapons/IceStaff/iceStaff_reversed_view.png");
		GImage imageReversed = new GImage("media/Items/Weapons/IceStaff/iceStaff.png");

		image.setSize(75,75);	
		imageReversed.setSize(75,75);
		this.getItemBody().add(image);
		this.getItemBodyRight().add(imageReversed);
	}

	@Override
	public void attackEvent(ArrayList<Enemy> enemies, boolean isRight, double x, double y, Game game) {
		iceGem ice_gem = new iceGem(x, y, isRight, enemies);
		game.getProjectiles().add(ice_gem);
		game.getGraphicsProgram().add(ice_gem.getImage());
	}
	
}
	
