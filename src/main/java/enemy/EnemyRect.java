package enemy;


import java.util.ArrayList;

import acm.graphics.GImage;
import game.*;
import items.Cherries;
public class EnemyRect extends Enemy{
	private Item cherry;
	public EnemyRect(int x, int y, Game game) {
		super(x, y, game);
		cherry = new Cherries();
		this.drops.add(cherry);
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage("media/Characters/Blocka/Blocka_FaceFront.png");
		body.setSize(50,50);
		this.bodyCompound.add(body,x-25,y-25);
	}
	
	@Override
	protected void deathEvent(ArrayList<Enemy> enemies) {
		isDead = true;
		for(int i = 0; i < bodyCompound.getElementCount(); i++) {
				this.bodyCompound.getElement(i).setVisible(false);	
				this.isDead = true;
				cherry.getItemBody().setLocation(this.bodyCompound.getElement(0).getX(), this.bodyCompound.getElement(0).getY());
				this.bodyCompound.removeAll();
				this.bodyCompound.add(cherry.getItemBody());
		}
    }

	@Override
	protected Item calculateDrop() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'calculateDrop'");
	}
}
