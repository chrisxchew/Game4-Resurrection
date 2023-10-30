package enemy;

import java.awt.Color;

import acm.graphics.GPolygon;
import acm.graphics.GRect;
import game.Enemy;

public class EnemyRect extends Enemy{

	public EnemyRect(int x, int y) {
		super(x, y);
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GRect body = new GRect(50,50);
		body.setFillColor(Color.BLUE);
		body.setFilled(true);
		this.bodyCompound.add(body,x,y);
	}
	
	@Override
	protected void deathEvent() {
		for(int i = 0; i < bodyCompound.getElementCount(); i++) {
			if(this.bodyCompound.getElement(i) instanceof GRect){
				((GRect) this.bodyCompound.getElement(i)).setFillColor(Color.black);	
			}
			this.unloaded=true;
		}
    }
}
