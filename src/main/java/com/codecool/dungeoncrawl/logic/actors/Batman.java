package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Direction;

public class Batman extends Actor {
    public Batman(Cell cell) {
        super(cell);
        this.setDmg(7);
        this.setHealth(32);
    }

    @Override
    public String getTileName() {
        return "Batman";
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() != CellType.WALL &&
                nextCell.getActor() == null) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    @Override
    public void act() {
        Direction randomDirection = Direction.getRandom();
        move(randomDirection.getDx(), randomDirection.getDy());
    }
}
