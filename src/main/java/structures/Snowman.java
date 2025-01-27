package structures;
import acm.graphics.GImage;


import game.Structure;

public class Snowman extends Structure{
	public Snowman(int x, int y) {
		super (x, y);
		
		GImage snowman = new GImage("media/terrain/snowman_4_winter_biome.png");
		snowman.setLocation(x, y);
		snowman.setSize(50, 60);
		this.getObjects().add(snowman);
	}
}