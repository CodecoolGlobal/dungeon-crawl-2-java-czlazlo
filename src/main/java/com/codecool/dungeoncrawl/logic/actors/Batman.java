package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

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

    }
}
