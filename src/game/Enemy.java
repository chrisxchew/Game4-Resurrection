package game;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.LocalDateTime.*;

import acm.graphics.*;

public class Enemy {
    private GPolygon body;
    private int x = 500;
    private int y = 300;

    public Enemy() {
        body = new GPolygon(500, 300);
        body.addVertex(0, -50);
        body.addVertex(25, 0);
        body.addVertex(-25, 0);
        body.addArc(0, 0, 0, 0);
        body.setColor(Color.red);
        body.setFilled(true);
    }
    public GObject getBody() {
        return body;
    }
    public void setBody(GPolygon body) {
        this.body = body;
    }
    public void moveX(int val) {
        this.x += val;
        body.move(val, 0);
    }

    public void moveY(int val) {
        this.y += val;
        body.move(0, val);
    }
    public void chace(int targetx, int targety) {
    	if((this.x - targetx) != 0 ) {
	        moveX((this.x - targetx)/Math.abs((this.x - targetx)) *-1);
	        
    	}
    	if((this.y - targety) != 0) {
    		moveY((this.y - targety)/Math.abs((this.y - targety))*-1);
    	}
    }
}