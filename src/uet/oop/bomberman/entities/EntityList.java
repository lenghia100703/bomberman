package uet.oop.bomberman.entities;

import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.block.*;
import uet.oop.bomberman.entities.items.Item;

import java.util.ArrayList;
import java.util.List;

public class EntityList {
    private final List<Wall> walls = new ArrayList<>();
    private List<Brick> bricks = new ArrayList<>();
    private final List<Grass> grasses = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();

    private List<Animal> animals = new ArrayList<>();

    private List<Bomb> bombs = new ArrayList<>();

    private final List<Flame> flames = new ArrayList<>();

    private Portal portal;

    private Bomber bomberman;

    public List<Wall> getWalls() {
        return walls;
    }

    public void addWalls(Wall wall) {
        walls.add(wall);
    }


    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public void addBricks(Brick brick) {
        bricks.add(brick);
    }

    public List<Grass> getGrasses() {
        return grasses;
    }

    public void addGrasses(Grass grass) {
        grasses.add(grass);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItems(Item item) {
        items.add(item);
    }

    public List<Flame> getFlames() {
        return flames;
    }

    public void addFlame(Flame flame) {
        flames.add(flame);
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }

    public void addBomb(Bomb bomb) {
        bombs.add(bomb);
    }

    public Bomber getBomberman() {
        return bomberman;
    }

    public void setBomberman(Bomber bomberman) {
        this.bomberman = bomberman;
    }

    public void addAnimals(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void setPortal(Portal portal) {
        this.portal = portal;
    }

    public void clearList() {
        walls.clear();
        bricks.clear();
        items.clear();
        grasses.clear();
        animals.clear();
    }

}
