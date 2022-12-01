package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class HealthPotion extends Items{

    public HealthPotion(Cell cell) {
        super("hp",cell);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getTileName() {
        return "potion";
    }
}
