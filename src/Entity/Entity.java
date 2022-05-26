package Entity;

import Entity.Character.Bomber;
import Entity.Character.Enemy.Enemy;
import GameRunning.Game;
import Graphics.Render;
import Graphics.Screen;
import Graphics.Sprite;

import java.awt.*;


public class Entity implements Render {
    protected double x;
    protected double y;
    protected boolean removed = false;
    protected Sprite sprite;

    public Entity(double x, double y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    @Override
    public void update(){};


    @Override
    public void render(Screen screen) {};

    public void setRemoved() {
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public boolean collide(Entity e) {
        return false;
    }

    public Rectangle getBounds() {
        if (this instanceof Bomber || this instanceof Enemy)
            return new Rectangle((int) x, (int) y, Game.TILES_SIZE, Game.TILES_SIZE);
        else
            return new Rectangle(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y + 1), Game.TILES_SIZE, Game.TILES_SIZE);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getXTile() {
        return Coordinates.pixelToTile(x + sprite.SIZE / 2);
    }

    public int getYTile() {
        return Coordinates.pixelToTile(y - sprite.SIZE / 2);
    }
}
