package dev.pro.game.gameobjects.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.pro.game.Game;
import dev.pro.game.gfx.Animation;
import dev.pro.game.gfx.Assets;

public class Player extends Creature{
	
	private boolean dysentary;
	private String name;
	private Game game;
	

	private int animation_index = 0; //Index for the animation ArrayList.
	private ArrayList<Animation> animations; // List of animations for this character.

	public Player(Game game, float x, float y, String name, BufferedImage[] frames) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		dysentary = false;
		this.name = name;
		this.game = game;

	    animations = new ArrayList<>();
	    animations.add(new Animation(500, frames));
	}

    public void addAnimation(BufferedImage[] frames) { // Use this to add additional animations e.g. attacks or item use.
        animations.add(new Animation(500, frames));
    }

    public void getAnimation(int i) {
        animations.get(i);
    }

    public String getSick() {
        dysentary = true;
        health = health/2;
        return name + " has dysentery.";
    }
    


    public void action(int i) { // Use this to play a single non-repeating action.

    	animation_index = i;

    }

	@Override
	public void tick() {
        animations.get(animation_index).tick();

    	if(animations.get(1).getIndex() == 3) {
    		animation_index = 0;
    	}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animations.get(animation_index).getCurrentFrame(), (int)x, (int)y, width, height, null);

	}
	
	//Make a getCurrentIndex method in this class
	public int getCurrentIndex() {
		return animations.get(animation_index).getIndex();
	}
}
