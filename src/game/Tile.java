package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import structures.Rock;
import acm.graphics.*;

public class Tile {
	private int screenWidth;
	private int screenHeight;
	private List<Integer> key;
	private ArrayList<GObject> objects = new ArrayList<GObject>();
	private ArrayList<Structure> structures = new ArrayList<Structure>();
	public ArrayList<GObject> getObjects() {
		return objects;
	}
	public void setObjects(ArrayList<GObject> objects) {
		this.objects = objects;
	}
	public Tile(int screenWidth, int screenHeight, List<Integer> key) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		for(int i = 0; i < screenWidth/10; i++) {
			for(int k = 0; k < screenHeight/10; k++) {
				GRect rectToAdd = new GRect(10,10);
				
				//For testing, remove in prod
				Random rand = new Random();
				int rand_int1 = rand.nextInt(50) + 40;
				int rand_int2 = rand.nextInt(40);
				rectToAdd.setFilled(true);
				rectToAdd.setColor(new Color(rand_int1, 153, rand_int2));
				rectToAdd.setFillColor(new Color(rand_int1, 153, rand_int2));
				
				rectToAdd.setLocation(i*10, k*10);
				objects.add(rectToAdd);
			}
		}
		for(int i = 0; i < 50; i++) {
			Random rnd = new Random();
			if(rnd.nextInt(50) == 5) {
				Rock rock = new Rock(rnd.nextInt(1000), rnd.nextInt(500));
				structures.add(rock);
				for(GObject obj : rock.getObjects()) {
					objects.add(obj);
				}
			}

		}

		this.key = key;
	}
	public List<Integer> getKey() {
		return key;
	}
	public void setKey(List<Integer> key) {
		this.key = key;
	}
	public String toString() {
		return(String.valueOf(key.get(0)) + " , " + String.valueOf(key.get(1)));
	}

}
