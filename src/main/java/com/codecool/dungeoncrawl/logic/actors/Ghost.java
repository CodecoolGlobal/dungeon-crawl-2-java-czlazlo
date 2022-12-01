package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Direction;

public class Ghost extends Actor{
    public Ghost(Cell cell) {
        super(cell);
        this.setDmg(1);
        this.setHealth(30);
    }
    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getActor() == null) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else if (nextCell.getActor() instanceof Player) {
            attack(dx,dy);
        }
    }
    @Override
    public String getTileName() {
        return "ghost";
    }

    @Override
    public void act() {
        Direction randomDirection = Direction.getRandom();
        move(randomDirection.getDx(), randomDirection.getDy());
        move(randomDirection.getDx(), randomDirection.getDy());

    }
}
