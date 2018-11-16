import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 * Created by Phong on 11/15/2018.
 */
public class Event {

    private LinkedList<BufferedImage> pages; //Stores the images for this event. Maybe we can just render a pre drawn/written event.
    private int page;

    public Event (BufferedImage page) {
        pages = new LinkedList<>();
        pages.add(page);
    }

    public void addPage(BufferedImage page) {
        pages.add(page);
    }

    public void next() {
        page++;
    }

    public BufferedImage getPage(int i) {
        return pages.get(page);
    }

    public void render(Graphics g) {
        g.drawImage(pages.get(page), 160, 90, 960, 540, null);
    }
}
