package dev.pro.game.states;

import java.awt.Graphics;

import dev.pro.game.Game;


public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) { //change what state the game currently renders
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//class
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
