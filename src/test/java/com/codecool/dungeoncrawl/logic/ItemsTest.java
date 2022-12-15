package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.items.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class ItemsTest {
    GameMap gameMap;
    @BeforeEach
    public void initEach() {
        gameMap = new GameMap(3, 3, CellType.FLOOR);
    }

    @Test
    void getCell_cell() {
        Cell cell = gameMap.getCell(1, 1);
        Sword sword = new Sword(cell);
        assertEquals(cell, sword.getCell());
    }

    @Test
    void getDmgForSword(){
        Cell cell = gameMap.getCell(1,1);
        Sword sword = new Sword(cell);
        assertEquals(8, sword.getDamage());
    }


}
