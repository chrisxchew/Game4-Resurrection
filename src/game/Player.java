package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import acm.graphics.*;
import items.*;
import userinterface.Inventory;

public class Player {

    private double health;
    private double speed;
    private GCompound playerGCompound;
    private int x;
    private int y;
    private List<Integer> tile = new ArrayList<Integer>(2);
    private int playerHeight;
    private int playerWidth;
    private Item currentlyEquippedItem;
    private Inventory inventory;
    private boolean facingRight = false;
    GRect collisionRect;
    GRect collisionRect2;
    public Player(int spawnx, int spawny, int screenWidth, int screenHeight) {
        playerGCompound = new GCompound();
        this.inventory = new Inventory(40, screenHeight);
        //remove after testing
        GOval oval = new GOval(50, 50);
        oval.setFillColor(Color.black);
        oval.setFilled(true);
        Item item = new Sword();
        this.currentlyEquippedItem = item;
        playerGCompound.add(oval);
        playerGCompound.add(currentlyEquippedItem.getItemBody());
        

        collisionRect = new GRect(50,50);
        collisionRect2 = new GRect(50,50);
        playerGCompound.add(collisionRect);
        playerGCompound.add(collisionRect2);
        collisionRect.move(50, 0);
        collisionRect2.move(-50, 0);
        
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
    public boolean collidingWithEnemy(Enemy e) {
        if (
            e.getBody().getY() > this.y &&
            e.getBody().getY() < this.y + 50
        ) {
            if ((e.getBody().getX() > this.x + 50 &&
                    e.getBody().getX() < this.x + 100) ||
                (e.getBody().getX() > this.x - 50 &&
                    e.getBody().getX() < this.x)) {
                return true;
            }
        }
        return false;
    }
    public void attackPressed(Game game) {
    	if(this.getCurrentlyEquippedItem() instanceof Sword) {
    		for(Enemy e : game.getCurrentTile().getEnemies()) {
    			if(collidingWithEnemy(e)) {
     				e.knockback(-7);
     				e.setHealth(e.getHealth()-1);
    			}
    		}
    		
    		((Sword) this.getCurrentlyEquippedItem()).attackEvent(null);
    	}
    }
    
    public GPoint getPlayerCenter() {
    	GPoint output = new GPoint();
    	output.setLocation(this.x+(playerWidth/2), this.y+(playerHeight/2));
    	return output;
    }
    
    //moves player G Compound to player x and player y
    public void moveX(int val) {
    	if(val > 0) {
    		if(facingRight == false) {
        		this.currentlyEquippedItem.getItemBody().rotate(90);
    		}
    		this.facingRight = true;

    	}
    	if(val < 0) {
    		if(facingRight == true) {
        		this.currentlyEquippedItem.getItemBody().rotate(90);
    		}
    		this.facingRight = false;

    	}
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

	public Inventory getInventory() {
		return inventory;
	}

	public Item getCurrentlyEquippedItem() {
		return currentlyEquippedItem;
	}

	public void setCurrentlyEquippedItem(Item currentlyEquippedItem) {
		this.currentlyEquippedItem = currentlyEquippedItem;
	}

}