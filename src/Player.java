
import java.awt.image.BufferedImage;

public class Player extends Creature{
	
	private boolean dysentary;
	private String name;
	private Game game;

	public Player(Game game, float x, float y, String name, BufferedImage[] frames) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT, frames);
		dysentary = false;
		this.name = name;
		this.game = game;
	}

    public String getSick() {
        dysentary = true;
        health = health/2;
        return name + " has dysentery.";
    }

	public void action(int i) { // Use this to play a single non-repeating action.
		animation_Index = i;
	}
}
