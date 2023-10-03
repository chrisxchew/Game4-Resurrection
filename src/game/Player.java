package game;

import acm.graphics.*;
import acm.util.*;
import acm.program.*;

public class Player {
	
	private double health;
	private double speed;
	private GCompound playerGCompound;
	


	public Player() {
		//TODO complete constructor
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
	

	
}

