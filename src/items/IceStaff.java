package items;

import java.util.ArrayList;

import acm.graphics.*;
import game.Enemy;
import game.Game;
import game.Item;

public class IceStaff extends Item implements Ranged{
	public IceStaff() {

		GImage image = new GImage("media/Items/Weapons/IceStaff/IceStaff.png");
		GImage imageReversed = new GImage("media/Items/Weapons/IceStaff/IceStaff_reversed_view.png");

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
	
