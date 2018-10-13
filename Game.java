import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{

    private Display display;
    private String title;
    private int width;
    private int height;
    private boolean running = false;
    private BufferedImage testImage;

    private Thread thread;

    private Graphics g;
    private BufferStrategy bs;

    public Game(String t, int w, int h) {
        title = t;
        width = w;
        height = h;
    }

    private void init() {
        display = new Display(title, width, height);
        testImage = ImageLoader.loadImage("/textures/Test.png");
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

        g.drawImage(testImage, 50, 50, null);


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
