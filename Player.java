import java.awt.*;

public class Player extends Creature{ //This will be the basis for the characters.

    private Game game;
    private boolean dysentery;
    private String name;

    public Player(Game game, float x, float y, String name) {
        super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
        this.game = game;
        dysentery = false;
        this.name = name;
    }

    public String getSick() {
        dysentery = true;
        return name + " has dysentery.";
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.skeleman_idle1, (int) x, (int) y, null);
    }
}
