package dev.pro.game.gameobjects.creatures;

import java.awt.Graphics;

import dev.pro.game.Game;
import dev.pro.game.gfx.Assets;

public class Player extends Creature{
	
	private boolean dysentary;
	private String name;
	private Game game;

	public Player(Game game, float x, float y, String name) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		dysentary = false;
		this.name = name;
		this.game = game;
	}



	@Override
	public void tick() {
		if(game.getKeyManager().up) {
			y -= 3;
		}
		if(game.getKeyManager().down) {
			y += 3;
		}
		if(game.getKeyManager().left) {
			x -= 3;
		}
		if(game.getKeyManager().right) {
			x += 3;
		}
		
	}

	@Override
	public void render(Graphics g) {
		//g.drawImage(Assets.skeleman_idle1, (int)x, (int)y, width, height, null);
		
	}
}
