package uet.oop.bomberman.menu;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.player;

public class Menu {
    private static ImageView playButton;
    private static ImageView resumeButton;
    private static ImageView quitButton;
    private static ImageView mainMenu;

    private static ImageView exitMenu;

    public static void createMenu(Group root, Scene scene, int levelGame) {
        mainMenu = new ImageView(new Image("images/mainmenu.jpg"));

        playButton = new ImageView(new Image("images/play.png"));
        playButton.setScaleX(0.3);
        playButton.setScaleY(0.3);
        playButton.setX(270);
        playButton.setY(90);

        quitButton = new ImageView(new Image("images/quit.png"));
        quitButton.setScaleX(0.3);
        quitButton.setScaleY(0.3);
        quitButton.setX(265);
        quitButton.setY(200);

        Pane pane = new Pane();
        pane.getChildren().addAll(mainMenu, playButton, quitButton);

        root.getChildren().add(pane);

        playButton.setOnMousePressed(e -> {
            player = new Bomber(1, 1, Sprite.player_right.getFxImage());
            player.setLife(true);
            Map map = new Map(scene, levelGame);
            playButton.setImage(null);
            quitButton.setImage(null);
            mainMenu.setImage(null);
        });

        quitButton.setOnMousePressed(e -> {
            System.exit(0);
        });
    }

    public static void exitMenu(Group root) {
        exitMenu = new ImageView(new Image("images/exitmenu.jpg"));

        quitButton = new ImageView(new Image("images/quit.png"));
        quitButton.setScaleX(0.3);
        quitButton.setScaleY(0.3);
        quitButton.setX(300);
        quitButton.setY(200);

        Pane pane = new Pane();
        pane.getChildren().addAll(exitMenu, quitButton);

        root.getChildren().add(pane);
        BombermanGame.isPause = false;
        quitButton.setOnMousePressed(e -> {
            System.exit(0);
        });
    }

    public static void pauseMenu(Group root) {
        resumeButton = new ImageView(new Image("images/resume.png"));
        resumeButton.setScaleX(0.3);
        resumeButton.setScaleY(0.3);
        resumeButton.setX(200);
        resumeButton.setY(0);

        quitButton = new ImageView(new Image("images/quit.png"));
        quitButton.setScaleX(0.3);
        quitButton.setScaleY(0.3);
        quitButton.setX(265);
        quitButton.setY(120);

        Pane pane = new Pane();
        pane.getChildren().addAll(resumeButton, quitButton);

        root.getChildren().add(pane);

        resumeButton.setOnMousePressed(e -> {
            BombermanGame.isPause = false;
            resumeButton.setImage(null);
            quitButton.setImage(null);
        });

        quitButton.setOnMousePressed(e -> {
            System.exit(0);
        });

    }

}
