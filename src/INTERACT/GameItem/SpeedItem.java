package INTERACT.GameItem;

import Entity.Character.Bomber;
import Entity.Entity;
import GameRunning.Board;
import GameRunning.Game;
import Graphics.Sprite;
import INTERACT.Grass;

public class SpeedItem extends Item{
    private Board board;

    public SpeedItem(double x, double y, Sprite sprite, Board board) {
        super(x, y, sprite);
        this.board = board;
    }

    @Override
    public boolean collide(Entity e) {
        if (e instanceof Bomber) {
            board.addEntity((int) (this.x + this.y * board.getLevel().getWidth()),
                    new Grass((int) this.x, (int) this.y, Sprite.grass));
            Game.addBomberSpeed(0.25);
        }
        return false;
    }
}
