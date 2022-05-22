import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import Graphics.Render;
import Input.Keyboard;
//import kuusisto.tinysound.Sound;
//import kuusisto.tinysound.TinySound;

public class Board implements Render {
    protected LevelLoader level_loader;
    protected Game game;
    protected Keyboard input;
    protected Screen screen;

    public Entity[] entities;
	public List<Character> characters = new ArrayList<>();
	protected List<Bomb> bombs = new ArrayList<>();
	private List<Message> messages = new ArrayList<>();

    private int screen_show = -1;
    private int time = Game.TIME;
    private int points = Game.POINTS;
    
    public static int highscore = 0;
    protected Sound gameover_sound = TinySound.loadSound("sounds/gameover.wav");

    public Board(Game game, Keyboard input, Screen screen){
		game = game;
		input = input;
		screen = screen;
		screen_show = 4;
	}

    @Override
	public void render(Screen screen){
		if (game.isPaused())
			return;

		int x0 = Screen.x_offset >> 4;
		int x1 = (Screen.x_offset + screen.getWidth() + Game.TILES_SIZE) / Game.TILES_SIZE; 
		int y0 = Screen.y_offset >> 4;
		int y1 = (Screen.y_offset + screen.getHeight()) / Game.TILES_SIZE;

		for (int y = y0; y < y1; y++){
			for (int x = x0; x < x1; x++){
				entities[x + y * level_loader.getWidth()].render(screen);
			}
		}

		renderBombs(screen);
		renderCharacter(screen);
	}

    public void endGame(){
        game.game_background_sound.stop();
        game.gameover_sound.play(0.5);
        screen_show = 1;
        game.resetScreenDelay();
        game.pause();

        BufferedWriter write;

        try{
			write = new BufferedWriter(new FileWriter(new File("res/highscore.txt")));
			if (Game.highscore < this.points)
				write.write(String.valueOf(this.points));
			else
				write.write(String.valueOf(Game.highscore));
			
			write.close();
		} 
		catch (IOException e){
			e.printStackTrace();
		}
    }

    public boolean detectNoEnemies(){
		int total = 0;
		for (int i = 0; i < characters.size(); i++){
			if (characters.get(i) instanceof Bomber == false)
				++total;
		}
		return total == 0;
	}

    public void drawScreen(Graphics g)
	{
		switch (screen_show)
		{
			case 1:
				screen.drawEndGame(g, points);
				break;
			case 2:
				screen.drawChangeLevel(g, level_loader.getLevel());
				break;
			case 3:
				screen.drawPaused(g);
				break;
			case 4:
				screen.drawMenu(g);
				break;
			case 5:
				screen.drawHighscore(g);
				break;
		}
	}

    protected void detectEndGame(){
        if(time <= 0)
            endGame();
    }

    public void loadLevel(int level){
		time = Game.TIME;
		screen_show = 2;
		game.resetScreenDelay();
		game.pause();
		characters.clear();
		bombs.clear();
		messages.clear();
		resetBomberStats();

		try{
			level_loader = new FileLevelLoader(this, level);
			entities = new Entity[level_loader.getHeight() * level_loader.getWidth()];

			level_loader.createEntities();

		} 
        catch (Exception e){
			endGame();
		}
	}

    public void nextLevel(){
		loadLevel(level_loader.getLevel() + 1);
	}

    public Entity getEntity(double x, double y, Character m){
		Entity res = null;
        
		res = getFlameSegmentAt((int) x, (int) y);
		if (res != null)
			return res;

		res = getBombAt(x, y);
		if (res != null)
			return res;

		res = getCharacterAtExcluding((int) x, (int) y, m);
		if (res != null)
			return res;

		res = getEntityAt((int) x, (int) y);

		return res;
	}

    public List<Bomb> getBombs(){
		return _bombs;
	}

    public Bomb getBombAt(double x, double y){
		Iterator<Bomb> bs = bombs.iterator();
		Bomb b;
		while (bs.hasNext()){
			b = bs.next();
			if (b.getX() == (int) x && b.getY() == (int) y)
				return b;
		}
		return null;
	}

