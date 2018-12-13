
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Creature implements GameObject{

    //public static final int DEFAULT_HEALTH = 100;
    public static final int DEFAULT_WIDTH = 5, DEFAULT_HEIGHT = 5;
    protected int health;
    protected int width;
    protected int height;
    protected float x;
    protected float y;
    protected int potion; //The amount of potion the characters might pick up along the way.

    protected int animation_Index;
    protected ArrayList<Animation> animations;
    protected ArrayList<BufferedImage> projectiles;
    
    public Creature(float x, float y, int width, int height, int health, BufferedImage[] frames) {
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    	this.health = health;
    	potion = 0;
    	animations = new ArrayList<>();
    	animations.add(new Animation(500, frames));
    	projectiles = new ArrayList<>();
    }
    
    public void addAnimation(BufferedImage[] frames, int speed) {
    	animations.add(new Animation(speed, frames));
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

	public void tick() {
		animations.get(animation_Index).tick();
		if(animations.get(animation_Index).getIndex() == animations.get(animation_Index).getSize()-1) {
			animation_Index = 0;
		}
	}
    
	public void render(Graphics g) {
		if(health > 0) {	//Only renders when health is greater than zero.
		    g.drawImage(animations.get(animation_Index).getCurrentFrame(), (int) x, (int) y, animations.get(animation_Index).getCurrentFrame().getWidth()*width, animations.get(animation_Index).getCurrentFrame().getHeight()*height,null);
		}
		else {//Renders dead frame.
			g.drawImage(animations.get(2).getCurrentFrame(), (int) x, (int) y,animations.get(animation_Index).getCurrentFrame().getWidth()*width, animations.get(animation_Index).getCurrentFrame().getHeight()*height, null);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		return false;
	}
}
