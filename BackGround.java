import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGround { //TBD

    protected BufferedImage scene;
    private static final int WIDTH = 1920, HEIGHT = 1080;

    public BackGround(BufferedImage s) {
        scene = s;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(scene,x,y,WIDTH,HEIGHT,null);
    }
}
