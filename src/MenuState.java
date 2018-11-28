package dev.pro.game.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.pro.game.Game;
import dev.pro.game.gfx.Assets;
import dev.pro.game.ui.ClickListener;
import dev.pro.game.ui.UIImageButton;
import dev.pro.game.ui.UIManager;


public class MenuState extends State{
	
	private UIManager uiManager;
	
	public MenuState(Game game) {
		super(game);
		uiManager = new UIManager(game);
		game.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(200, 200, 64, 64, Assets.start_button, new ClickListener() {

			@Override
			public void onClick() {
				game.getMouseManager().setUIManager(null);
				game.combatState = new CombatState(game); //NEW Instantiates combat state here instead of Game.
				State.setState(game.gameState);
			}}));
	}

	@Override
	public void tick() {
		uiManager.tick();

	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);

	}

}
