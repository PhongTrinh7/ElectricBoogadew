import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class NPC extends Creature{

	public NPC(float x, float y, int width, int height,int health, BufferedImage[] frames) {
		super(x, y, width, height,health, frames);

		animation_Index = 0;
		animations = new ArrayList<>();
		animations.add(new Animation(500, frames));
	}

    public void attack() {
		animation_Index = 1;
	}
}
