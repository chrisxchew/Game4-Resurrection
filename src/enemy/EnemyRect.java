package enemy;

import java.awt.Color;

import acm.graphics.GRect;
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
		GRect body = new GRect(50,50);
		body.setFillColor(Color.BLUE);
		body.setFilled(true);
		this.bodyCompound.add(body,x-25,y-25);
	}
	
	@Override
	protected void deathEvent() {
		for(int i = 0; i < bodyCompound.getElementCount(); i++) {
			if(this.bodyCompound.getElement(i) instanceof GRect){
				((GRect) this.bodyCompound.getElement(i)).setFillColor(Color.black);	
				
				//turn enemy into a cherry

	


				this.isDead = true;
				cherry.getItemBody().setLocation(this.bodyCompound.getElement(0).getX(), this.bodyCompound.getElement(0).getY());
				this.bodyCompound.removeAll();

				this.bodyCompound.add(cherry.getItemBody());
				
			}
		}
    }
}
