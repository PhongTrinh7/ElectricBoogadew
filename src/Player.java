import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{ //This will be the basis for the characters.

    private Game game;
    private boolean dysentery;
    private String name;
    private Animation animation;

    public Player(Game game, float x, float y, String name, BufferedImage[] f) {
        super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
        this.game = game;
        dysentery = false;
        this.name = name;
        animation = new Animation(500, f);
    }

    public String getSick() {
        dysentery = true;
        health = health/2;
        return name + " has dysentery.";
    }
    @Override
    public void tick() {
        animation.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(animation.getAnimationFrame(), (int) x, (int) y, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    }
}
