package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Sword extends Items{
    public Sword(String name, Cell cell) {
        super(name, cell);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}
