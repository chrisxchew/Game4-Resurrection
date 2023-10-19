package userinterface;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import game.Item;

public class Inventory {
	static int inventoryInterfaceBoxSize = 25;
	private ArrayList<Item> inventory;
	private GCompound Interface = new GCompound();
	public Inventory(int inventorySize, int screenHeight) {
		this.inventory = new ArrayList<Item>();
		for(int i = 0; i < inventorySize/10; i++) {
			for(int j = 0; j < 10; j++) {
				Color c = new Color(0, 0, 0, 75);
				GRect box = new GRect(j*inventoryInterfaceBoxSize, screenHeight-25-(i*inventoryInterfaceBoxSize), inventoryInterfaceBoxSize, inventoryInterfaceBoxSize);
				box.setColor(c);
				box.setFillColor(c);
				box.setFilled(true);
				Interface.add(box);
			}
		}
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	public GCompound getGraphicalInterface() {
		return this.Interface;
	}
	
}
