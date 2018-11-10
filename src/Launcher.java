package dev.pro.game;

import dev.pro.game.display.Display;

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("Title Game", 1280, 720);
		game.start();
	}

}
