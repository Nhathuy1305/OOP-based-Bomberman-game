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
}
