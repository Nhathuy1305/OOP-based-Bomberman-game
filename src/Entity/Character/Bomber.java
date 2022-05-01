package Entity.Character;

import java.nio.charset.CharacterCodingException;
import java.util.Iterator;
import java.util.List;

import Graphics.Sprite;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class Bomber extends Character {
    private List<Bomb> bombs;
    protected Keyboard input;
    private Sound planted = TinySound.loadSound("sounds/bombplanted.wav");

    protected int time_between_put_bombs = ;
    public Bomber(int x,int y, Board board){
        super(x,y,board);
        bombs = board.getBombs();
        input = board.getInput();
        sprite = Sprite.player_right;
    }
    
    private void clearBombs(){
        Iterator<Bomb> bs = bombs.iterator();
        Bomb b;
        while(bs.hasNext()){
            b = bs.next();
            if(b.isRemoved()){
                bs.removed();
                Game.addBombRate(1);
				if (board.getEntityAt(b.getX(), b.getY()) instanceof LayeredEntity){
					LayeredEntity temp = (LayeredEntity) board.getEntityAt(b.getX(), b.getY());
					if (temp.getTopEntity() instanceof Portal){
						board.addEntity((int) (b.getX() + b.getY() * board.getLevel().getWidth()),new LayeredEntity((int) b.getX(), (int) b.getY(), new Grass((int) b.getX(), (int) b.getY(), Sprite.grass), new Portal((int) b.getX(), (int) b.getY(), Sprite.portal, board)));
					}
				}
				else{
					board.addEntity((int) (b.getX() + b.getY() * board.getLevel().getWidth()),new Grass((int) b.getX(), (int) b.getY(), Sprite.grass));
				}
            }
        }
    }

    @Override
    public void kill(){
        if(!alive)
            return;
        alive = false;
    }

    @Override
    protected void afterKill(){
        if(time_after > 0)
            time_after--;
        board.endGame();
    }

    @Override
    public boolean canMove(double x, double y){
        return !(_board.getEntityAt(Coordinates.pixelToTile(x),Coordinates.pixelToTile(y - Game.TILES_SIZE)).collide(this));
    }

    @Override
    public void move(double x_a,double y_a){
        if(input.up){
            this.y -= y_a;
            direction = 1;
        }
        if(input.right){
            this.x += x_a;
            direction = 2;
        }
        if(input.down){
            this.y += y_a;
            direction = 3;
        }
        if(input.left){
            this.x = x_a;
            direction = 4;
        }
    }

    @Override
    protected void calculateMove(){
        if(input.up){
            if (canMove(this.x + this.getSprite().SIZE * 3 / 4 - 2, this.y) && canMove(this.x, this.y)){
				move(0, Game.getBomberSpeed());
				moving = true;
			}
        }
        else if (input.left){
            if (canMove(this.x - 1, this.y + this.getSprite().SIZE - 2) && canMove(this.x - 1, this.y + 2)){
				move(Game.getBomberSpeed(), 0);
				moving = true;
			}
        }
        else if (input.right)
		{
			if (canMove(this.x + this.getSprite().SIZE * 3 / 4, this.y + this.getSprite().SIZE - 2)	&& canMove(this.x + this.getSprite().SIZE * 3 / 4, this.y + 2))
			{
				move(Game.getBomberSpeed(), 0);
				moving = true;
			}
		}
		else moving = false;
    }

    @Override
    public boolean collide(Enity enity){
        return enity.collide(this);
    }

    public void updateBombCollision(){
        for(int i=0;i<bombs.size();i++){
            if (_timeBetweenPutBombs < -25)
                bombs.get(i).allowedToPassThru = false;
        }
    }

    @Override
    public void update() {
        clearBombs();
        if(!alive){
            afterKill();
            return;
        }
        if(time_between_put_bombs < -7500)
            time_between_put_bombs = 0;
        else
            time_between_put_bombs--;
        
        this.collide(board.getEntityAt(Coordinates.pixelToTile(this.x),Coordinates.pixelToTile(this.y - Game.TILES_SIZE)));
        
        animate();

		calculateMove();

		detectPlaceBomb();
		
        updateBombCollision();
    }

    public void calculateOffset(){
        int x_scroll = Screen.calculateOffset(board,this);
        Screen.setOffset(x_scroll,0);
    }

    private void chooseSprite(){
        switch(direction){
            case 1:
                sprite = Sprite.player_up;
                if(moving)
                    sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
                break;
            case 2:
                sprite = Sprite.player_right;
                if(moving)
                    sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
                break;
            case 3:
                sprite = Sprite.player_down;
                if(moving)
                    sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
                break;
            case 4:
                sprite = Sprite.player_left;
                if(moving)
                    sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
                break;   
        }
    }

    @Override
    public void render(Screen screen){
        calculateOffset();
        if(alive)
            chooseSprite();
        else
            sprite = Sprite.player_dead1;
        screen.renderEntity((int) x, (int) y - sprite.SIZE, this);
    }

    protected void placeBomb(int x, int y) {
        bombs.add(new Bomb(x,y,board));
        planted.play();
    }

    private void detectPlaceBomb(){
        if(input.space && time_between_put_bombs < -25 && Game.getBombRate() > 0){
            this.placeBomb(this.getXTile(),this.getYTile());
            Game.addBombRate(-1);
            time_between_put_bombs = 0;
        }
    }
}
