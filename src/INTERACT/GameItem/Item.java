package INTERACT.GameItem;

import Graphics.Sprite;
import INTERACT.Tile;

public abstract class Item extends Tile {
    public Item(double x, double y, Sprite sprite) {
        super(x, y, sprite);
    }
}