    public Bomber getBomber(){
		Iterator<Character> iterator = characters.iterator();

		Character current;
		while (iterator.hasNext()){
			current = iterator.next();

			if (current instanceof Bomber)
				return (Bomber) current;
		}
		return null;
	}

    public Character getCharacterAtExcluding(int x, int y, Character character){
		Iterator<Character> iterator = characters.iterator();

		Character current;
		while (iterator.hasNext()){
			current = iterator.next();
			if (current == character)
				continue;

			if (current.getXTile() == x && current.getYTile() == y)
				return current;
		}
		return null;
	}

    public FlameSegment getFlameSegmentAt(int x, int y){
		Iterator<Bomb> bs = bombs.iterator();
		Bomb b;
		while (bs.hasNext()){
			b = bs.next();

			FlameSegment flame = b.flameAt(x, y);
			if (flame != null)
				return flame;
		}
		return null;
	}

    public Entity getEntityAt(double x, double y){
		return entities[(int) x + (int) y * level_loader.getWidth()];
	}

	public void addEntity(int pos, Entity e){
		entities[pos] = e;
	}

	public void addCharacter(Character c){
		characters.add(c);
	}

	public void addBomb(Bomb b){
		bombs.add(b);
	}

	public void addMessage(Message m){
		messages.add(m);
	}

    protected void renderCharacter(Screen screen)
	{
		Iterator<Character> iterator = characters.iterator();

		while (iterator.hasNext())
			iterator.next().render(screen);
	}

	protected void renderBombs(Screen screen)
	{
		Iterator<Bomb> iterator = bombs.iterator();

		while (iterator.hasNext())
			iterator.next().render(screen);
	}

    public void renderMessages(Graphics g){
		Message m;
		for (int i = 0; i < messages.size(); i++)
		{
			m = messages.get(i);

			g.setFont(new Font("Arial", Font.PLAIN, m.getSize()));
			g.setColor(m.getColor());
			g.drawString(m.getMessage(), (int) m.getX() - Screen.x_offset * Game.SCALE, (int) m.getY());
		}
	}

    protected void updateEntities(){
		if (game.isPaused())
			return;
		for (int i = 0; i < entities.length; i++)
			entities[i].update();
	}

    protected void updateCharacters(){
		if (game.isPaused())
			return;
		Iterator<Character> iterator = characters.iterator();

		while (iterator.hasNext() && !game.isPaused())
			iterator.next().update();
	}

	protected void updateBombs(){
		if (game.isPaused())
			return;
		Iterator<Bomb> iterator = bombs.iterator();

		while (iterator.hasNext())
			iterator.next().update();
	}

    protected void updateMessages(){
		if (game.isPaused())
			return;
		Message m;
		int left;
		for (int i = 0; i < messages.size(); i++)
		{
			m = messages.get(i);
			left = m.getDuration();

			if (left > 0)
				m.setDuration(--left);
			else messages.remove(i);
		}
	}

    protected void resetBomberStats(){
		Game.bomber_speed = 1.0;
		Game.bomb_rate = 1;
		Game.bomb_radius = 1;
	}

	public int subtractTime(){
		if (game.isPaused())
			return this.time;
		else return this.time--;
	}

	public Keyboard getInput(){
		return input;
	}

	public LevelLoader getLevel(){
		return levelLoader;
	}

	public Game getGame(){
		return game;
	}

	public int getShow(){
		return screen_show;
	}

	public void setShow(int i){
		screen_show = i;
	}

	public int getTime(){
		return time;
	}

	public int getPoints(){
		return points;
	}
        
    public void resetPoints(){
        points = 0;
    }

	public void addPoints(int points){
		this.points += points;
	}

	public int getWidth(){
		return level_loader.getWidth();
	}

	public int getHeight(){
		return level_loader.getHeight();
	}

	@Override
    public void update(){
        if(game.isPause())
            return;
        updateEntities();
        updateCharacters();
        updateBombs();
        updateMessages();
        detectEndGame();

        for (int i = 0; i < characters.size(); i++){
            Character character_i = characters.get(i);
            if (character_i.isRemoved())
                characters.remove(i);
        }
    }

}
