package uet.oop.bomberman;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class Sound {

    private final String themeroot = "res/sound/bombtheme.mp3";
    private final Media themeMedia = new Media(new File(themeroot).toURI().toString());
    private final MediaPlayer theme = new MediaPlayer(themeMedia);

    private final String explosionroot = "res/sound/explosion_sound.wav";
    private final Media explosionMedia = new Media(new File(explosionroot).toURI().toString());
    private final MediaPlayer explosion = new MediaPlayer(explosionMedia);
    private final String deadroot = "res/sound/dead.mp3";
    private final Media deadMedia = new Media(new File(deadroot).toURI().toString());
    private final MediaPlayer dead = new MediaPlayer(deadMedia);

    public void playExplode() {
        {   explosion.setVolume(5);
            explosion.seek(Duration.ZERO);
            explosion.play();
        }
    }

    public void playTheme() {
        theme.setVolume(0.1);
        theme.seek(Duration.ZERO);
        theme.setCycleCount(-1);
        theme.play();
    }

    public void playDead() {
        dead.seek(Duration.ZERO);
        dead.play();

    }
}