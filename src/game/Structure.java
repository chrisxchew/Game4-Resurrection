package game;

import java.util.ArrayList;

import acm.graphics.GObject;
import acm.graphics.GLine;

public abstract class Structure {
	private ArrayList<GObject> objects = new ArrayList<GObject>();
	private ArrayList<GLine> colliders = new ArrayList<GLine>();
	private int x;
	private int y;
	
	public Structure(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ArrayList<GObject> getObjects() {
		return objects;
	}
	public ArrayList<GLine> getColliders(){
		return colliders;
	}
	
	
	
}
