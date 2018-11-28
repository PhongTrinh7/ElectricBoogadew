package dev.pro.game.states;

import java.awt.Graphics;

import dev.pro.game.Game;
import dev.pro.game.Events.Event;
import dev.pro.game.gameobjects.creatures.Player;
import dev.pro.game.gfx.Animation;
import dev.pro.game.gfx.Assets;
import dev.pro.game.ui.ClickListener;
import dev.pro.game.ui.UIImageButton;
import dev.pro.game.ui.UIManager;

public class GameState extends State{
	
	//private boolean event;
	//private UIManager gameUI;
	private Event dogEvent;
	
	private Animation cart_Animation;
	
	public GameState(Game game) {
		super(game);
		cart_Animation = new Animation(500, Assets.cart);
		//gameUI = new UIManager(game);
	    //game.getMouseManager().setUIManager(gameUI);
		//event = false;
		
		dogEvent = new Event(game, Assets.dog);
		
	}
	
    int fgx = 0; //Foreground position.
    int mgx = 0;
    int cartx = 150; //Cart position.

	@Override
	public void tick() {
	    
		if(dogEvent.getEvent()) {
			
		    if(fgx == -200) {
			    dogEvent.setEvent(false);
			    
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
		else {
			dogEvent.tick();

		}
	}

	@Override
	public void render(Graphics g) {	 
	    g.drawImage(Assets.forestBack, 0, 0, 1280, 720, null);
	    g.drawImage(Assets.forestMid, mgx, 0, 2160, 720, null);
	    g.drawImage(Assets.forestFore, fgx, 0, 2880, 720, null);
	    g.drawImage(Assets.inn, fgx + 2700, 435, 200, 200, null);
	    g.drawImage(cart_Animation.getCurrentFrame(),cartx, 530, 150, 100, null);
	    
	    if(!dogEvent.getEvent()) {
	    	dogEvent.render(g);

	    }
	    
	}

}
