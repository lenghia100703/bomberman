package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.EntityList;
import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.entities.block.Brick;
import uet.oop.bomberman.entities.block.Flame;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    public static final List<Entity> blocks = new ArrayList<>();
    public static boolean isPause = false;
    public static int levelGame = 1;
    public static EntityList entityList = new EntityList();
    public static Bomber player;
    public static Group root = new Group();
    public static Scene scene = new Scene(root);
    public int WIDTH = 31;
    public int HEIGHT = 13;
    //hjhj
    Sound theme = new Sound();
    private GraphicsContext gc;
    private Canvas canvas;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        theme.playTheme();
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();


        // Tao root container
        root.getChildren().add(canvas);

        Menu.createMenu(root, scene, levelGame);
        // Tao scene
        stage.setTitle("Bomber Man");

        scene.setOnKeyPressed(keyEvent -> {
            if (player.isLife()) {
                switch (keyEvent.getCode()) {
                    case W:
                        Move.up(player);
                        break;
                    case S:
                        Move.down(player);
                        break;
                    case A:
                        Move.left(player);
                        break;
                    case D:
                        Move.right(player);
                        break;
                    case ESCAPE:
                        isPause = !isPause;
                        Menu.pauseMenu(root);
                        break;
                    case SPACE:
                        Bomb.setBomb();
                        break;
                }
            } else {
                Menu.exitMenu(root);
            }
        });

        // Them scene vao stage
        stage.setMaxHeight(670);
        stage.setMaxWidth(1505);
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                if (!isPause) {
                    update();
                }
            }
        };
        timer.start();
        player = new Bomber(1, 1, Sprite.transparent.getFxImage());
        player.setLife(true);
    }


    public void update() {
        for (Entity entity : blocks) {
            entity.update();
        }
        player.update();
        for (int i = 0; i < entityList.getAnimals().size(); i++) entityList.getAnimals().get(i).update();
        for (int i = 0; i < entityList.getBricks().size(); i++) entityList.getBricks().get(i).update();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        blocks.forEach(g -> g.render(gc));
        for (Bomb bomb : entityList.getBombs()) {
            if (bomb.isFire()) {
                bomb.explodeBomb();
                for (Flame flame : entityList.getFlames()) flame.render(gc);
            }
        }
        for (Animal enemy : entityList.getAnimals()) enemy.render(gc);
        for (Brick brick : entityList.getBricks()) brick.render(gc);
        player.render(gc);
    }
}
