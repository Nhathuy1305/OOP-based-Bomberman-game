package INTERACT;

import Entity.Entity;
import Graphics.Sprite;

public class Grass extends Tile{
    public Grass(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    /*
     Cho bất kì đối tượng khác đi qua
     */
    @Override
    public boolean collide(Entity e)
    {
        return false;
    }
}
