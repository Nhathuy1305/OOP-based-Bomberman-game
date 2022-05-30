package graphics;

public class Sprite {
    public static final int ORIGINAL_SIZE = 16;
    public static final int SCALED_SIZE = ORIGINAL_SIZE * 2;
    private static final int TRANSPARENT_COLOR = 0xffff00f;
    public final int SIZE;
    private int _x, _y;
    public int[] _pixels;
    protected int _realWidth;
    protected int _realHeight;
    private SpriteSheet _sheet;

    public Sprite(int SIZE, int _x, int _y, int _realWidth, int _realHeight, SpriteSheet _sheet) {
        this.SIZE = SIZE;
        this._x = _x * this.SIZE;
        this._y = _y * this.SIZE;
        this._realWidth = _realWidth;
        this._realHeight = _realHeight;
        this._sheet = _sheet;
        _pixels = new int[this.SIZE * this.SIZE];
        load();
    }

    public static Sprite transparent = new Sprite(ORIGINAL_SIZE, 15, 15, 16, 16, SpriteSheet.tiles);

    // Board
    public static Sprite grass = new Sprite(ORIGINAL_SIZE, 6, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite brick = new Sprite(ORIGINAL_SIZE, 7, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite portal = new Sprite(ORIGINAL_SIZE, 4, 0, 14, 14, SpriteSheet.tiles);
    public static Sprite wall = new Sprite(ORIGINAL_SIZE, 5, 0, 16, 16, SpriteSheet.tiles);

    // Bomber
    public static Sprite control_up = new Sprite(ORIGINAL_SIZE, 0, 0, 12, 16, SpriteSheet.tiles);
    public static Sprite control_down = new Sprite(ORIGINAL_SIZE, 2, 0, 12, 15, SpriteSheet.tiles);
    public static Sprite control_right = new Sprite(ORIGINAL_SIZE, 1, 0, 10, 16, SpriteSheet.tiles);
    public static Sprite control_left = new Sprite(ORIGINAL_SIZE, 3, 0, 10, 15, SpriteSheet.tiles);

    public static Sprite control_up_1 = new Sprite(ORIGINAL_SIZE, 0, 1, 12, 16, SpriteSheet.tiles);
    public static Sprite control_up_2 = new Sprite(ORIGINAL_SIZE, 0, 2, 12, 15, SpriteSheet.tiles);

    public static Sprite control_down_1 = new Sprite(ORIGINAL_SIZE, 2, 1, 12, 15, SpriteSheet.tiles);
    public static Sprite control_down_2 = new Sprite(ORIGINAL_SIZE, 2, 2, 12, 16, SpriteSheet.tiles);

    public static Sprite control_right_1 = new Sprite(ORIGINAL_SIZE, 1, 1, 11, 16, SpriteSheet.tiles);
    public static Sprite control_right_2 = new Sprite(ORIGINAL_SIZE, 1, 2, 12, 16, SpriteSheet.tiles);

    public static Sprite control_left_1 = new Sprite(ORIGINAL_SIZE, 3, 1, 11, 16, SpriteSheet.tiles);
    public static Sprite control_left_2 = new Sprite(ORIGINAL_SIZE, 3, 2, 12, 16, SpriteSheet.tiles);
}
