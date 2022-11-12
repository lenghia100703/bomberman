package uet.oop.bomberman.entities.animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;


public class Animal extends Entity {
    protected String direction;
    protected boolean life;

    public Animal(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Animal(int x, int y, Image img, String direction) {
        super(x, y, img);
        this.direction = direction;
    }

    public Animal() {

    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    @Override
    public void update() {

    }
}
