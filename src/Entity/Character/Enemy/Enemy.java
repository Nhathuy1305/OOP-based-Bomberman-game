package Entity.Character.Enemy;

import Entity.Entity;
import Entity.Character.Bomber;
import Entity.Character.Character;
import Entity.Character.Enemy.AI.AI;
import Graphics.Sprite;
import Graphics.Screen;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import INTERACT.Grass;

public abstract class Enemy extends Character{
    protected int points;
    protected double speed;
    protected AI AI;

    protected final double max_steps;
    protected final double rest;
    protected double steps;

    protected int final_animation = 30;
    protected Sprite dead_sprite;
    private Sound killed_sound = TinySound.loadSound("sounds/enemykilled.wav");
    
    public Enemy(int x, int y, Board board, Sprite dead_sprite, double speed, int points){
        super(x, y, board);
        this.points = points;
        this.speed = speed;
        this.dead_sprite = dead_sprite;

        max_steps = Game.TILES_SIZE / speed;
		rest = (max_steps - (int) max_steps) / max_steps;
		steps = max_steps;

		time_after = 20;
    }

    @Override
    public void update(){
        animate();
        if(!alive){
            afterKill();
            return;
        }
        if(alive){
            calculateMove();
            this.collide(board.getEntityAt(Coordinates.pixelToTile(this.x), Coordinates.pixelToTile(this.y - Game.TILES_SIZE)));
        }
    }

    @Override
    public void render(Screen screen){
        if(alive){
            chooseSprite();
        }
        else{
            if(time_after > 0){
                sprite = dead_sprite;
                animate = 0;
            }
            else{
                sprite = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, animate, 60);
            }
        }
        screen.renderEntity((int) x, (int) y - sprite.SIZE, this);
    }

    @Override
    public void calculateMove(){
        if(steps <= 0){
            direction = AI.calculateDirection();
            steps = max_steps;
        }

        if(direction == 0){
            if(canMove(this.x + this.getSprite().SIZE / 2, this.y + this.getSprite().SIZE) && canMove(this.x, this.y + this.getSprite().SIZE)){
                steps--;
                move(speed, 0);
                moving = true;
            }
            else{
                steps = 0;
                moving = false;
            }
        }

        if(direction == 3){
            if(canMove(this.x + this.getSprite().SIZE * 3 / 4 - 2, this.y - 1) && canMove(this.x, this.y - 1)){
                steps--;
                move(0, -speed);
                moving = true;
            }
            else{
                steps = 0;
                moving = false;
            }
        }
    }

    @Override
    public void move(double xa, double ya){
        if(!alive)
            return;
        x += xa;
        y += ya;
    }

    @Override
    public boolean canMove(double x, double y){
        return !(board.getEntityAt(Coordinates.pixelToTile(x), Coordinates.pixelToTile(y - Game.TILES_SIZE))).collide(this);
    }

    @Override
    public boolean collide(Entity e){
        for(int i = 0; i < board.characters.size(); i++){
            if(board.characters.get(i) instanceof Bomber && board.characters.get(i).getBounds().intersects(this.getBounds())){
                board.characters.get(i).kill();
            }
        }
        return e.collide(this);
    }

    @Override
    public void kill(){
        if(!alive)
            return;
        alive = false;
        killed_sound.play();
        board.addPoints(points);

        Message msg = new Message("+" + points, getXMessage(), getYMessage(), 2, Color.white, 14);
        board.addMessage(msg);
    }

    @Override
    protected void afterKill(){
        if(time_after > 0)
            --time_after;
        else{
            if(final_animation > 0){
                --final_animation;
            }
            else remove();
        }
    }

    protected abstract void chooseSprite();
}
