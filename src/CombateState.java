package dev.pro.game.states;

import java.awt.Graphics;

import dev.pro.game.Game;
import dev.pro.game.gfx.Animation;
import dev.pro.game.gfx.Assets;
import dev.pro.game.ui.ClickListener;
import dev.pro.game.ui.UIImageButton;
import dev.pro.game.ui.UIManager;

public class CombateState extends State{
	

	private Animation skele_tele_animation;
	int skeleX = 150;
	
	public CombateState(Game game) {
		super(game);
		
		
		skele_tele_animation = new Animation(500, Assets.skeleman_tele);
		
	}

	@Override
	public void tick() {
	
		
		skele_tele_animation.tick();
		
		if(skele_tele_animation.getIndex() == 2) {
			skeleX = 500;
		}
		if(skele_tele_animation.getIndex() == 0) {
			skeleX = 150;
		}

	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(skele_tele_animation.getCurrentFrame(), skeleX, 530, 150, 100, null);
	}

}
