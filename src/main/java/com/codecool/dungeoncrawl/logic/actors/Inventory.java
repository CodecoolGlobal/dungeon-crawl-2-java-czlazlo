package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.Items;

import java.util.ArrayList;

public class Inventory{

    private ArrayList <Items> gameInventory;


    public Inventory() {
        gameInventory = new ArrayList<>();
    }

    public StringBuilder getItemsString(){
        StringBuilder items = new StringBuilder();
        for (Items item : gameInventory) {
            items.append(item.getName());
            items.append(", ");
        }
        return items;
    }
    public void addItem(Items item) {
        gameInventory.add(item);
    }

    public void removeItem(Items item) {
        gameInventory.remove(item);
    }

    @Override
    public String toString() {
        return "Inventory " + getItemsString();
    }
}
