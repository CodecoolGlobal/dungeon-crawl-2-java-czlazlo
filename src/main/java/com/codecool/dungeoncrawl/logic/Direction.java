package com.codecool.dungeoncrawl.logic;


import java.util.Random;

public enum Direction {
    UP(0,-1),
    DOWN(0,1),
    RIGHT(1,0),
    LEFT(-1,0);
    final int dx;
    final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
    public static Direction getRandom(){
        Random random = new Random();
        int index= random.nextInt(4);
        return values()[index];
    }
}
