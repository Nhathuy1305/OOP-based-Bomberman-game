package INTERACT.Destroyable;

import Graphics.Sprite;
import INTERACT.Tile;

public class DestroyableTile extends Tile {
    private final int MAX_ANIMATE = 7500;
    private int animate = 0;
    protected  boolean destroyed = false;
    protected int timeToDisappear = 20;
    protected Sprite belowSprite = Sprite.grass;

    public DestroyableTile(double x, double y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void update() {

    }
}
