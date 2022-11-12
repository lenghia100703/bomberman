package uet.oop.bomberman.entities.block;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.blocks;
import static uet.oop.bomberman.BombermanGame.entityList;

public class Brick extends Entity {
    private boolean collapse;
    private int animate;

    public Brick(int x, int y, Image img) {
        super(x, y, img);
        this.collapse = false;
    }

    public boolean isCollapse() {
        return collapse;
    }

    public void setCollapse(boolean collapse) {
        this.collapse = collapse;
    }

    public void checkBombBrick() {
        for (Flame flame : entityList.getFlames()) {
            if (this.intersects(flame)) {
                this.collapse = true;
                break;
            }
        }
    }

    @Override
    public void update() {
        checkBombBrick();
        if (this.isCollapse()) {
            if (animate < 100) {
                animate++;
                this.setImg(Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1,
                        Sprite.brick_exploded2, animate, 100).getFxImage());
            } else {
                this.setImg(null);
            }
            BombermanGame.entityList.getBricks().remove(this);
            blocks.remove(this);
        }
    }
}
