package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameMap {
    public String gameState;

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    private int width;
    private int height;
    private Cell[][] cells;

    transient private Player player;

    transient private ArrayList<Skeleton> skeletons = new ArrayList<>();
    transient private ArrayList<Batman> batmen = new ArrayList<>();
    transient private ArrayList<Scrab> scrabs = new ArrayList<>();
    transient private ArrayList<Ghost> ghosts = new ArrayList<>();

    public void addScrabs(Scrab scrab) {
        this.scrabs.add(scrab);
    }

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

    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    public void addGhosts(Ghost ghost) {
        this.ghosts.add(ghost);
    }

    public void addBatman(Batman batman) {
        this.batmen.add(batman);
    }

    public Collection<Actor> getMonsters() {
        List<Actor> monsters = new ArrayList<>();
        monsters.addAll(skeletons);
        monsters.addAll(batmen);
        monsters.addAll(scrabs);
        monsters.addAll(ghosts);
        return monsters;
    }

    public void reset() {
        skeletons = new ArrayList<>();
        batmen = new ArrayList<>();
        scrabs = new ArrayList<>();
        ghosts = new ArrayList<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.setMap(this);
                var actor = cell.getActor();
                if (actor != null) {
                    actor.setCell(cell);
                    if (actor instanceof Skeleton) {
                        skeletons.add((Skeleton) actor);
                    } else if (actor instanceof Batman) {
                        batmen.add((Batman) actor);
                    } else if (actor instanceof Scrab) {
                        scrabs.add((Scrab) actor);
                    } else if (actor instanceof Ghost) {
                        ghosts.add((Ghost) actor);
                    } else if (actor instanceof Player) {
                        this.player = ((Player) actor);
                    }
                }
            }
        }
    }
}
