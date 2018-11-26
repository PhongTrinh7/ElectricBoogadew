package dev.pro.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.pro.game.display.Display;
import dev.pro.game.gfx.Assets;
import dev.pro.game.gfx.ImageLoader;
import dev.pro.game.gfx.SpriteSheet;
import dev.pro.game.input.KeyManager;
import dev.pro.game.input.MouseManager;
import dev.pro.game.states.CombatState;
import dev.pro.game.states.GameState;
import dev.pro.game.states.MenuState;
import dev.pro.game.states.State;

public class Game implements Runnable{ //Runnable is the Thread thing.
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread; //Thread is like its own minnie program.
	
	private BufferStrategy bs;
	private Graphics g; 
	
   //States
	public State gameState;
	public State menuState;
	public State combatState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager; 
	
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
	}
	
	private void init() { //initializes everything.
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
	    Assets.init();
	    
	    
	    gameState = new GameState(this);
	    menuState = new MenuState(this);
	    //Commented out for now and is being instantiated in menu state.
	    combatState = new CombatState(this); 
	    //Uncomment it if you want to jump straight into combat state.
	    State.setState(combatState);
	}
	
	
	
	private void tick() { //updates the game.
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render() { 
		//Buffer strategy is a way for the comp to draw things to the
		//screen.
		//A buffer is a hidden comp screen. 
		bs = display.getCanvas().getBufferStrategy(); 
		
		if(bs == null) { //For if we are just starting the game.
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics(); //Allows us to draw things
		
		g.clearRect(0, 0, width, height);//Clears screen,
		//Draw Here
		if(State.getState() != null) {
			State.getState().render(g);
		}
		//END Drawing
		bs.show();
		g.dispose();
		
	}
	
	public void run(){
		
		init();
		
		int fps = 30;
	//	double timePerTick = 1000000000 / fps;
	//	double delta = 0;
	//	long now;
	//	long lastTime = System.nanoTime();
	//	long timer = 0;
	//	int ticks = 0;
		
		while(running) {
		//	now = System.nanoTime();
		//	delta += (now - lastTime) / timePerTick;
		//	timer += now - lastTime;
		//	lastTime = now;
			try {
			  thread.sleep(fps);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		//	if(delta >= 1) {
			    tick();
			    render();
			//    ticks++;
			//    delta--;
		//	}
			
		//	if(timer >= 1000000000) {
		//		System.out.println("Ticks and Frames: " + ticks);
		//		ticks = 0;
		//		timer = 0;
			}
			
		
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public synchronized void start() {
		if(running) { //in case it is already running.
			return;
		}
		
		running = true;
		thread = new Thread(this); //"this" means the current class
		                           //you are in.
		thread.start(); //runs the run method where the majority of 
		                //code goes.
	}

    public synchronized void stop() {
    	if(!running) { //in case it is already stopped.
    		return;
    	}
    	
    	running = false;
    	try {
			thread.join(); //used to stop thread.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight(){
    	return height;
    }
}
