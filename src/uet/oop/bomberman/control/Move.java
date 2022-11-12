package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Balloom;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.animal.Oneal;
import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Arrays;

public class Move {
    private static int animate;

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Move.speed = speed;
    }

    private static int speed = Sprite.SCALED_SIZE / 8;

    public static int getOnealspeed() {
        return onealspeed;
    }

    public static void setOnealspeed(int onealspeed) {
        Move.onealspeed = onealspeed;
    }

    private static int onealspeed = 1;

    public static void down(Animal animal) {
        if (animal instanceof Bomber) {
            animal.setY(animal.getY() + speed);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setY(animal.getY() - speed);
                if (animal.getX() % Sprite.SCALED_SIZE <= Sprite.SCALED_SIZE / 4) {
                    animal.setX(Sprite.SCALED_SIZE * (animal.getX() / Sprite.SCALED_SIZE));
                }
                if (animal.getX() % Sprite.SCALED_SIZE >= 3 * Sprite.SCALED_SIZE / 4) {
                    animal.setX(Sprite.SCALED_SIZE * (animal.getX() / Sprite.SCALED_SIZE + 1));
                }
            }
            animal.setImg(Sprite.movingSprite(Sprite.player_down,
                    Sprite.player_down_1, Sprite.player_down_2, animate, 50).getFxImage());
        }
        if (animal instanceof Balloom) {
            animal.setY(animal.getY() + 1);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setY(animal.getY() - 1);
            }
            animal.setImg(Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
                    Sprite.balloom_left3, animate, 40).getFxImage());
        }
        if (animal instanceof Oneal) {
            animal.setY(animal.getY() + onealspeed);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setY(animal.getY() - onealspeed);
            }
            animal.setImg(Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2,
                    Sprite.oneal_left3, animate, 40).getFxImage());
        }
    }

    public static void up(Animal animal) {
        if (animal instanceof Bomber) {
            animal.setY(animal.getY() - speed);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setY(animal.getY() + speed);
                if (animal.getX() % Sprite.SCALED_SIZE <= Sprite.SCALED_SIZE / 4) {
                    animal.setX(Sprite.SCALED_SIZE * (animal.getX() / Sprite.SCALED_SIZE));
                }
                if (animal.getX() % Sprite.SCALED_SIZE >= 3 * Sprite.SCALED_SIZE / 4) {
                    animal.setX(Sprite.SCALED_SIZE * (animal.getX() / Sprite.SCALED_SIZE + 1));
                }
            }
            animal.setImg(Sprite.movingSprite(Sprite.player_up,
                    Sprite.player_up_1, Sprite.player_up_2, animate, 50).getFxImage());
        }
        if (animal instanceof Balloom) {
            animal.setY(animal.getY() - 1);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setY(animal.getY() + 1);
            }
            animal.setImg(Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
                    Sprite.balloom_left3, animate, 40).getFxImage());
        }
        if (animal instanceof Oneal) {
            animal.setY(animal.getY() - onealspeed);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setY(animal.getY() + onealspeed);
            }
            animal.setImg(Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2,
                    Sprite.oneal_right3, animate, 40).getFxImage());
        }
    }

    public static void left(Animal animal) {
        if (animal instanceof Bomber) {
            animal.setX(animal.getX() - speed);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setX(animal.getX() + speed);
                if (animal.getY() % Sprite.SCALED_SIZE <= Sprite.SCALED_SIZE / 4) {
                    animal.setY(Sprite.SCALED_SIZE * (animal.getY() / Sprite.SCALED_SIZE));
                }
                if (animal.getY() % Sprite.SCALED_SIZE >= 3 * Sprite.SCALED_SIZE / 4) {
                    animal.setY(Sprite.SCALED_SIZE * (animal.getY() / Sprite.SCALED_SIZE + 1));
                }
            }
            animal.setImg(Sprite.movingSprite(Sprite.player_left,
                    Sprite.player_left_1, Sprite.player_left_2, animate, 50).getFxImage());
        }
        if (animal instanceof Balloom) {
            animal.setX(animal.getX() - 1);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setX(animal.getX() + 1);
            }
            animal.setImg(Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
                    Sprite.balloom_left3, animate, 40).getFxImage());
        }
        if (animal instanceof Oneal) {
            animal.setX(animal.getX() - onealspeed);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setX(animal.getX() + onealspeed);
            }
            animal.setImg(Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2,
                    Sprite.oneal_left3, animate, 40).getFxImage());
        }
    }

    public static void right(Animal animal) {
        if (animal instanceof Bomber) {
            animal.setX(animal.getX() + speed);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setX(animal.getX() - speed);
                if (animal.getY() % Sprite.SCALED_SIZE <= Sprite.SCALED_SIZE / 4) {
                    animal.setY(Sprite.SCALED_SIZE * (animal.getY() / Sprite.SCALED_SIZE));
                }
                if (animal.getY() % Sprite.SCALED_SIZE >= 3 * Sprite.SCALED_SIZE / 4) {
                    animal.setY(Sprite.SCALED_SIZE * (animal.getY() / Sprite.SCALED_SIZE + 1));
                }
            }
            animal.setImg(Sprite.movingSprite(Sprite.player_right,
                    Sprite.player_right_1, Sprite.player_right_2, animate, 50).getFxImage());
        }
        if (animal instanceof Balloom) {
            animal.setX(animal.getX() + 1);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setX(animal.getX() - 1);
            }
            animal.setImg(Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2,
                    Sprite.balloom_right3, animate, 40).getFxImage());
        }
        if (animal instanceof Oneal) {
            animal.setX(animal.getX() + onealspeed);
            animate = animate > 100 ? 0 : animate + 1;
            if (animal.checkWall() || animal.checkBrick() || animal.checkBomb()) {
                animal.setX(animal.getX() - onealspeed);
            }
            animal.setImg(Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2,
                    Sprite.oneal_left3, animate, 40).getFxImage());
        }
    }
}
