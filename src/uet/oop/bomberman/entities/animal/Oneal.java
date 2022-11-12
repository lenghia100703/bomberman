package uet.oop.bomberman.entities.animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.block.Flame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.entityList;
import static uet.oop.bomberman.BombermanGame.player;

public class Oneal extends Animal {
    int rntCnt = 0;
    Random random = new Random();
    int direction = random.nextInt(4);
    private int animate;

    public Oneal(int x, int y, Image img) {
        super(x, y, img);
        this.setLife(true);
    }

    public Oneal(int x, int y, Image img, String dir) {
        super(x, y, img, dir);
        this.setLife(true);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void checkEnemyDie() {
        for (Flame flame : entityList.getFlames()) {
            if (this.intersects(flame)) {
                this.life = false;
                break;
            }
        }
    }

    @Override
    public void update() {
        rntCnt = getRandomNumber(0, 1000);
        if (rntCnt >= 490 && rntCnt <= 510) direction = random.nextInt(4);
        if(rntCnt >= 800 && rntCnt <= 850) Move.setOnealspeed(getRandomNumber(1,3));
        checkEnemyDie();
        animate = animate > 100 ? 0 : animate + 1;
        if (this.isLife()) {
            switch (direction) {
                case 0:
                    if (animate % 5 == 0) {
                        Move.down(this);
                    }
                    break;
                case 1:
                    if (animate % 5 == 0) {
                        Move.up(this);
                    }
                    break;
                case 2:
                    if (animate % 5 == 0) {
                        Move.left(this);
                    }
                    break;
                case 3:
                    if (animate % 5 == 0) {
                        Move.right(this);
                    }
                    break;
            }
            if (this.getX() < player.getX() && animate % 3 == 0) {
                Move.right(this);
            }
            if (this.getX() > player.getX() && animate % 3 == 0) {
                Move.left(this);
            }
            if (this.getY() > player.getY() && animate % 3 == 0) {
                Move.up(this);
            }
            if (this.getY() < player.getY() && animate % 3 == 0) {
                Move.down(this);
            }
        } else {
            if (animate < 50) {
                this.setImg(Sprite.movingSprite(Sprite.oneal_dead, null, animate, 50).getFxImage());
            } else {
                BombermanGame.entityList.getAnimals().remove(this);
            }
        }
    }
}



