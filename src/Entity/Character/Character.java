package Entity.Character;

import Entity.AnimatedEntity;
import Graphics.Screen;

public abstract class Character extends AnimatedEntity {
    protected Board board;
    protected int direction = -1;
    protected boolean alive = true;
    protected boolean moving = false;
    protected int time_after = 40;

    public Character(int x, int y, Board board){
        this.x = x;
        this.y = y;
        this.board = board;
    }

    @Override
    public abstract void update();

    @Override
    public abstract void render();

    protected abstract void calculateMove();

    protected abstract void move();

    protected abstract void afterKill();
    
    public abstract void kill();

    protected abstract void canMove();

    protected double getXMessage()
	{
		return (x * Game.SCALE) + (sprite.SIZE / 2 * Game.SCALE);
	}

	protected double getYMessage()
	{
		return (y * Game.SCALE) - (sprite.SIZE / 2 * Game.SCALE);
	}
}
