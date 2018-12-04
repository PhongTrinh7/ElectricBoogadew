
import java.awt.Graphics;

public class GameState extends State{
	
	//private boolean event;
	//private UIManager gameUI;
	private Event dogEvent, eggEvent;
	
	private Animation cart_Animation;
	
	public GameState(Game game) {
		super(game);
		cart_Animation = new Animation(500, Assets.cart);
		
		dogEvent = new Event(game, Assets.dog);
		dogEvent.addPage(Assets.dog_oil);
		dogEvent.addPage(Assets.dog_demon);
		
		eggEvent = new Event(game, Assets.egg);
	}
	
    int fgx = 0; //Foreground position.
    int mgx = 0;
    int cartx = 150; //Cart position.

	@Override
	public void tick() {
	    
		if(!dogEvent.getStatus() && !eggEvent.getStatus()) {
			
		    if(fgx == -200) {
			    dogEvent.setStatus(true);
		    }
		    if(fgx == -400) {
		    	eggEvent.setStatus(true);
				//setState(new CombatState(game, game.sword));
		    }
		    if(mgx > -1160){
			    mgx -=1;
		    }
		    if(fgx > -2320) {
			    cart_Animation.tick();
			    fgx -= 2;
		    }
		    else {
			    if(cartx < 900) {
				    cartx += 1;
				    cart_Animation.tick();
			    }
		    }
		}
		else if(dogEvent.getStatus()){
			dogEvent.tick();
		}
		else if(eggEvent.getStatus()) {
			eggEvent.tick();
		}
		
	}

	@Override
	public void render(Graphics g) {	 
	    g.drawImage(Assets.forestBack, 0, 0, 1280, 720, null);
	    g.drawImage(Assets.forestMid, mgx, 0, 2160, 720, null);
	    g.drawImage(Assets.forestFore, fgx, 0, 2880, 720, null);
	    g.drawImage(Assets.inn, fgx + 2700, 435, 200, 200, null);
	    g.drawImage(cart_Animation.getCurrentFrame(),cartx, 530, 150, 100, null);
	    
	    if(dogEvent.getStatus()) {
	    	dogEvent.render(g);

	    }
	    if(eggEvent.getStatus()) {
	    	eggEvent.render(g);
	    }
	    
	}

}
