public abstract class Character{

    protected Board _board;
    protected int _direction = 1;
    protected boolean _alive = true;
    protected boolean _moving = false;
    public int _timeAfter = 40;

    public Character(int x, int y){
        
    }

    @Override
    public abstract void update();//Phương thức này được gọi liên tục trong vòng lặp game, mục đích để xử lý sự kiện và cập nhật trạng thái Entity

    @Override
    public abstract void render(Screen screen);//Phương thức này được gọi liên tục trong vòng lặp game, mục đích để cập nhật hình ảnh của entity theo trạng thái

    protected abstract void calculateMove();//Tính hướng di chuyển

    protected abstract void move();

    public abstract void kill();//Được gọi khi đối tượng bị tiêu diệt

    public abstract void afterKill();//Xử lý hiệu ứng khi đối tượng bị tiêu diệt

    protected abstract boolean canMove();//Kiểm tra xem đối tượng có di chuyển tới vị trí đã tính toán hay không

    protected double getXMessage(){}//Trả về hoành độ của message

	protected double getYMessage(){}//Trả về tung độ của message

}