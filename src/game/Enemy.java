package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;

public class Enemy implements ActionListener{
	protected ArrayList<Item> drops = new ArrayList<Item>();
	protected GCompound bodyCompound;
    private double x;
    private double y;
	protected boolean isDead;
    private int health = 5;
	protected Game game;
    Timer timer;
    double velocityMultiplier = -2;
    protected boolean unloaded = false;
    public Enemy(int x, int y, Game game) {
    	bodyCompound = new GCompound();
    	this.x = x;
    	this.y = y;
		this.game = game;
        addObjectsToCompound(x,y);
    	this.timer = new Timer(10, this);
    }

	protected void addObjectsToCompound(int x, int y) {
    	GPolygon body;
        body = new GPolygon();
        body.addVertex(0, -25);
        body.addVertex(25, 25);
        body.addVertex(-25, 25);
        body.setFillColor(Color.red);
        body.setFilled(true);
        
        this.bodyCompound.add(body,x,y);
    }
    public GObject getBody() {
        return bodyCompound;
    }
    public void setBody(GCompound body) {
        this.bodyCompound = body;
    }
    public void moveX(double val) {
        this.x += val;
        bodyCompound.move(val, 0);
    }

    public void moveY(double val) {
        this.y += val;
        bodyCompound.move(0, val);
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
    
    protected void deathEvent() {
		for(int i = 0; i < bodyCompound.getElementCount(); i++) {
			if(this.bodyCompound.getElement(i) instanceof GPolygon){
				((GPolygon) this.bodyCompound.getElement(i)).setFillColor(Color.black);	
			}
		}
    }
    
    public void tickai(double targetx, double targety, ArrayList < Enemy > enemies) {
    	if(!this.unloaded) {
			if(this.isDead){
				if(Math.abs(this.x - targetx) < 100 && Math.abs(this.y - targety) < 100){
					if((this.x - targetx) != 0 ) {
						moveX(((this.x - targetx)/(Math.abs(this.x - targetx))) * -1);
					}
					if((this.y - targety) != 0) {
						moveY(((this.y - targety)/(Math.abs(this.y - targety))) * -1);
					}
				}
				if(checkCollision(targetx, targety)){
					this.game.getPlayer().getInventory().addAll(drops);
					System.out.println(this.game.getPlayer().getInventory().getInventory());
					this.bodyCompound.removeAll();
					this.unloaded = true;
				}
			}
    		else if(this.health <= 0) {
    			deathEvent();

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
	
	public boolean checkCollision(double targetx, double targety){
		//if 25 pixels away from target, return true else return false
		if(Math.abs(this.x - targetx) < 25 && Math.abs(this.y - targety) < 25){
			return true;
		}return false;
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
    public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}