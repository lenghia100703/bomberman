package uet.oop.bomberman.entities.block;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Sound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.Sound.*;

import java.util.ArrayList;

import static uet.oop.bomberman.BombermanGame.blocks;
import static uet.oop.bomberman.BombermanGame.player;

public class Bomb extends Entity {
    public static int numberOfBomb = 1;
    public static Entity bomb;

    public static int timeCnt;
    private boolean allow;
    private boolean fire = false;

    private int bombradius = 1;
    static int bombremain = numberOfBomb;


    public Bomb(int x, int y, Image img) {
        super(x, y, img);
        timeCnt = 0;
        allow = true;
        fire = false;
    }

    public boolean isFire() {
        return fire;
    }

    public boolean isAllow() {
        return allow;
    }

    public void setAllow(boolean a) {
        this.allow = a;
    }

    public static int getTimeCnt() {
        return timeCnt;
    }

    public static void setTimeCnt(int timeCnt) {
        Bomb.timeCnt = timeCnt;
    }

    public static void setBomb() {
        if (bombremain != 0) {
            bombremain--;
            int x = player.getX() / Sprite.SCALED_SIZE;
            int y = player.getY() / Sprite.SCALED_SIZE;
            bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            blocks.add(bomb);
            BombermanGame.entityList.addBomb((Bomb) bomb);
        } else if (bombremain == 0) {
            if(timeCnt > 300) bombremain = numberOfBomb;
        }
    }

    public void explodeBomb() {
        int flameX = this.x / Sprite.SCALED_SIZE;
        int flameY = this.y / Sprite.SCALED_SIZE;
        Flame Mflame = new Flame(flameX, flameY, Sprite.bomb_exploded2.getFxImage());
        BombermanGame.entityList.addFlame(Mflame);
        for (int i = 1; i <= bombradius; i++) {
            Flame Rflame = new Flame(flameX + i, flameY, Sprite.explosion_horizontal_right_last2.getFxImage());
            if (!Rflame.checkBrick() && !Rflame.checkWall()) {
                BombermanGame.entityList.addFlame(Rflame);
            }

            Flame Lflame = new Flame(flameX - i, flameY, Sprite.explosion_horizontal_left_last2.getFxImage());
            if (!Lflame.checkBrick() && !Lflame.checkWall()) {
                BombermanGame.entityList.addFlame(Lflame);
            }

            Flame Dflame = new Flame(flameX, flameY + i, Sprite.explosion_vertical_down_last2.getFxImage());
            if (!Dflame.checkBrick() && !Dflame.checkWall()) {
                BombermanGame.entityList.addFlame(Dflame);
            }

            Flame Tflame = new Flame(flameX, flameY - i, Sprite.explosion_vertical_top_last2.getFxImage());
            if (!Tflame.checkBrick() && !Tflame.checkWall()) {
                BombermanGame.entityList.addFlame(Tflame);
            }

        }

    }

    @Override
    public void update() {
        int flameX = this.x / Sprite.SCALED_SIZE;
        int flameY = this.y / Sprite.SCALED_SIZE;

        if (getTimeCnt() < 300) {
            timeCnt++;
            setImg(Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, timeCnt, 20).getFxImage());
        } else if (timeCnt < 325) {
            Sound music = new Sound();
            music.playExplode();
            timeCnt++;
            fire = true;
            for (Flame flame : BombermanGame.entityList.getFlames()) flame.update();
//            if (Map.getMap()[flameX][flameY] != ' ') {
//                Map.setMap(flameX, flameY, ' ');
//                System.out.println(Map.getMap());
//            }
        } else {
            blocks.remove(this);
            BombermanGame.entityList.setBombs(new ArrayList<>());
            BombermanGame.entityList.getFlames().clear();
            fire = false;
        }
    }
}
