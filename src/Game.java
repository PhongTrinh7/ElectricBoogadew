import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{

    //Display settings
    private Display display;
    private String title;
    private int width;
    private int height;

    //Running and thread
    private boolean running = false;
    private Thread thread;

    //Render tools.
    private Graphics g;
    private BufferStrategy bs;

    //States
    public State gameState; //Changed to public
    public State menuState //NEW
        
    //Input
    private KeyManager keyManger; //NEW
    private MouseManager mouseMager; //NEW

    public Game(String t, int w, int h) {
        title = t;
        width = w;
        height = h;
        keyManger = new KeyManager(); //NEW
        mouseManager = new MouseManager(); //NEW
        
    }

    //Initializes all of our game components.
    private void init() {
        display = new Display(title, width, height); //Initializes the display.
        display.getJFrame().addKeyListener(new KeyManager());
        
        display.getFrame().addMouseListener(mouseManager); //NEW
        display.getFrame().addMouseMotionListener(mouseManager); //NEW
        display.getCanvas().addMouseListener(mouseManager); //NEW
        display.getCanvas().addMouseMotionListener(mouseManager); //NEW
        Assets.init(); //Initializes our assets. (Textures and images.

        gameState = new GameState(this);
        menuState = new MenuState(this); //NEW
        State.setState(menuState); //Changed from gameState to menuState
    }

    //NEW
    public KeyManager getKeyManager(){
        return keyManager;
    }
    
    //NEW
    public MouseManager getMouseManager(){
        return mouseManager;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tick(){
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    //This renders the images.
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height); //This clears the screen.

        if (State.getState() != null) {
            State.getState().render(g);
        }

        bs.show(); //Displays the image from the buffer.
        g.dispose();
    }

    public void run() {

        init();

        int fps = 30;

        while (running) {
            try {
                thread.sleep(fps);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tick();
            render();
        }
    }
}
