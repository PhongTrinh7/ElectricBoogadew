import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Creature{ //This will be the basis for the characters.

    private Game game;
    private boolean dysentery;
    private String name;

    private boolean action;
    private ArrayList<Animation> animations; // List of animations for this character.

    public Player(Game game, float x, float y, String name, BufferedImage[] frames) { // The constructor takes in the idle animation.
        super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
        this.game = game;
        dysentery = false;
        this.name = name;
        animations = new ArrayList<>();
        animations.add(new Animation(500, frames));

    }

    public void addAnimation(BufferedImage[] frames) { // Use this to add additional animations e.g. attacks or item use.
        animations.add(new Animation(10, frames));
    }

    public void getAnimation(int i) {
        animations.get(i);
    }

    public String getSick() {
        dysentery = true;
        health = health/2;
        return name + " has dysentery.";
    }

    public void action(Graphics g, int i) { // Use this to play a single non-repeating action.
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1000) {
            g.drawImage(animations.get(i).getAnimationFrame(), (int) x, (int) y, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
        }
        start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1000) {
            animations.get(i).setIndex(1);
            g.drawImage(animations.get(i).getAnimationFrame(), (int) x, (int) y, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
        }
    }

    @Override
    public void tick() { // Will tick the idling animation.
        animations.get(0).tick();
    }

    @Override
    public void render(Graphics g) { // Will play the idle animation.
        g.drawImage(animations.get(0).getAnimationFrame(), (int) x, (int) y, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    }
}
