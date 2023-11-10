package userinterface;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GObject;
import acm.graphics.GRect;
import game.Item;

public class Inventory {
	static int inventoryInterfaceBoxSize = 50;
	private ArrayList<Item> inventory;
	private GCompound Interface = new GCompound();
	private int inventorySize;
	private int screenHeight;
	public Inventory(int inventorySize, int screenHeight) {
		this.screenHeight = screenHeight;
		this.inventorySize = inventorySize;
		this.inventory = new ArrayList<Item>();
		for(int i = 0; i < inventorySize; i++) {
			inventory.add(null);
		}
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
				GRect box = new GRect(j*inventoryInterfaceBoxSize, screenHeight-inventoryInterfaceBoxSize-(i*inventoryInterfaceBoxSize), inventoryInterfaceBoxSize, inventoryInterfaceBoxSize);
				box.setColor(c);
				box.setFillColor(c);
				box.setFilled(true);
				if(inventory.size()-1 >= (i*10) + j) {
					if(inventory.get((i*10) + j) != null){
						GCompound itemtoAdd = (GCompound) (((Item) (inventory.get((i*10) + j))).getItemBody()).clone();
						itemtoAdd.setLocation(j*inventoryInterfaceBoxSize, screenHeight-inventoryInterfaceBoxSize-(i*inventoryInterfaceBoxSize));
						itemtoAdd.scale(0.7);
						
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
	public void add(Item item) {
		//find first non null item and set it to input item
		for(int i = 0; i < this.inventory.size(); i++) {
			if(this.inventory.get(i) == null) {
				this.inventory.set(i, item);
				break;
			}
		}
		this.updateGraphicalInterface();
	}
	public void remove(Item item) {
		this.inventory.remove(item);
		this.updateGraphicalInterface();
	}
	public void addAll(ArrayList<Item> items) {
		for(Item item: items) {
			this.add(item);
		}
		this.updateGraphicalInterface();
	}
	public int getInventorySize() {
		return inventorySize;
	}
	public Item getClickedItem(int x, int y) {
		int xIndex = x/inventoryInterfaceBoxSize;
		int yIndex = (screenHeight-y)/inventoryInterfaceBoxSize;
		return this.inventory.get((yIndex*10) + xIndex);
	}
	public int getClickedIndex(int x,int y){
		int xIndex = x/inventoryInterfaceBoxSize;
		int yIndex = (screenHeight-y)/inventoryInterfaceBoxSize;
		return (yIndex*10) + xIndex;
	}
	public void setSpecificItem(int index, Item item) {
		this.inventory.set(index, item);
	}
	public GCompound getInterface(){
		return this.Interface;
	}
}
