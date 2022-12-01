package com.codecool.dungeoncrawl.logic.actors;
import java.util.Random;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
        this.setHealth(21);
        this.setDmg(2);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }



    @Override
    public void act() {
        move(0,-1);
    }
}
