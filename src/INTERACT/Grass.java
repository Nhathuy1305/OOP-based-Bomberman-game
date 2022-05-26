package INTERACT;

import Entity.Entity;
import Graphics.Sprite;

public class Grass extends Tile{
    public Grass(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    /*
     Allow any other object pass
     */
    @Override
    public boolean collide(Entity e)
    {
        return false;
    }
}
