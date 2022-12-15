package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Sword extends Items{

    int damage = 8;

    public int getDamage() {
        return damage;
    }

    public Sword(Cell cell) {
        super("sword", cell);
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
