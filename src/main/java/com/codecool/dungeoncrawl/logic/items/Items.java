
package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Items implements Drawable {
    public String name;

    protected Cell cell;


    public String getName() {
        return name;
    }

    public Items(String name, Cell cell) {
        this.name = name;
        this.cell = cell;
    }
}




