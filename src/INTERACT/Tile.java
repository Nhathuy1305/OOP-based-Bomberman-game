package INTERACT;

import Entity.Entity;
import Graphics.Screen;
import Graphics.Sprite;

public abstract class Tile extends Entity {
    public Tile(double x, double y, Sprite sprite) {
        super(x, y, sprite);
    }

    /*
             No things can pass through by default.
             */
    @Override
    public boolean collide(Entity e)
    {
        return false;
    }

    @Override
    public void render(Screen screen)
    {
        screen.renderEntity(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y), this);
    }

    @Override
    public void update(){};
}
