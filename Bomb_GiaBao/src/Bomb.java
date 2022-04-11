public class Bomb {
    protected double _timeToExplode = 120; //2 seconds
    public int _timeAfter = 20;

    protected Board _board;
    protected Flame[] _flames;
    protected boolean _exploded = false;
    protected boolean _allowedToPassThru = true;

    public Bomb(int x, int y, Board board) {}

    // update sau khi bomb nổ
    public void update() {}

    // render ra màn hình
    public void render(Screen screen) {}


    public void renderFlames(Screen screen) {}

    public void updateFlames() {}

    /*  Xử lý Bomb nổ  */
    protected void explode() {}

    public FlameSegment flameAt(int x, int y) {}


    //bomber đi ra sau khi vừa đặt bomb và flame của 2 bomb khác nhau va chạm
    public boolean collide(Entity e) {}
}
