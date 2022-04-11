public class Bomber extends Character {
    private List<Bomb> _bombs;
	protected Keyboard _input;
	private Sound planted = TinySound.loadSound("sounds/bombplanted.wav");
    protected int _timeBetweenPutBombs = 0; //nếu giá trị này < 0 thì cho phép đặt đối tượng Bomb tiếp theo, cứ mỗi lần đặt 1 Bomb mới, giá trị này sẽ được reset về 0 và giảm dần trong mỗi lần update()

    public Bomber(int x, int y, Board board) {} //hàm constructor
    @Override
	public void update(){} //Phương thức này được gọi liên tục trong vòng lặp game, mục đích để xử lý sự kiện và cập nhật trạng thái Entity
    @Override
	public void render(Screen screen){}//Phương thức này được gọi liên tục trong vòng lặp game, mục đích để cập nhật hình ảnh của entity theo trạng thái
    public void calculateXOffset(){}// CHƯA LĨNH HỘI ĐƯỢC
    private void detectPlaceBomb(){} //kiểm tra xem có đặt được bom hay không? nếu có thì đặt bom tại vị trí hiện tại của Bomber
    protected void placeBomb(int x, int y){} //đặt bom
    private void clearBombs(){}//dọn bomb sau khi nổ
    @Override
	public void kill(){} //Được gọi khi đối tượng bị tiêu diệt
    @Override
	protected void afterKill(){}// hiệu ứng khi bị tiêu diệt
    @Override
	protected void calculateMove(){} //tính tọa độ di chuyển
    @Override
	public boolean canMove(double x, double y){} //kiểm tra xem nhân vật có thể đi qua tọa độ đó không (tọa độ không có chướng ngại vật) kiểm tra xem có thể di chuyển tới điểm đã tính và thực hiện thay đổi tọa độ _x, _y
    @Override
	public void move(double xa, double ya){} //nhận tín hiệu từ bàn phím để nhân vật di chuyển
    @Override
	public boolean collide(Entity e){} //xử lý va chạm với Flame và Enemy
    private void chooseSprite(){}// thức hiện di chuyển nhân vật sau khi nhận tín hiệu từ bàn phím
    public void updateBombCollision(){}//đặt nhiều bomb cùng 1 thời điểm (sau khi ăn được vật phẩm)
}