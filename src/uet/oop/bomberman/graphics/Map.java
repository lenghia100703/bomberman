package uet.oop.bomberman.graphics;

import javafx.scene.Scene;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.animal.Balloom;
import uet.oop.bomberman.entities.animal.Oneal;
import uet.oop.bomberman.entities.block.*;
import uet.oop.bomberman.entities.items.BombItem;
import uet.oop.bomberman.entities.items.SpeedItem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static uet.oop.bomberman.BombermanGame.blocks;

public class Map {
    public static char[][] tileMap;
    public int WIDTH = 31;
    public int HEIGHT = 13;
    Scene scene = null;

    public Map(Scene scene, int level) {
        this.scene = scene;
        loadLevel(level);
    }

    public void loadLevel(int level) {
        tileMap = new char[HEIGHT][WIDTH];
        Scanner scan = null;
        try {
            scan = new Scanner(new FileReader("./res/levels/Level" + level + ".txt"));
            for (int i = 0; i < HEIGHT; i++) {
                String hash = scan.nextLine();
                for (int j = 0; j < WIDTH; j++) {
                    tileMap[i][j] = hash.charAt(j);
                    blocks.add(new Grass(j, i, Sprite.grass.getFxImage()));
                    BombermanGame.entityList.addGrasses((new Grass(j, i, Sprite.grass.getFxImage())));
                    if (tileMap[i][j] == '#') {
                        blocks.add(new Wall(j, i, Sprite.wall.getFxImage()));
                        BombermanGame.entityList.addWalls((new Wall(j, i, Sprite.wall.getFxImage())));
                    } else if (tileMap[i][j] == '*') {
                        blocks.add(new Brick(j, i, Sprite.brick.getFxImage()));
                        BombermanGame.entityList.addBricks((new Brick(j, i, Sprite.brick.getFxImage())));
                    } else if (tileMap[i][j] == '1') {
                        blocks.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        //entities.add(new Balloom(j, i, Sprite.balloom_left1.getFxImage()));
                        BombermanGame.entityList.addAnimals(new Balloom(j, i, Sprite.balloom_left1.getFxImage()));
                    } else if (tileMap[i][j] == '2') {
                        blocks.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        //entities.add(new Balloom(j, i, Sprite.balloom_left1.getFxImage()));
                        BombermanGame.entityList.addAnimals(new Oneal(j, i, Sprite.oneal_left1.getFxImage()));
                    } else if (tileMap[i][j] == 's') {
                        blocks.add(new SpeedItem(j, i, Sprite.powerup_speed.getFxImage()));
                        blocks.add(new Brick(j, i, Sprite.brick.getFxImage()));
                        BombermanGame.entityList.addBricks((new Brick(j, i, Sprite.brick.getFxImage())));
                        BombermanGame.entityList.addItems(new SpeedItem(j, i, Sprite.powerup_speed.getFxImage()));
                    } else if (tileMap[i][j] == 'b') {
                        blocks.add(new BombItem(j, i, Sprite.powerup_bombs.getFxImage()));
                        blocks.add(new Brick(j, i, Sprite.brick.getFxImage()));
                        BombermanGame.entityList.addBricks((new Brick(j, i, Sprite.brick.getFxImage())));
                        BombermanGame.entityList.addItems(new BombItem(j, i, Sprite.powerup_bombs.getFxImage()));
                    }
                    else if (tileMap[i][j] == 'x') {
                        blocks.add(new Portal(j, i, Sprite.portal.getFxImage()));
                        blocks.add(new Brick(j, i, Sprite.brick.getFxImage()));
                        BombermanGame.entityList.addBricks((new Brick(j, i, Sprite.brick.getFxImage())));
                        BombermanGame.entityList.setPortal(new Portal(j, i, Sprite.portal.getFxImage()));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
