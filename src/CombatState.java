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
	
	private NPC enemy;
	private boolean action1, action2, action3;
	private int actionIndex, actionIndex2, actionIndex3;
	private int potionCount1, potionCount2, potionCount3;
	
    private UIManager combatUI;

	
	public CombatState(Game game) {
		super(game);
		
		action1 = false; //action for each character
		action2 = false;
		action3 = false;
	
		potionCount1 = 3;
		potionCount2 = 3;
		potionCount3 = 3;
		
		combatUI = new UIManager(game);
		game.getMouseManager().setUIManager(combatUI);
		
		combatUI.addObject(new UIImageButton(150, 300, 64, 64, Assets.gravy_button, new ClickListener() { //Button for the first Player.
			
			public void onClick() {
				action1 = true;
				actionIndex = 1;
			}}));
		
		combatUI.addObject(new UIImageButton(250, 300, 64, 64, Assets.bunj_button, new ClickListener() { //Button for the second Player.

			public void onClick() {
				action3 = true;
				actionIndex3 = 1; 
			}}));	
		
		combatUI.addObject(new UIImageButton(350, 300, 64, 64, Assets.skele_button, new ClickListener() { //Button for the third Player.

			public void onClick() {
				action2 = true;
				actionIndex2 = 1; 
			}}));	
			
		
		//Potion Buttons
		combatUI.addObject(new UIImageButton(150, 450, 64, 32, Assets.potion_button, new ClickListener() { //Potion for Gravy.

			public void onClick() {
				if(potionCount1 != 0) {
					game.gravy.setHealth((game.gravy.getHealth() + 10));
					potionCount1 -= 1;
				}
			}}));
		
		combatUI.addObject(new UIImageButton(250, 450, 64, 32, Assets.potion_button, new ClickListener() { //Potion for Bunj.

			public void onClick() {
				if(potionCount2 != 0) {
					game.bunj.setHealth((game.bunj.getHealth() + 10));
					potionCount2 -= 1;
				}
			}}));
		
		combatUI.addObject(new UIImageButton(350, 450, 64, 32, Assets.potion_button, new ClickListener() { //Potion for Skele.

			public void onClick() {
				if(potionCount3 != 0) {
					game.skele.setHealth((game.skele.getHealth() + 10));
					potionCount3 -= 1;
				}
			}}));
    }
    
	public void setEnemy(NPC e) {
		enemy = e;
	}

	@Override
	public void tick() {
		if(!action3) {
	        combatUI.tick();
		}
		if(enemy.getHealth() <= 0) { 
			if(game.getKeyManager().enter) {
				//game.getMouseManager().setUIManager(null);
				State.setState(game.gameState);
			}
		}
		enemy.tick();
		game.skele.tick();
		game.gravy.tick();
		game.bunj.tick();
		
	}

	@Override
	public void render(Graphics g) {
		if(action1) { //Gravy's action
			game.gravy.action(actionIndex);
			if(enemy.getHealth() > 0) {
			    enemy.setHealth((enemy.getHealth() - 25));
			}

			action1 = false;

		}
		if(action2) { //Skele's actions
			game.skele.action(actionIndex2);
			if(enemy.getHealth() > 0) {
			    enemy.setHealth((enemy.getHealth() - 15));
			}

			action2 = false;
		}
		if(action3) { //Bunj's actions
			game.bunj.action(actionIndex3);
			if(enemy.getHealth() > 0) {
			    enemy.setHealth((enemy.getHealth() - 15));
			}

			action3 = false;
		}

		if(game.skele.getCurrentIndex() == 3) {//Enemy actions
			if(game.gravy.getHealth() > 0) {
				enemy.attack();
				game.gravy.setHealth((game.gravy.getHealth() - 1));
			}
			else if(game.bunj.getHealth() > 0) {
				enemy.attack();
				game.bunj.setHealth((game.bunj.getHealth() - 1));
			}
			else if(game.skele.getHealth() > 0){
				enemy.attack();
				game.skele.setHealth((game.skele.getHealth() - 1));
			}

		}
		
		if(enemy.getHealth() <= 0) {
			g.drawImage(Assets.victory, 580, 80, 300, 200, null);
		}
		
		//Render each button separately. I try.
		combatUI.render(g);
		enemy.render(g);
		game.skele.render(g);
		game.gravy.render(g);
		game.bunj.render(g);
	}

}
