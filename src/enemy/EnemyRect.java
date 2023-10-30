package enemy;

import java.awt.Color;

import acm.graphics.GRect;
import game.Enemy;

public class EnemyRect extends Enemy{

	public EnemyRect(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GRect body = new GRect(50,50);
		body.setFillColor(Color.BLUE);
		body.setFilled(true);
		this.bodyCompound.add(body,x,y);
	}
}
