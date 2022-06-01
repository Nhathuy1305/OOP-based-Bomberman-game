package Graphics;

// Import library
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteSheet {
    private String path;
    public final int SIZE;
    public int[] sprite_pixels;
    public BufferedImage image;

    // Method load() to load the pixels image object in RGB color: Bomber, Enemy, Bomb Flame, Brick,....
    private void load() {
        try {
            URL a = SpriteSheet.class.getResource(path);        // Will only be able to read from classpath
            image = ImageIO.read(a);
            int width = image.getWidth();
            int height = image.getHeight();
            image.getRGB(0, 0, width, height, sprite_pixels, 0, width);
        } catch (IOException e) {           // Catch exception
            e.printStackTrace();            // printStackTrace(): Help to understand where the problem is actually happening.
            System.exit(0);           // Exit the system
        }
    }

    // Constructor SpriteSheet with 2 parameters 'path' in string data type and 'SIZE' in integer data type, to create
    // an object from SpriteSheet class, and call method load().
    public SpriteSheet(String path, int SIZE) {
        this.path = path;
        this.SIZE = SIZE;
        sprite_pixels = new int[this.SIZE * this.SIZE];
        load();
    }

    // Create an object with the link to the object in-game picture.
    public static SpriteSheet tiles = new SpriteSheet("/textures/classic.png", 256);
}
