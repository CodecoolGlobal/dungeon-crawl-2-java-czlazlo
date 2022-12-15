package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.items.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameMapTest {
    GameMap gameMap;
    @BeforeEach
    public void initEach() {
        gameMap = new GameMap(3, 3, CellType.FLOOR);
    }

    @Test
    void setPlayer_changesPlayer() {
        assertNull(gameMap.getPlayer());
        Player player = new Player(gameMap.getCell(1, 1));
        gameMap.setPlayer(player);
        assertEquals(player, gameMap.getPlayer());
    }
    @Test
    void pickUpItem_itemDisappearsFromMap() {
        Cell cell = gameMap.getCell(1, 1);
        Player player = new Player(cell);
        Sword sword = new Sword(cell);
        gameMap.setPlayer(player);
        gameMap.getPlayer().pickUp(1,1);
        assertNull(cell.getItems());
    }

}
