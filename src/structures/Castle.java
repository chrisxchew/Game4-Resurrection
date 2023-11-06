package structures;

import acm.graphics.GRect;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import game.Structure;

public class Castle extends Structure{
	public static final int RECT_SIZE_W = 100;
	public static final int RECT_SIZE_H = 100;
	
	public Castle(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public boolean createCastle() {
		return true;
	}
	public void createWalls() {
		GRect block = new GRect(RECT_SIZE_W, RECT_SIZE_H);
	}
}
