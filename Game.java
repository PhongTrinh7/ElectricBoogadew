
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public class Game implements Runnable, Serializable {
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	transient private Thread producer;
	transient private Thread consumer;

	private BufferStrategy bs;
	private Graphics g; 
	
	public Player gravy, skele, bunj;
	public NPC skeleDog, sword;
	
   //States
	public State gameState;
	public State menuState;
	
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

	   	//Our heroes and villains.
		gravy = new Player(this,420, 500, "Gravy", 50, Assets.gravy);
		gravy.addAnimation(Assets.gravy_action, 500);
		gravy.addAnimation(Assets.gravy_dead, 500);

		skele = new Player(this, 300, 450, "Skele", 50, Assets.skeleman);
		skele.addAnimation(Assets.skeleman_tele, 500);
		skele.addAnimation(Assets.skele_dead, 500);

		bunj = new Player(this, 450, 400, "Bunjamen", 50, Assets.bunj);
		bunj.addAnimation(Assets.bunj_smash, 500);
		bunj.addAnimation(Assets.bunj_dead, 500);

		skeleDog = new NPC(450, 370, 8, 8, 100, Assets.skeleDog);
		skeleDog.addAnimation(Assets.skeleDogAtk, 300);
		skeleDog.addAnimation(Assets.skeleDog_dead, 500);

		sword = new NPC(450, 400, 6, 6, 100, Assets.sword);
		sword.addAnimation(Assets.swordAtk, 500);
		sword.addAnimation(Assets.sword_dead, 500);


		gameState = new GameState(this);
	    menuState = new MenuState(this);
	    State.setState(menuState);
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

		
		while(running) {

			try {
				thread.sleep(fps);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			tick();
			render();

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
		producer = new Thread() {
			@Override
			public void run() {
				while (running)
				System.out.println("W");
			}
		};
		consumer = new Thread() {
			@Override
			public void run() {
				while (running)
				System.out.println("M");
			}
		};
		producer.start();
		consumer.start();
	}

    public synchronized void stop() {
    	if(!running) { //in case it is already stopped.
    		return;
    	}
    	
    	running = false;
    	try {
			thread.join(); //used to stop thread.
			producer.join();
			consumer.join();
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

    public void cereal() {

	}
}
