package dev.pro.game.gameobjects.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.pro.game.Game;
import dev.pro.game.gfx.Animation;
import dev.pro.game.gfx.Assets;

public class NPC extends Creature{
	
	private Game game;
	private boolean lightning = false;
	
	private ArrayList<Animation> animations;

	public NPC(Game game, float x, float y, BufferedImage[] frames) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		this.game = game;
		
		animations = new ArrayList<>();
		animations.add(new Animation(500, frames));
		
	}
	
    public void addAnimation(BufferedImage[] frames) {
        animations.add(new Animation(500, frames));
    }
    
    public void getAnimation(int i) {
        animations.get(i);
    }

	@Override
	public void tick() {
		animations.get(0).tick();

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animations.get(0).getCurrentFrame(), (int) x, (int) y, width, height, null);
		if(lightning) {
			g.drawImage(Assets.gravy_lightning[0], 820, 420, null);
		}

	}
	
	//Make a method that checks if the current index from skele
	//is the last index of the action array and make an
	//if statement in render so it will draw the lightning.
	public void setLightning(boolean L) {
		lightning = L;
	}

}
