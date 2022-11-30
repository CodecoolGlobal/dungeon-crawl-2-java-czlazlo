package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Player extends Actor {
    public Inventory gameInventory;


    public Player(Cell cell) {
        super(cell);
        gameInventory = new Inventory();
    }
    public String readInventory(){
        return gameInventory.toString();
    }

    public String getTileName() {
        return "player";
    }

}
