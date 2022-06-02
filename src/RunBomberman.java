import Control.Menu;
import Entity.Entity;
import Entity.animal.Animal;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Graphics.Sprite;
import javafx.scene.canvas.Canvas;


import java.util.ArrayList;
import java.util.List;

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
    }

    public static void main(String[] args) {
        Application.launch(RunBomberman.class);
    }
}
