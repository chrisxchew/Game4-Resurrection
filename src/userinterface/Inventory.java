package userinterface;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;
import game.Item;

public class Inventory {
	static int inventoryInterfaceBoxSize = 25;
	private ArrayList<Item> inventory;
	private GCompound Interface = new GCompound();
	private int inventorySize;
	private int screenHeight;
	public Inventory(int inventorySize, int screenHeight) {
		this.screenHeight = screenHeight;
		this.inventorySize = inventorySize;
		this.inventory = new ArrayList<Item>();
		for(int i = 0; i < inventorySize/10; i++) {
			for(int j = 0; j < 10; j++) {
				Color c = new Color(0, 0, 0, 75);
				GRect box = new GRect(j*inventoryInterfaceBoxSize, screenHeight-25-(i*inventoryInterfaceBoxSize), inventoryInterfaceBoxSize, inventoryInterfaceBoxSize);
				box.setColor(c);
				box.setFillColor(c);
				box.setFilled(true);
				if(inventory.size()-1 >= (i*10) + j) {
					if(inventory.get((i*10) + j) != null){
						GObject itemtoAdd = ((Item) (inventory.get((i*10) + j))).getItemBody();
						Interface.add(itemtoAdd);
					}
				}

				Interface.add(box);
			}
		}
	}
	public void updateGraphicalInterface() {
		this.Interface.removeAll();
		for(int i = 0; i < inventorySize/10; i++) {
			for(int j = 0; j < 10; j++) {
				Color c = new Color(0, 0, 0, 75);
				GRect box = new GRect(j*inventoryInterfaceBoxSize, screenHeight-25-(i*inventoryInterfaceBoxSize), inventoryInterfaceBoxSize, inventoryInterfaceBoxSize);
				box.setColor(c);
				box.setFillColor(c);
				box.setFilled(true);
				if(inventory.size()-1 >= (i*10) + j) {
					if(inventory.get((i*10) + j) != null){
						GCompound itemtoAdd = (GCompound) (((Item) (inventory.get((i*10) + j))).getItemBody()).clone();
						itemtoAdd.setLocation(j*inventoryInterfaceBoxSize, screenHeight-25-(i*inventoryInterfaceBoxSize));
						itemtoAdd.scale(0.4);
						
						Interface.add(itemtoAdd);
					}
				}

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
