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
	
	private Player gravy, skele, bunj; //Instantiate somewhere else.
	private NPC skeleDog, sword;
	private boolean action1, action2, action3;
	private int actionIndex, actionIndex2, actionIndex3;
	private int potionCount1, potionCount2, potionCount3;
	
    private UIManager combatUI;

	
	public CombatState(Game game) {
		super(game);
		
		gravy = new Player(game, 180, 400, "Gravy", 50, Assets.gravy);
		gravy.addAnimation(Assets.gravy_action, 500);
		gravy.addAnimation(Assets.gravy_dead, 500);
		gravy.addProjectile(Assets.gravy_lightning);
		
		skele = new Player(game, 380, 400, "Skele", 50, Assets.skeleman);
		skele.addAnimation(Assets.skeleman_tele, 500);
		skele.addAnimation(Assets.skele_dead, 500);
		
		bunj = new Player(game, 280, 400, "Bunjamen", 50, Assets.bunj);
		bunj.addAnimation(Assets.bunj_smash, 500);
		bunj.addAnimation(Assets.bunj_dead, 500);
		
		skeleDog = new NPC(580, 400, 300, 200, 100, Assets.skeleDog);
		skeleDog.addAnimation(Assets.skeleDogAtk, 300);
		skeleDog.addAnimation(Assets.skeleDog_dead, 500);
		
        sword = new NPC(780, 400, 300, 200, 100, Assets.sword);
        sword.addAnimation(Assets.swordAtk, 500);
		
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
					gravy.setHealth((gravy.getHealth() + 10));
					potionCount1 -= 1;
				}
			}}));
		
		combatUI.addObject(new UIImageButton(250, 450, 64, 32, Assets.potion_button, new ClickListener() { //Potion for Bunj.

			public void onClick() {
				if(potionCount2 != 0) {
					bunj.setHealth((bunj.getHealth() + 10));
					potionCount2 -= 1;
				}
			}}));
		
		combatUI.addObject(new UIImageButton(350, 450, 64, 32, Assets.potion_button, new ClickListener() { //Potion for Skele.

			public void onClick() {
				if(potionCount3 != 0) {
					skele.setHealth((skele.getHealth() + 10));
					potionCount3 -= 1;
				}
			}}));
    }
    

	@Override
	public void tick() {
		if(!action3) {
	        combatUI.tick();
		}
		if(skeleDog.getHealth() <= 0) { //No death animation so it just switches.
			if(game.getKeyManager().enter) {
				game.getMouseManager().setUIManager(null);
				State.setState(game.gameState);
			}
		}
		skeleDog.tick();
		skele.tick();
		gravy.tick();
		bunj.tick();
	//	sword.tick();
		
	}

	@Override
	public void render(Graphics g) {
		if(action1) { //Gravy's action
			gravy.action(actionIndex);
			if(skeleDog.getHealth() > 0) {
			    skeleDog.setHealth((skeleDog.getHealth() - 25));
			}
			else {
				sword.setHealth((sword.getHealth() - 25));
			}
			action1 = false;

		}
		if(action2) { //Skele's actions
			skele.action(actionIndex2);
			if(skeleDog.getHealth() > 0) {
			    skeleDog.setHealth((skeleDog.getHealth() - 15));
			}
			else {
				sword.setHealth((sword.getHealth() - 25));
			}
			action2 = false;
		}
		if(action3) { //Bunj's actions
			bunj.action(actionIndex3);
			if(skeleDog.getHealth() > 0) {
			    skeleDog.setHealth((skeleDog.getHealth() - 15));
			}
			else {
				sword.setHealth((sword.getHealth() - 25));
			}
			action3 = false;
		}

		if(skele.getCurrentIndex() == 3) {//SkeleDog's actions
			if(gravy.getHealth() > 0) {
				skeleDog.attack();
				gravy.setHealth((gravy.getHealth() - 1));
			}
			else if(bunj.getHealth() > 0) {
				skeleDog.attack();
				bunj.setHealth((bunj.getHealth() - 1));
			}
			else if(skele.getHealth() > 0){
				skeleDog.attack();
				skele.setHealth((skele.getHealth() - 1));
			}

		}
		
		if(skeleDog.getHealth() <= 0) {
			g.drawImage(Assets.victory, 580, 80, 300, 200, null);
		}
		
		/*
		if(skeleDog.getHealth() == 0) {//For when skeleDog is dead so sword will still go after skele
			if(skele.getCurrentIndex() == 3) { //Sword's action.
			    sword.attack();
			    gravy.setHealth(gravy.getHealth() - 1);
			    skele.setHealth(skele.getHealth() - 1);
			    bunj.setHealth(bunj.getHealth() - 1);
			}
		}
		else if(skeleDog.getCurrentIndex() == 9) {//For when SkeleDog is alive so she will go after SkeleDog.
		    sword.attack();
		    gravy.setHealth(gravy.getHealth() - 1);
		    skele.setHealth(skele.getHealth() - 1);
		    bunj.setHealth(bunj.getHealth() - 1);
		}
       */
		//Render each button separately. I try.
		combatUI.render(g);
		skeleDog.render(g);
		skele.render(g);
		gravy.render(g);
		bunj.render(g);
		//sword.render(g);
	}

}
