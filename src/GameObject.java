import java.awt.*;
import java.awt.image.BufferedImage;

public interface GameObject { //Self explanatory.

    void tick();

    void render(Graphics g);
}
