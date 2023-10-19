package game;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.*;

public class Enemy {
    private GPolygon body;
    private double x;
    private double y;
    private boolean unloaded = false;
    public Enemy(int x, int y) {
    	this.x = x;
    	this.y = y;
        body = new GPolygon(x, y);
        body.addVertex(0, -25);
        body.addVertex(25, 25);
        body.addVertex(-25, 25);
        body.setColor(Color.red);
        body.setFilled(true);
    }
    public GObject getBody() {
        return body;
    }
    public void setBody(GPolygon body) {
        this.body = body;
    }
    public void moveX(double val) {
        this.x += val;
        body.move(val, 0);
    }

    public void moveY(double val) {
        this.y += val;
        body.move(0, val);
    }
    public void tickai(double targetx, double targety, ArrayList < Enemy > enemies) {
    	if(!this.unloaded) {
	    	if((this.x - targetx) != 0 ) {
	    		for(Enemy enemy : enemies) {
		    		//logic for collisions
	    		}
		        moveX(((this.x - targetx)/(Math.abs(this.x - targetx))) * -0.5);
	    	}
	    	if((this.y - targety) != 0) {
	    		moveY(((this.y - targety)/(Math.abs(this.y - targety))) * -0.5);
	    	}
    	}
    }
	public boolean isUnloaded() {
		return unloaded;
	}
	public void setUnloaded(boolean unloaded) {
		this.unloaded = unloaded;
	}
}