package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Scrab extends Actor{
    public Scrab(Cell cell) {
        super(cell);
        this.setDmg(12);
        this.setHealth(40);
        this.setArmor(8);
    }

    @Override
    public String getTileName() {
        return "scrab";
    }

    @Override
    public void move(int dx, int dy) {

    }
}
