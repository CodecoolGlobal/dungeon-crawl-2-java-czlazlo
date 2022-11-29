package com.codecool.dungeoncrawl.logic.actors;

import java.util.ArrayList;

public class Inventory{

    private ArrayList <Items> gameInventory;



    public Inventory() {
        gameInventory = new ArrayList<>();





    }

    public void Add(Items item) {
        gameInventory.add(item);
    }

    public void Remove(Items item) {
        gameInventory.remove(item);
    }

}
