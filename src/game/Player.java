package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import acm.graphics.*;

public class Player {

    private double health;
    private double speed;
    private GCompound playerGCompound;
    private int x;
    private int y;
    private List<Integer> tile = new ArrayList<Integer>(2);
    private int playerHeight;
    private int playerWidth;



	/*
    Do we want to make a coord or location class?
    We are gonna be dealing with x-y values a lot, this could possibly be helpful.
    It will involve a lot of switching, especially for calling functions
    Something like this: 
    
    player.setX(50);
    player.setY(50);
    
    and for getting (maybe an explosion kb-ed the player):
    
    player.setX(player.getX() + 50);
    player.setY(player.gety() + 50);
    
    or if we are calcing if a attack hit
    
    if(player.getX() > value && player.getY() > value){
    	doDamage();
    }
    
    Versus:
    
    player.coord.setX(50);
    player.coord.setY(50);
    
    player.coord.setX(player.getX() + 50);
    player.coord.setY(player.gety() + 50);
    
    if(player.coord.getX() > value && player.coord.getY() > value){
    	doDamage();
    }
    
    Even though operations like these seem like a lot, we can do helper functions in coord class
    something like:
    
    public class coord(){
    	public void changeX(int val){
    	this.x += val;
    	}
    	
    	public void knockback(int theta, int strength){
    		this.x += (some fancy trig)*strength
    		this.y += (some more fancy trig)* strength
    	}
    }
    
    After weighing the pros n cons lmk what yall want
    */
    public Player(int spawnx, int spawny) {
        playerGCompound = new GCompound();
        
        //remove after testing
        GOval oval = new GOval(50, 50);
        oval.setFillColor(Color.black);
        oval.setFilled(true);
        
        playerGCompound.add(oval);
        playerGCompound.setLocation(spawnx, spawny);
        this.x = spawnx;
        this.y = spawny;
        this.tile.add(null);
        this.tile.add(null);
        this.tile.set(0, 0);
        this.tile.set(1, 0);
        playerWidth = 50;
        playerHeight = 50;
    }

    //moves player G Compound to player x and player y
    public void moveX(int val) {
        this.x += val;
        playerGCompound.move(val, 0);
    }

    public void moveY(int val) {
        this.y += val;
        playerGCompound.move(0, val);
    }
    
    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    //Deals damage to the player, 
    //deducting amount "damage" from the players health
    public void dealDamage(double damage) {
        this.health = this.health - damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GCompound getPlayerGCompound() {
        return playerGCompound;
    }

    public void setPlayerGCompound(GCompound playerGCompound) {
        this.playerGCompound = playerGCompound;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.playerGCompound.setLocation(x, this.playerGCompound.getLocation().getY());
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.playerGCompound.setLocation(this.playerGCompound.getLocation().getX(), y);
    }

    public List<Integer> getTile() {
        return tile;
    }

    public void setTile(List<Integer> tile) {
        this.tile = tile;
    }
    
    public int getPlayerHeight() {
		return playerHeight;
	}

	public void setPlayerHeight(int playerHeight) {
		this.playerHeight = playerHeight;
	}

	public int getPlayerWidth() {
		return playerWidth;
	}

	public void setPlayerWidth(int playerWidth) {
		this.playerWidth = playerWidth;
	}

}