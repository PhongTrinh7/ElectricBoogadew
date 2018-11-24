import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Creature implements GameObject { //Any living thing.

    public static final int DEFFAULT_HEALTH = 100;
    public static final int DEFAULT_WIDTH = 128, DEFAULT_HEIGHT = 128;
    protected int health = DEFFAULT_HEALTH;;
    protected int width = DEFAULT_WIDTH;
    protected int height = DEFAULT_HEIGHT;
    protected float x;
    protected float y;
    protected int animation_Index;

    protected ArrayList<Animation> animations; // List of animations for this creature.
    // 0 = Idle.
    // 1 = Attack.
    // 2 = WIP.
    // 3 = WIP.
    // etc.

    protected ArrayList<BufferedImage> projectiles;


    public Creature(float x, float y, int width, int height, BufferedImage[] frames) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        animations = new ArrayList<>();
        animations.add(new Animation(500, frames)); //Not sure if we can bring in frames like this
        projectiles = new ArrayList<>();
    }

    // Use this to add additional animations e.g. attacks or item use.
    // Added speed parameter to fine tune the animation speed. 500 should be default. Higher is slower.
    public void addAnimation(BufferedImage[] frames, int speed) {
        animations.add(new Animation(speed, frames));
    }

    public void addProjectile(BufferedImage frame) {
        projectiles.add(frame);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void tick() {
        animations.get(animation_Index).tick();

        if(animations.get(animation_Index).getIndex() == animations.get(animation_Index).getSize()-1) {
            animation_Index = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(animations.get(animation_Index).getCurrentFrame(), (int)x, (int)y, animations.get(animation_Index).getCurrentFrame().getWidth()*7, animations.get(animation_Index).getCurrentFrame().getHeight()*7, null);
    }

}
  
