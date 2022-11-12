package uet.oop.bomberman.entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.entities.block.Brick;
import uet.oop.bomberman.entities.block.Flame;
import uet.oop.bomberman.entities.block.Wall;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected Image img;

    protected Entity() {
    }

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity(int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }


    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Rectangle2D getRect() {
        return new Rectangle2D(x, y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }

    public boolean intersects(Entity entity) {
        return this.getRect().intersects(entity.getRect());
    }

    public boolean contains(Entity entity) {
        return this.getRect().contains(entity.getRect());
    }

    public boolean checkWall() {
        for (Wall wall : BombermanGame.entityList.getWalls()) {
            if (this.intersects(wall)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBrick() {
        for (Brick brick : BombermanGame.entityList.getBricks()) {
            if (this instanceof Flame && this.contains(brick)) {
                brick.setCollapse(true);
                return true;
            } else if (this instanceof Animal && this.intersects(brick)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBomb() {
        for (Bomb bomb : BombermanGame.entityList.getBombs()) {
            if (this instanceof Bomber) {
                if (this.intersects(bomb) && !bomb.isAllow()) {
                    return true;
                }
            } else if (this.intersects(bomb)) return true;
        }
        return false;
    }

    public boolean checkFlame() {
        for (Flame flame : BombermanGame.entityList.getFlames()) {
            if (this instanceof Animal) {
                if (this.intersects(flame)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public abstract void update();
}
