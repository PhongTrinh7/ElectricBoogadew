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
	
	//private Animation skeleman_idle, skeleman_tele_attack;
	
	//private boolean action = false;
	private int animation_index = 0; //Index for the animation ArrayList.
	private ArrayList<Animation> animations; // List of animations for this character.

	public Player(Game game, float x, float y, String name, BufferedImage[] frames) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		dysentary = false;
		this.name = name;
		this.game = game;
		//skeleman_idle = new Animation(500, Assets.skeleman);
		//skeleman_tele_attack = new Animation(500, Assets.skeleman_tele);
	    animations = new ArrayList<>();
	    animations.add(new Animation(500, frames)); //Not sure if we can bring in frames like this
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
    
   // public void setAction(boolean a) {
    	//action = a;
   // }

    public void action(int i) { // Use this to play a single non-repeating action.
        //NOTE: Player skele has two idle frames added in during instantiation
    	//Afterwards, 3 more frames are added to the animation array.
    	//This method is called and the i = 1.
    	//It seems to be stuck in the first while loop.
    	/*
    	long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1000) {
            g.drawImage(animations.get(i).getCurrentFrame(), (int) x, (int) y, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
        }
        */
        //1st try:Maybe try changing the setIndex to 2 instead
        //because 1 is the second idle animation.
        
        //1st try didnt work but did make the attack frame show up 
        //for a second.
        
        //Find a way to make the frame stay longer.
        //The teleportation frame seems to be gone or going even faster
    	/*
        start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1000) {
            animations.get(i).setIndex(2);
            g.drawImage(animations.get(i).getCurrentFrame(), (int) x, (int) y, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
        }
        */
    	animation_index = i;

    }

	@Override
	public void tick() {
        animations.get(animation_index).tick();
        /*
		skeleman_idle.tick();
		
		if(action) {
			skeleman_tele_attack.tick();
			action = false;
		}
		*/
    	if(animations.get(animation_index).getIndex() == 3) {
    		animation_index = 0;
    	}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animations.get(animation_index).getCurrentFrame(), (int)x, (int)y, width, height, null);
		//g.drawImage(skeleman_idle.getCurrentFrame(), (int) x, (int) y, width, height, null);
		
		//g.drawImage(skeleman_tele_attack.getCurrentFrame(), (int) x, (int) y, width, height, null);
	   
	}
}
