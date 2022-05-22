import Input.Keyboard;
import Graphics.Screen;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBufferInt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;


public class Game extends Canvas implements MouseListener {
    public static final int TILES_SIZE = 16, WIDTH = TILES_SIZE * (31 / 2), HEIGHT = TILES_SIZE * 13;
    public static int SCALE = 3;

    public static final String TITLE = "Bomberman";

    private static final int BOMB_RATE = 1;
    private static final int BOMB_RADIUS = 1;
    private static final double BOMBER_SPEED = 1.0;

    public static final int TIME = 200;
    public static final int POINTS = 0;

    protected static int SCREEN_DELAY = 3;

    protected static int bomb_rate = BOMB_RATE;
    protected static int bomb_radius = BOMB_RADIUS;
    protected static double bomber_speed = BOMBER_SPEED;

    protected int screen_delay = SCREEN_DELAY;

    private Keyboard input;
    private boolean running = false;
    private boolean paused = true;
    private boolean menu = true;

    private Board board;
    private Screen screen;
    private Frame frame;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	protected Music game_background_sound = TinySound.loadMusic("sounds/background.wav");
	protected Music menu_background_sound = TinySound.loadMusic("sounds/mainmenu.wav");
	protected Sound gameover_sound = TinySound.loadSound("sounds/gameover.wav");
	
	public static int high_score = 0;

    public Game(Frame frame){
        this.frame = frame;
        this.frame.setTitle(TITLE);

        screen = new Screen(WIDTH, HEIGHT);
        input = new Keyboard();
        board = new Board(this, input, screen);
        addKeyListener(input);
        addMouseListener(this);
    }

    public static double getBomberSpeed(){
        return bomber_speed;
    }

    public static int getBombRate(){
        return bomb_rate;
    }

    public static int getBombRadius() {
        return bomb_radius;
    }

    public static void addBomberSpeed(double i){
        bomber_speed += i;
    }

    public static void addBombRadius(int i)
	{
		bomb_radius += i;
	}

	public static void addBombRate(int i)
	{
		bomb_rate += i;
	}

	public void resetScreenDelay()
	{
		screen_delay = SCREEN_DELAY;
	}

	public Board getBoard()
	{
		return board;
	}

	public boolean isPaused()
	{
		return paused;
	}

	public void pause()
	{
		paused = true;
	}

    private void renderGame(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        screen.clear();
         
        board.render(screen);

        for(int i = 0; i < pixels.length; i++){
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();

        board.drawScreen(g);

        g.dispose();
        bs.show();
    }
    
    private void renderScreen()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}

		screen.clear();

		Graphics g = bs.getDrawGraphics();

		board.drawScreen(g);

		g.dispose();
		bs.show();
	}

    private void update(){
        input.update();
        board.update();
    }

    public void start() {
        menu_background_sound.play(true);
        readHighscore();
        while(menu){
            renderScreen();
        }

        menu_background_sound.stop();
        menu_background_sound.play(true, 0.5);

        board.loadLevel(1);
        long last_time = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0; // nanosecond, 60 frames per second
        double delta = 0;
        int frames = 0;
        int updates = 0;
        requestFocus();

        while(running){
            long now = System.nanoTime();
            delta += (now - last_time) / ns;
            last_time = now;
            while(delta >= 1){
                update();
                updates++;
                delta--;
            }
            if(input.esc){
                paused = true;
            }

            if(paused){
                if(screen_delay <= 0){
                    board.setShow(3);
                    paused = false;
                }
                renderScreen();
            }

            else{
                renderGame();
            }

            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                frame.setTime(board.subtractTime());
                frame.setPoints(board.getPoints());
                timer += 1000;
                frame.setTitle(TITLE + " | " + updates + " rate, " + frame + " fps");
                updates = 0;
                frames = 0;

                if(board.getShow() == 2){
                    --screen_delay;
                }
            }
        }
    }
}
