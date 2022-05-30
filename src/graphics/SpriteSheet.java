package graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private String _path;
    public final int SIZE;
    public int[] _pixels;
    public BufferedImage image;

    public SpriteSheet(String _path, int SIZE) {
        this._path = _path;
        this.SIZE = SIZE;
        _pixels = new int[this.SIZE * this.SIZE];
        load();
    }

    public static SpriteSheet tiles = new SpriteSheet("/textures/classic.png", 256);
}
