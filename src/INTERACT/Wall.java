package INTERACT;

import Entity.Entity;
import Graphics.Sprite;

public class Wall extends Tile{
    public Wall(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public boolean collide(Entity e) {
        return super.collide(e);    // Đang cân nhắc
    }
}
