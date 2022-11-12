package uet.oop.bomberman.entities.animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Sound;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.entities.block.Flame;
import uet.oop.bomberman.entities.items.BombItem;
import uet.oop.bomberman.entities.items.Item;
import uet.oop.bomberman.entities.items.SpeedItem;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.menu.Menu;

import static uet.oop.bomberman.BombermanGame.*;

public class Bomber extends Animal {
    Sound music = new Sound();
    private int animate;

    //music.playDead();
    //music.stopPlayTheme();
    public Bomber() {

    }

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    private void checkEnemyDie() {
        for (Animal animal : entityList.getAnimals()) {

            if (this.intersects(animal)) {
                player.life = false;
                break;
            }
        }
    }

    private void checkBombDie() {
        for (Flame flame : entityList.getFlames()) {
            if (this.intersects(flame)) {
                player.life = false;
                break;
            }
        }
    }

    public void checkSpeedItem() {
        for (Item item : entityList.getItems()) {
            if (item instanceof SpeedItem && this.intersects(item)) {
                System.out.println("heh");
                Move.setSpeed(Move.getSpeed() + Sprite.SCALED_SIZE / 8);
                blocks.remove(item);
                entityList.getItems().remove(item);
            }
        }
    }
    public void checkBombItem() {
        for (Item item : entityList.getItems()) {
            if (item instanceof BombItem && this.intersects(item)) {
                System.out.println("heh");
                Bomb.numberOfBomb++;
                blocks.remove(item);
                entityList.getItems().remove(item);
            }
        }
    }

    @Override
    public void update() {
        for (Bomb bomb : BombermanGame.entityList.getBombs()) {
            if (!this.intersects(bomb) && bomb.isAllow()) {
                bomb.setAllow(false);
            }
        }
        checkEnemyDie();
        checkBombDie();
        checkSpeedItem();
        checkBombItem();
        if (!player.isLife()) {
            if (animate < 50) {
                animate++;
                player.setImg(Sprite.movingSprite(Sprite.player_dead1,
                        Sprite.player_dead2, Sprite.player_dead3, animate, 50).getFxImage());
                music.playDead();
            } else {
                Menu.exitMenu(BombermanGame.root);
                player.setImg(null);
            }

        }
    }
}
