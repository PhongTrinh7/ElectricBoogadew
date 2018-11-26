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
	
	private Player gravy, skele, bunj;
	private NPC skeleDog, sword;
	private boolean action1, action2, action3;
	private int actionIndex, actionIndex2, actionIndex3;
	
    private UIManager combatUI;

	
	public CombatState(Game game) {
		super(game);
		
		gravy = new Player(game, 180, 400, "Gravy", 50, Assets.gravy);
		gravy.addAnimation(Assets.gravy_action, 500);
		gravy.addProjectile(Assets.gravy_lightning);
		
		skele = new Player(game, 380, 400, "Skele", 50, Assets.skeleman);
		skele.addAnimation(Assets.skeleman_tele, 500);
		
		bunj = new Player(game, 280, 400, "Bunjamen", 50, Assets.bunj);
		bunj.addAnimation(Assets.bunj_smash, 500);
		
		skeleDog = new NPC(580, 400, 300, 200, 100, Assets.skeleDog);
		skeleDog.addAnimation(Assets.skeleDogAtk, 300);
		
        sword = new NPC(780, 400, 300, 200, 100, Assets.sword);
        sword.addAnimation(Assets.swordAtk, 500);
		
		action1 = false; //action for each character
		action2 = false;
		action3 = false;
	
		
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
                gravy.setHealth((gravy.getHealth() + 5));
			}}));
		
		combatUI.addObject(new UIImageButton(250, 450, 64, 32, Assets.potion_button, new ClickListener() { //Potion for Bunj.

			public void onClick() {
                bunj.setHealth((bunj.getHealth() + 5));
			}}));
		
		combatUI.addObject(new UIImageButton(350, 450, 64, 32, Assets.potion_button, new ClickListener() { //Potion for Skele.

			public void onClick() {
                skele.setHealth((skele.getHealth() + 5));
			}}));
    }
    

	@Override
	public void tick() {
		if(!action2) {
	        combatUI.tick();
		}
		skeleDog.tick();
		skele.tick();
		gravy.tick();
		bunj.tick();
		sword.tick();
		
	}

	@Override
	public void render(Graphics g) {
		if(action1) {
			gravy.action(actionIndex);
			skeleDog.setHealth((skeleDog.getHealth() - 25));
			action1 = false;

		}
		if(action2) {
			skele.action(actionIndex2);
			skeleDog.setHealth((skeleDog.getHealth() - 15));
			action2 = false;
		}
		if(action3) {
			bunj.action(actionIndex3);
			skeleDog.setHealth((skeleDog.getHealth() - 15));
			action3 = false;
		}
		if(skele.getCurrentIndex() == 3) {
			skeleDog.attack();
			sword.attack();
			gravy.setHealth(gravy.getHealth() - 1);
			skele.setHealth(skele.getHealth() - 1);
			bunj.setHealth(skele.getHealth() - 1);
		}
       
		combatUI.render(g);
		skeleDog.render(g);
		skele.render(g);
		gravy.render(g);
		bunj.render(g);
		sword.render(g);
	}

}
