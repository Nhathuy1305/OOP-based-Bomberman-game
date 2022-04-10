package INTERACT;

import Entity.Entity;
import Graphics.Screen;
import Graphics.Sprite;

public abstract class Tile extends Entity {
    public Tile(int x, int y, Sprite sprite)
    {
        x = x;
        y = y;
        sprite = sprite;
    }

    /*
     Mặc định không cho bất cứ một đối tượng nào đi qua
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
    public void update();

}
