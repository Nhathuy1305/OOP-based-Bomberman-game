package INTERACT;

import Entity.Entity;
import Graphics.Sprite;


public class Portal extends Tile {
    private Board board;

    public Portal(int x, int y, Sprite sprite, Board board) {
        super(x, y, sprite);
        this.board = board;
    }

    @Override
    public boolean collide(Entity e) {
        if (e instanceof Bomber)
        {
            boolean allEnemiesDead = true;
            for (int i = 0; i < board.characters.size(); i++)
            {
                if (board.characters.get(i) instanceof Enemy)
                {
                    allEnemiesDead = false;
                    break;
                }
            }
            if (allEnemiesDead)
                board.nextLevel();
        }
        return false;
    }
}