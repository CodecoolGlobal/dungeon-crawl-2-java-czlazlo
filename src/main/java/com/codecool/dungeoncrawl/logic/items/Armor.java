package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Armor extends Items{
    public Armor(Cell cell) {
        super("armor",cell);
    }


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getTileName() {
        return "armor";
    }
}
