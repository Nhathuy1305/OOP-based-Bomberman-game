package control;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import Level;

public class Menu {
    private static ImageView status_game;
    public static Text level, bomb, time;
    public static int bomb_number = 20, time_number = 120; // the number of bomb is 20 and the time limit is 120 seconds

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

        Image newGame = new Image("images/newGame.png");
        status_game = new ImageView(newGame);
        status_game.setX(-75);
        status_game.setY(-10);
        status_game.setScaleX(0.5);
        status_game.setScaleY(0.5);

        Pane pane = new Pane();
        pane.getChildren().addAll(level, bomb, time, status_game);
        pane.setMinSize(800, 32);
        pane.setMaxSize(800, 480);
        pane.setStyle("-fx-background-color: #353535");

        root.getChildren().add(pane);

        status_game.setOnMouseClicked(event -> { //Event when you click the play game button, if your character still alive, the game will pause, else the game will start at level 1
            if (player.isLife()) {
                running = !running;
            } else {
                new Level1();
                running = true;
            }
            updateMenu();
        });

    }

    public static void updateMenu() { //Update menu
        level.setText("Level: " + _level);
        bomb.setText("Bombs: " + bombNumber);

        if (player.isLife())
            if (running) {
                Image pauseGame = new Image("images/pauseGame.png");
                status_game.setImage(pauseGame);
            } else {
                Image playGame = new Image("images/playGame.png");
                status_game.setImage(playGame);
            }
        else {
            Image newGame = new Image("images/newGame.png");
            status_game.setImage(newGame);
        }
    }
}

