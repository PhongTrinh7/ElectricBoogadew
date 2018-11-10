package dev.pro.game.states;

import java.awt.Graphics;

import dev.pro.game.Game;
import dev.pro.game.gameobjects.creatures.Player;
import dev.pro.game.gfx.Animation;
import dev.pro.game.gfx.Assets;

public class GameState extends State{
	
	//private Player player;
	private Animation cart_Animation;
	
	public GameState(Game game) {
		super(game);
		//player = new Player(game ,100, 100, "Dave");
		
		cart_Animation = new Animation(500, Assets.cart);
		
	}
	
    int fgx = 0; //Foreground position.
    int mgx = 0;
    int cartx = 150; //Cart position.

	@Override
	public void tick() {
	    //player.tick();
		if(fgx == -200) {
			setState(new CombatState(game));
		}
		if(mgx > -800){
			mgx -=1;
		}
		if(fgx > -1600) {
			cart_Animation.tick();
			fgx -= 2;
		}
		else {
			if(cartx < 1000) {
				cartx += 1;
				cart_Animation.tick();
			}
		}
	}

	@Override
	public void render(Graphics g) {
		//player.render(g);
		
		
	    
	    g.drawImage(Assets.forestBack, 0, 0, 1280, 720, null);
	    g.drawImage(Assets.forestMid, mgx, 0, 2160, 720, null);
	    g.drawImage(Assets.forestFore, fgx, 0, 2880, 720, null);
	    g.drawImage(Assets.inn, fgx + 2700, 435, 200, 200, null);
	    g.drawImage(cart_Animation.getCurrentFrame(),cartx, 530, 150, 100, null);
	    
	}

}
