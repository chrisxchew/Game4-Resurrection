package userinterface;

import acm.graphics.GCompound;
import acm.graphics.GObject;
import acm.graphics.GRect;
import game.*;
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
            GObject j = (GObject) inventory.getInventory().get(i).getItemBody().clone();
            j.setLocation(i*inventoryInterfaceBoxSize, inventory.getScreenHeight()+inventoryInterfaceBoxSize-inventoryInterfaceBoxSize-(inventoryInterfaceBoxSize));
                        j.scale(0.7);
            Interface.add(j);
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
                j.setLocation(i*inventoryInterfaceBoxSize, inventory.getScreenHeight()+inventoryInterfaceBoxSize-inventoryInterfaceBoxSize-(inventoryInterfaceBoxSize));
                j.scale(0.7);
                Interface.add(j);
            }
        }
    }
    public GCompound getInterface(){
        return Interface;
    }
}
