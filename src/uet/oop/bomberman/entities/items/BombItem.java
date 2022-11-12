package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;

import static uet.oop.bomberman.BombermanGame.*;

public class BombItem extends Item {
    public BombItem(int x, int y, Image img) {
        super(x, y, img);
    }
    public void checkPicked(){
        if(this.intersects(player)){
            this.setPick(true);
        }
    }
    @Override
    public void update(){
        checkPicked();
        if(this.isPick()){
            blocks.remove(this);
            entityList.getItems().remove(this);
            this.setImg(null);
        }
    }
}
