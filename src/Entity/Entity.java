package Entity;

import Graphics.Render;
import Graphics.Screen;
import Graphics.Sprite;

import java.awt.*;


public class Entity implements Render {
    protected double x;
    protected double y;
    protected boolean removed = false;
    protected Sprite sprite;

    @Override
    public void uppdate();


    @Override
    public void render(Screen screen) {

    }

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

    //
}
