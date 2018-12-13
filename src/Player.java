
import java.awt.image.BufferedImage;

/**
 * This class is the player class and represents the user in the game.
 * It extends the creature class as a living creature but allows for
 * interactivity through actions.
 */

public class Player extends Creature{
	
	private boolean dysentary;
	private String name;
	private Game game;

	public Player(Game game, float x, float y, String name, int health, BufferedImage[] frames) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT, health, frames);
		dysentary = false;
		this.name = name;
		this.game = game;
	}

	/**
	 * Sets the animation to play according to what the user has input.
	 * @param i action to be played.
	 */

	public void action(int i) { // Use this to play a single non-repeating action.
		animation_Index = i;
	}
}
