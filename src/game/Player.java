package game;

import acm.graphics.*;

public class Player {

    private double health;
    private double speed;
    private GCompound playerGCompound;
    private int x;
    private int y;
    private int[] tile = new int[2];

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
        playerGCompound.add(new GOval(50, 50));
        playerGCompound.setLocation(spawnx, spawny);
        this.x = spawnx;
        this.y = spawny;
        this.tile[0] = 0;
        this.tile[1] = 0;
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

    public int[] getTile() {
        return tile;
    }

    public void setTile(int[] tile) {
        this.tile = tile;
    }

}