package game;

import java.awt.Color;

import acm.graphics.*;

public class Enemy {
    private GPolygon body;
    private double x = 500;
    private double y = 300;

    public Enemy() {
        body = new GPolygon(500, 300);
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
    public void tickai(double targetx, double targety) {
    	if((this.x - targetx) != 0 ) {
	        moveX(((this.x - targetx)/(Math.abs(this.x - targetx))) * -0.5);
    	}
    	if((this.y - targety) != 0) {
    		moveY(((this.y - targety)/(Math.abs(this.y - targety))) * -0.5);
    	}
    }
}