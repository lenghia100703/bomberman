package uet.oop.bomberman.entities.block;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.levelGame;
import static uet.oop.bomberman.BombermanGame.player;

public class Portal extends Entity {
    public Portal(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if (this.intersects(player) && BombermanGame.entityList.getAnimals().isEmpty()) {
            if (BombermanGame.levelGame <= 2) {
                BombermanGame.levelGame++;
                Scene scene = null;
                BombermanGame.entityList.clearList();
                player = new Bomber(29, 11, Sprite.player_left.getFxImage());
                Move.setSpeed(Sprite.SCALED_SIZE / 8);
                player.setLife(true);
                Map map = new Map(null, levelGame);
            }
        }
    }
}
