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
}
