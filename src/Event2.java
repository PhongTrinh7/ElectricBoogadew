
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Event2 {
	
    private ArrayList<BufferedImage> pages; //Stores the images for this event. Maybe we can just render a pre drawn/written event.
    private int page;
    private Game game;
    private boolean event = true;
    
    public Event2 (Game game, BufferedImage page) {
        pages = new ArrayList<>();
        pages.add(page);
        this.game = game;
        this.page = 0;
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
    
    public boolean getEvent() {
    	return event;
    }
    
    public void setEvent(boolean e) {
    	this.event = e;
    }
    
    public void tick() {
    	
    }
    
    public void render(Graphics g) {
    	g.drawImage(pages.get(page), 160, 90, 960, 540, null);
    }
    

}
