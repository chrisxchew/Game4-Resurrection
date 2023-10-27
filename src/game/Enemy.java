package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;

public class Enemy implements ActionListener{
    private GPolygon body;
    private double x;
    private double y;
    private int health = 5;
    Timer timer;
    double velocityMultiplier = -2;
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
        
    	this.timer = new Timer(10, this);
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
    public void knockback(double mulitplier) {
    	
    	velocityMultiplier = velocityMultiplier * mulitplier;
    	if(timer != null) {
    		this.timer.stop();
    	}

    	timer.start();
    }
    @Override
	public void actionPerformed(ActionEvent e) {
    	velocityMultiplier-=0.5;
    	if(velocityMultiplier <= -2) {
    		this.timer.stop();
    		velocityMultiplier = -2;
    	}
    }
    public void tickai(double targetx, double targety, ArrayList < Enemy > enemies) {
    	if(!this.unloaded) {
    		if(this.health <= 0) {
    			this.body.setColor(Color.black);
    		}else {
        		if((this.x - targetx) != 0 ) {
    		        moveX(((this.x - targetx)/(Math.abs(this.x - targetx))) * velocityMultiplier);
    	    	}
    	    	if((this.y - targety) != 0) {
    	    		moveY(((this.y - targety)/(Math.abs(this.y - targety))) * velocityMultiplier);
    	    	}
    		}

    	}
    }
	public boolean isUnloaded() {
		return unloaded;
	}
	public void setUnloaded(boolean unloaded) {
		this.unloaded = unloaded;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}