package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.items.Armor;
import com.codecool.dungeoncrawl.logic.items.HealthPotion;
import com.codecool.dungeoncrawl.logic.items.Items;

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
        System.out.println(this.getX() + " "  + " "  +  this.getY());
        if (nextCell.getType() != CellType.WALL &&
                nextCell.getType() != CellType.TREE &&
                nextCell.getType() != CellType.PINE &&
                nextCell.getType() != CellType.WATER && nextCell.getActor() == null) {

            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } //lse if (nextCell.getType() == CellType.DOOR) {

      //  }
    }
    public void pickUp(int dx, int dy) {
        Cell targetItem = cell.getNeighbor(dx, dy);
        if (targetItem.getType() == CellType.HP || targetItem.getType() == CellType.KEY) {
            gameInventory.addItem(targetItem.getItems());
            drinkHealthPotion();
            targetItem.setType(CellType.FLOOR);
        }
    }
}
