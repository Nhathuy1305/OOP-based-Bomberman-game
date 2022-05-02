package Entity.Character.Enemy;

import Entity.Character.Enemy.AI.AIRandom;
import Graphics.Sprite;

public class Balloon extends Enemy {
    public Balloon(int x, int y, Board board){
        super(x, y, board, Sprite.balloon_dead, Game.getBomberSpeed() / 2, 100);
        sprite = Sprite.balloon_left1;
        AI = new AIRandom();
        direction = AI.calculateDirection();
    }

    @Override
    protected void chooseSprite(){
        switch(direction){
            case 0:
            case 1:
                sprite = Sprite.movingSprite(Sprite.balloon_right1, Sprite.balloon_right2, Sprite.balloon_right3, animate, 60);
                break;
            case 2:
            case 3:
                sprite = Sprite.movingSprite(Sprite.balloon_left1, Sprite.balloon_left2, Sprite.balloon_left3, animate, 60);
                break;
        }
    }
}
