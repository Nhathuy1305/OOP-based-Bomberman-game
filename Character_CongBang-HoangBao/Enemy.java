public abstract class Enemy extends Character {
    protected int _points;

	protected double _speed;
	protected AI _ai;

	protected final double MAX_STEPS;
	protected final double rest;
	protected double _steps;

	protected int _finalAnimation = 30;
	protected Sprite _deadSprite;

	private Sound killed_sound = TinySound.loadSound("sounds/enemykilled.wav");

	public Enemy(int x, int y, Board board, Sprite dead, double speed, int points){}

	@Override
    public abstract void update();//Phương thức này được gọi liên tục trong vòng lặp game, mục đích để xử lý sự kiện và cập nhật trạng thái Entity

    @Override
    public abstract void render(Screen screen);//Phương thức này được gọi liên tục trong vòng lặp game, mục đích để cập nhật hình ảnh của entity theo trạng thái

	public void calculateMove(){}//Tính toán hướng đi và di chuyển Enemy theo _ai và cập nhật giá trị cho _direction

	public boolean canMove(double x, double y){}//sử dụng canMove() để kiểm tra xem có thể di chuyển tới điểm đã tính toán hay không

	public void move(double xa, double ya){}//sử dụng move() để di chuyển

	public boolean collide(Entity e){}//

	@Override
	public void kill(){}//Được gọi khi đối tượng bị tiêu diệt

	@Override
	protected void afterKill(){}//Xử lý hiệu ứng khi đối tượng bị tiêu diệt

	protected abstract void chooseSprite();//

}
