package userinterface;

import java.awt.Font;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import game.Item;
import game.Player;
public class Hotbar {
    private GCompound Interface = new GCompound();
    static int inventoryInterfaceBoxSize = 50;
    private Inventory inventory;
    Player player;
    public Hotbar(Inventory inventory, Player player){
        this.inventory = inventory;
        this.player = player;
        //hotbar is just the first 10 items in the inventory
        for(int i = 0; i < 10; i++){
                GRect box = new GRect(i*inventoryInterfaceBoxSize, inventory.getScreenHeight()+inventoryInterfaceBoxSize-inventoryInterfaceBoxSize-(inventoryInterfaceBoxSize), inventoryInterfaceBoxSize, inventoryInterfaceBoxSize);
                if(inventory.getInventory().get(i) != null){
                GObject j = (GObject) inventory.getInventory().get(i).getItemBody().clone();
                j.setLocation(i*inventoryInterfaceBoxSize, inventory.getScreenHeight()+inventoryInterfaceBoxSize-inventoryInterfaceBoxSize-(inventoryInterfaceBoxSize));
                j.scale(0.7);
                Interface.add(j);
                Item item = inventory.getInventory().get(i);
                GLabel label = item.label;
                label.setLocation(i*inventoryInterfaceBoxSize, 500-inventoryInterfaceBoxSize-(i*inventoryInterfaceBoxSize)+20);
                Interface.add(label);
            }
            Interface.add(box);
        }
    }
    public void updateHotbar(){
        Interface.removeAll();
        int boxcount = 0;
        for(int i = 0; i < 10; i++){
            GRect box = new GRect(i*inventoryInterfaceBoxSize, inventory.getScreenHeight()+inventoryInterfaceBoxSize-inventoryInterfaceBoxSize-(inventoryInterfaceBoxSize), inventoryInterfaceBoxSize, inventoryInterfaceBoxSize);
            

            Interface.add(box);
        }
        for(int i = 0; i < Interface.getElementCount(); i++){
            if(Interface.getElement(i) instanceof GRect){
                boxcount++;
                if(boxcount == player.getSelectedHotbarSlot()+1){
                    ((GRect) Interface.getElement(i)).setFillColor(java.awt.Color.WHITE);
                    ((GRect) Interface.getElement(i)).setFilled(true);
                }
            }
        }


        for(int i = 0; i < 10; i++){
                if(inventory.getInventory().get(i) != null){
                GObject j = (GObject) inventory.getInventory().get(i).getItemBody().clone();    
                Item item = inventory.getInventory().get(i);
                j.setLocation(i*inventoryInterfaceBoxSize, inventory.getScreenHeight()+inventoryInterfaceBoxSize-inventoryInterfaceBoxSize-(inventoryInterfaceBoxSize));
                j.scale(0.7);
                Interface.add(j);
                if(item.label.getLabel() != ""){
				String text = "+"+item.label.getLabel();
				GLabel label = new GLabel(text);
                Font font = new Font("Arial", Font.BOLD, 20);
                label.setFont(font);
			    label.setLocation(i*inventoryInterfaceBoxSize, inventory.getScreenHeight()+inventoryInterfaceBoxSize-inventoryInterfaceBoxSize-(inventoryInterfaceBoxSize)+20);
				Interface.add(label);
                }

            }
        }
    }
    public GCompound getInterface(){
        return Interface;
    }
}
