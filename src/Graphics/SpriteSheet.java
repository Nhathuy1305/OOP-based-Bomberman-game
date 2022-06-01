package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteSheet {
    private String path;
    public final int SIZE;
    public int[] spritePixels;
    public BufferedImage image;

    private void load() {
        try {
            URL a = SpriteSheet.class.getResource(path);
            image = ImageIO.read(a);
            int width = image.getWidth();
            int height = image.getHeight();
            image.getRGB(0, 0, width, height, spritePixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public SpriteSheet(String path, int SIZE) {
        this.path = path;
        this.SIZE = SIZE;
        spritePixels = new int[this.SIZE * this.SIZE];
        load();
    }

    public static SpriteSheet tiles = new SpriteSheet("/textures/classic.png", 256);
}
