package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Batman;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Scrab;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private Skeleton skeleton;

    private Scrab scrab;

    private Batman batman;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Skeleton getSkeleton() {
        return skeleton;
    }

    public void setSkeleton(Skeleton skeleton) {
        this.skeleton = skeleton;
    }

    public Scrab getScrab() {
        return scrab;
    }

    public void setScrab(Scrab scrab) {
        this.scrab = scrab;
    }

    public Batman getBatman() {
        return batman;
    }

    public void setBatman(Batman batman) {
        this.batman = batman;
    }
}
