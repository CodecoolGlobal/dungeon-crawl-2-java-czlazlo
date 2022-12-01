package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private int health = 10;
    protected int dmg = 10;
    private boolean isEnemy = false;
    private int armor = 0;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() != CellType.WALL &&
                nextCell.getType() != CellType.TREE &&
                nextCell.getType() != CellType.PINE &&
                nextCell.getType() != CellType.WATER &&
            nextCell.getActor() == null) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }


    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public int getDmg() {
        return dmg;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public void setEnemy() {
        isEnemy = true;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void decreaseHealth(int dmg) {
        health -= dmg;
        if (health <= 0) {
            setDeath();
        }
    }
    public void increaseHealth(int heal){
        health += heal;
    }

    public void attack(int dx, int dy){
        Actor target = cell.getNeighbor(dx, dy).getActor();
         if (target != null && target.isEnemy() != this.isEnemy()) {
            target.decreaseHealth(dmg);
        }
    }

    public void setDeath(){
            cell.setActor(null);
    }

    public void drinkHealthPotion(){
        increaseHealth(10);
    }
}
