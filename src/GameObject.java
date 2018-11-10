package dev.pro.game.gameobjects;

import java.awt.Graphics;

public interface GameObject {
	
	void tick();
	
	void render(Graphics g);

}
