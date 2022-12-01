package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Key extends Items {
    public Key(Cell cell) {
        super("key", cell);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getTileName() {
        return "key";
    }
}
