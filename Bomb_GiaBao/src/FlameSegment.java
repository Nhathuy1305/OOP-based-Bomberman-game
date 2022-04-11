public class FlameSegment {
    protected boolean _last;

    /**
     *
     *  x
     *  y
     *  direction
     *  last cho biết segment này là cuối cùng của Flame hay không,
     *  segment cuối có sprite khác so với các segment còn lại
     */
    public FlameSegment(int x, int y, int direction, boolean last) {}

    public void render(Screen screen) {}

    public void update() {}

    //  xử lý khi FlameSegment va chạm với Character
    public boolean collide(Entity e) {}
}
