package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.items.Armor;
import com.codecool.dungeoncrawl.logic.items.Items;

import java.util.ArrayList;

public class Inventory{

    private ArrayList <Items> gameInventory;


    public Inventory() {
        gameInventory = new ArrayList<>();
    }

    public String getItemsString(){
        StringBuilder items = new StringBuilder();
        for (Items item : gameInventory) {
            items.append(item.getName());
        }
        return items.toString();
    }
    public void addItem(Items item) {
        gameInventory.add(item);
    }

    public void removeItem(Items item) {
        gameInventory.remove(item);
    }

}
