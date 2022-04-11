public class Flame {
    //extend entity

    protected Board _board;
    protected int _direction;
    private int _radius;
    protected int xOrigin, yOrigin;
    protected FlameSegment[] _flameSegments = new FlameSegment[0];

    /**
     *  x hoành độ bắt đầu của Flame
     *  y tung độ bắt đầu của Flame
     *  direction là hướng của Flame
     *  radius độ dài cực đại của Flame
     */

    //Constructor
    public Flame(int x, int y, int direction, int radius, Board board) {}


    //Tạo các FlameSegment, mỗi segment ứng một đơn vị độ dài
    private void createFlameSegments() {}

    //Tính toán độ dài của Flame, nếu gặp vật cản là Brick/Wall, độ dài sẽ bị cắt ngắn
    private int calculatePermitedDistance() {}

    public FlameSegment flameSegmentAt(int x, int y) {}

    public void update() {}

    public void render(Screen screen) {}

    //  xử lý va chạm với Bomber, Enemy. Chú ý đối tượng này có vị trí chính là vị trí của Bomb đã nổ
    public boolean collide(Entity e) {}
}
