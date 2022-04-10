package Graphics;

import javax.swing.text.html.parser.Entity;

public class Screen {
    protected int width;
    protected int height;
    public int[] pixels;
    private int transparentColor = 0xffff00ff;
    public static int xOffset = 0, yOffset = 0;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }

    public void clear() {
        for (int  i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void renderEntity(int xp, int yp, Entity entity) {
        xp -= xOffset;
        yp -= yOffset;

        for (int y = 0; y < entity.getSprite().getSize(); y++) {
            int ya = y + yp;        // add offset

            for (int x = 0; x < entity.getSprite().getSize(); x++) {
                int xa = x + xp;    // add offset

                if (xa < -entity.getSprite().getSize() || xa >= width || ya < 0 || ya >= height)
                    break;          // fix black margins
                if (xa < 0)
                    xa = 0;         // start at 0 from left
                int color = entity.getSprite().getPixel(x + y * entity.getSprite().getSize());
                if (color != transparentColor)
                    pixels[xa + ya * width] = color;
            }
        }
    }
}
