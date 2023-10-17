package structures;

import java.awt.Color;

import acm.graphics.GOval;
import game.Structure;

public class Rock extends Structure{

	public Rock(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		GOval rockBody = new GOval(x,y, 25,25);
		rockBody.setColor(Color.GRAY);
		rockBody.setFilled(true);
		this.getObjects().add(rockBody);
	}

}
