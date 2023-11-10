package userinterface;

import acm.graphics.GCompound;

public class Hotbar {
    private GCompound Interface = new GCompound();
    public Hotbar(Inventory inventory){
        //hotbar is just the first 10 items in the inventory
        for(int i = 0; i < 10; i++){
            Interface.add(inventory.getInterface().getElement(i));
        }
        
    }
}
