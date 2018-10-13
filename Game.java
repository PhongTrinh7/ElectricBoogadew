import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private Display display;
    private String title;
    private int width;
    private int height;
    private boolean running = false;

    private Thread thread;

    private Graphics g;
    private BufferStrategy bs;

    public Game(String t, int w, int h) {
        title = t;
        width = w;
        height = h;
    }

    private void init() {
        display = new Display("Test", 600, 300);
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

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);


        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        while (running) {
            tick();
            render();
        }
    }
}
