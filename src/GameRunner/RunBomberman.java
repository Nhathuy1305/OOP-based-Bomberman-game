package GameRunner;

import Control.Menu;
import Control.Move;
import Entity.Entity;
import Entity.animal.Animal;
import Entity.animal.Bomber;
import Entity.block.Bomb;
import Entity.block.Portal;
import Graphics.Sprite;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

import static Entity.block.Portal.*;
import static Features.SoundManager.updateSound;
import static Control.Menu.*;
import static Levels.NextLevel.*;

public class RunBomberman extends Application {
    /**
     * The window's default size:
     * H: 480px W: 800px
     **/
    public static final int HEIGHT = 15;
    public static final int WIDTH = 25;

    public static int width = 0;
    public static int height = 0;
    public static int level = 1;

    public static final List<Entity> block = new ArrayList<>();     // Contains fixed entities
    public static List<Animal> enemy = new ArrayList<>();           // Contains enemy entities
    public static int[][] id_objects;
    public static int[][] list_kill;
    public static Animal player;
    public static boolean running;
    public static ImageView author_view;

    private GraphicsContext gc;
    private Canvas canvas;

    private int frame = 1;
    private long last_time;

    public static Stage main_stage = null;
    public static boolean isPause = false;

    @Override
    public void start(Stage stage){
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        canvas.setTranslateY(32);
        gc = canvas.getGraphicsContext2D();
        Image author = new Image("images/author.png");
        author_view = new ImageView(author);
        author_view.setX(-400);
        author_view.setY(-208);
        author_view.setScaleX(0.5);
        author_view.setScaleY(0.5);
        Group root = new Group();
        Menu.createMenu(root);
        root.getChildren().add(canvas);
        root.getChildren().add(author_view);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            if (player.isLife()) {
                switch (event.getCode()) {
                    case UP:
                        Move.up(player);
                        break;
                    case DOWN:
                        Move.down(player);
                        break;
                    case RIGHT:
                        Move.right(player);
                        break;
                    case LEFT:
                        Move.left(player);
                        break;
                    case SPACE:
                        Bomb.putBomb();
                        break;
                    case P:
                        isPause = !isPause;
                        break;
                }
            }
        });

        stage.setScene(scene);
        stage.setTitle("Bomberman by 404 NOT FOUND");
        Image icon = new Image("images/ttsalpha4.0@0.5x.png");
        stage.getIcons().add(icon);
        main_stage = stage;
        main_stage.show();

        last_time = System.currentTimeMillis();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (running) {
                    render();
                    if(!isPause){
                        update();
                        time();
                    }
                    updateMenu();
                }
            }
        };
        timer.start();

        player = new Bomber(1, 1, Sprite.control_right_2.getFxImage());
        player.setLife(false);
    }

    public void update() {
        block.forEach(Entity::update);
        enemy.forEach(Entity::update);
        player.update();

        player.setCountToRun(player.getCountToRun() + 1);
        if (player.getCountToRun() == 4) {
            Move.checkRun(player);
            player.setCountToRun(0);
        }

        for (Animal a : enemy) {
            a.setCountToRun(a.getCountToRun() + 1);
            if (a.getCountToRun() == 8) {
                Move.checkRun(a);
                a.setCountToRun(0);
            }
        }

        if (enemy.size() == 0 && !is_portal && ! wait) {
            Entity portal = new Portal(width - 2, height - 2, Sprite.portal.getFxImage());
            block.add(portal);
            if (player.getX() / 32 == portal.getX() / 32 && player.getY() / 32 == portal.getY() / 32) {
                wait = true;
                waiting_time = System.currentTimeMillis();
            }
        }
        waitToLevelUp();
        updateSound();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        block.forEach(g -> g.render(gc));
        enemy.forEach(g -> g.render(gc));
        player.render(gc);
    }

    public void time() {
        frame++;

        long now = System.currentTimeMillis();
        if (now - last_time > 1000) {
            last_time = System.currentTimeMillis();
            main_stage.setTitle("Bomberman by 404 NOT FOUND | " + frame + " frame");
            frame = 0;

            time.setText("Time: " + time_number);
            time_number--;
            if (time_number < 0) {
                player.setLife(false);
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(RunBomberman.class);
    }
}
