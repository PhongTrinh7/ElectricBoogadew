package dev.pro.game.states;

import java.awt.Graphics;

import dev.pro.game.Game;
import dev.pro.game.gameobjects.creatures.NPC;
import dev.pro.game.gameobjects.creatures.Player;
import dev.pro.game.gfx.Animation;
import dev.pro.game.gfx.Assets;
import dev.pro.game.ui.ClickListener;
import dev.pro.game.ui.UIImageButton;
import dev.pro.game.ui.UIManager;

public class CombatState extends State{
	
	private NPC gravy;
	private Player skele;
	private boolean action;
	
    private UIManager combatUI;
	//private Animation skele_tele_animation;
	//int skeleX = 150;
	
	public CombatState(Game game) {
		super(game);
		
		gravy = new NPC(game, 780, 400, Assets.gravy);
		gravy.addAnimation(Assets.gravy_action);
		skele = new Player(game, 480, 400, "Skele", Assets.skeleman);
		skele.addAnimation(Assets.skeleman_tele);
		action = false;
		
		combatUI = new UIManager(game);
		game.getMouseManager().setUIManager(combatUI);
		combatUI.addObject(new UIImageButton(200, 200, 64, 64, new ClickListener() {
			
			public void onClick() {
				//skele.setAction(true);
				action = true;
				//game.getMouseManager().setUIManager(null);
				//State.setState(game.gameState);
				

			}}));
		
		
		//skele_tele_animation = new Animation(500, Assets.skeleman_tele);
		  
    }

	@Override
	public void tick() {
	    combatUI.tick();
		
		skele.tick();
		gravy.tick();
		
	}

	@Override
	public void render(Graphics g) {
		if(action) {
			skele.action(1);
			action = false;
		}
       
		//Make an if statement that compares the 
		//current frame of skele to see if they are done
		//with the attack animation.
		
		combatUI.render(g);
		skele.render(g);
		gravy.render(g);
		//g.drawImage(skele_tele_animation.getCurrentFrame(), skeleX, 530, 150, 100, null);
	}

}
