package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Batman;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Scrab;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;

import java.util.ArrayList;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private ArrayList<Skeleton> skeletons = new ArrayList<>();
    private ArrayList<Batman> batmen = new ArrayList<>();

    private Scrab scrab;


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

    public ArrayList<Skeleton> getSkeletons() {
        return skeletons;
    }

    public void addSkeleton(Skeleton skeleton) {
        this.skeletons.add(skeleton);
    }

    public Scrab getScrab() {
        return scrab;
    }

    public void setScrab(Scrab scrab) {
        this.scrab = scrab;
    }

    public ArrayList<Batman> getBatmen() {
        return batmen;
    }

    public void addBatman(Batman batman) {
        this.batmen.add(batman);
    }
}
