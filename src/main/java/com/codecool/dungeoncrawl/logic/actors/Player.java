package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;

public class Player extends Actor {
    public Inventory gameInventory;


    public Player(Cell cell) {
        super(cell);
        this.setEnemy();
        this.setDmg(10);
        this.setHealth(10);
        gameInventory = new Inventory();
    }
    public String readInventory(){
        return gameInventory.toString();
    }

    public String getTileName() {
        return "player";
    }
    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() != CellType.WALL && nextCell.getActor() == null) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }
}
