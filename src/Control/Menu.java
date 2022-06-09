package Control;

import GameRunner.RunBomberman;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import Levels.*;

import static GameRunner.RunBomberman.*;

public class Menu {
    private static ImageView statusGame;
    public static Text level, bomb, time;
    public static int bomb_number = 20, time_number = 120;   // the number of bomb is 20 and the time limit is 120 seconds
    public static Image pauseGame, playGame;

    public static void createMenu(Group root) { //Create a menu
        level = new Text("Level: 1");
        level.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        level.setFill(Color.WHITE);
        level.setX(416);
        level.setY(20);
        bomb = new Text("Bombs: 20");
        bomb.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        bomb.setFill(Color.WHITE);
        bomb.setX(512);
        bomb.setY(20);
        time = new Text("Times: 120");
        time.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        time.setFill(Color.WHITE);
        time.setX(608);
        time.setY(20);

        Image newGame = new Image("images/startButton.png");
        statusGame = new ImageView(newGame);
        statusGame.setX(-75);
        statusGame.setY(-10);
        statusGame.setScaleX(0.5);
        statusGame.setScaleY(0.5);

        Pane pane = new Pane();
        pane.getChildren().addAll(level, bomb, time, statusGame);
        pane.setMinSize(800, 32);
        pane.setMaxSize(800, 480);
        pane.setStyle("-fx-background-color: #353535");

        root.getChildren().add(pane);

        playGame = new Image("images/pauseButton.png");
        pauseGame = new Image("images/resumeButton.png");

        statusGame.setOnMouseClicked(event -> {     //Event when you click the play game button, if your character still alive, the game will pause, else the game will start at level 1
            if (player.isLife()) {
                isPause = !isPause;
            } else {
                new Level1();
                running = true;
            }
            updateMenu();
        });

    }

    public static void updateMenu() { //Update menu
        level.setText("Level: " + RunBomberman.level);
        bomb.setText("Bombs: " + bomb_number);

        if (player.isLife())
            if (isPause) {
                statusGame.setImage(pauseGame);
            } else {
                statusGame.setImage(playGame);
            }
        else {
            Image newGame = new Image("images/startButton.png");
            statusGame.setImage(newGame);
        }
    }
}

