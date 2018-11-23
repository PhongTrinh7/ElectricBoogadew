import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class NPC extends Creature{
	
	private ArrayList<Animation> animations;

	public NPC(float x, float y, BufferedImage[] frames) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT, frames);

		animation_Index = 0;
		animations = new ArrayList<>();
		animations.add(new Animation(500, frames));
	}
	
    public void addAnimation(BufferedImage[] frames) {
        animations.add(new Animation(500, frames));
    }

    public void attack() {
		animation_Index = 1;
	}
}
