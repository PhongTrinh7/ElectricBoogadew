
public abstract class Creature implements GameObject { //Any living thing.

    public static final int DEFFAULT_HEALTH = 100;
    public static final int DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 64;
    protected int health;
    protected int width;
    protected int height;
    protected float x;
    protected float y;

    public Creature(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        health = DEFFAULT_HEALTH;
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

}
  
