package structures;

<<<<<<< HEAD
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
=======
import acm.graphics.GImage;
import game.Structure;

public class Castle extends Structure {

	public Castle(int x, int y) {
		super(x, y);
		GImage castle = new GImage("media/Buildings/Castle2.0-1.png.png");
		castle.setLocation(x,y);
		castle.setSize(600,400);
		this.getObjects().add(castle);
>>>>>>> 2effe9371d09bbb3c15ebca325e70bcd2498caa4
	}
}
