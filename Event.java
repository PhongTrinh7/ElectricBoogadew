
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;


public class Event {
	
    private ArrayList<BufferedImage> pages; //Stores the images for this event. Maybe we can just render a pre drawn/written event.
    private int page;
    private Game game;
    private boolean eventing;
    private boolean switchButton;

    public Event (Game game, BufferedImage page) {
        pages = new ArrayList<>();
        pages.add(page);
        this.game = game;
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
    
    public boolean getStatus() {
    	return eventing;
    }
    
    public void setStatus(boolean e) {
    	eventing = e;
    }
    
    /*public void tick() {
		if(game.getKeyManager().one) {
		    page = 0;
			eventing = false;
		}
		if(game.getKeyManager().two) {
		    page = 1;
            State.setState(new CombatState(game, game.skeleDog));
		}
		if(game.getKeyManager().three) {
			eventing = false;
		}
    }*/

    public void render(Graphics g) {
        g.drawImage(pages.get(page), 160, 90, 960, 540, null);
    }

    public void tick() {

        if(switchButton) { //For when the choices pop up, switches the result of pressing the right arrow key.
            if(game.getKeyManager().right) {
                eventing = false;
            }
        }
        else {
            if(game.getKeyManager().right) {
                State.setState(new CombatState(game, game.skeleDog));
            }
        }

        if(game.getKeyManager().one) {
            page = 1;
            switchButton = true;
        }
        if(game.getKeyManager().two) {
            page = 2;
        }
        if(game.getKeyManager().three) {
            eventing = false;
        }
    }

}
