package dev.pro.game.gameobjects.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.pro.game.gameobjects.GameObject;
import dev.pro.game.gfx.Animation;

public abstract class Creature implements GameObject{

    //public static final int DEFAULT_HEALTH = 100;
    public static final int DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 64;
    protected int health;
    protected int width;
    protected int height;
    protected float x;
    protected float y;
    //protected float projectileX;
    //protected float projectileY;
    protected int animation_Index;
    protected ArrayList<Animation> animations;
    protected ArrayList<BufferedImage> projectiles;
    
    public Creature(float x, float y, int width, int height, int health, BufferedImage[] frames) {
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    	this.health = health;
    	animations = new ArrayList<>();
    	animations.add(new Animation(500, frames));
    	projectiles = new ArrayList<>();
    	
    	//projectileX = x+30;
    	//projectileY = y+5;
    	
    }
    
    public void addAnimation(BufferedImage[] frames, int speed) {
    	animations.add(new Animation(speed, frames));
    }
    
    public void addProjectile(BufferedImage frame) {
    	projectiles.add(frame);
    }
    /*
    public boolean isHit() { //If the character gets hit.
    	if(projectileX == x) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    */

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
	/*
	public float getProjectileX() {
		return projectileX;
	}

	public void setProjectileX(float projectileX) {
		this.projectileX = projectileX;
	}

	public float getProjectileY() {
		return projectileY;
	}

	public void setProjectileY(float projectileY) {
		this.projectileY = projectileY;
	}
*/
	public void tick() {
		animations.get(animation_Index).tick();
		
		if(animations.get(animation_Index).getIndex() == animations.get(animation_Index).getSize()-1) {
			animation_Index = 0;
		}
		/*
		if(animation_Index == 1) { //Makes the projectile move when the attack animation starts.
			projectileX += 4;
		}
		if(animation_Index == 0) { //Resets the place of the projectile.
			projectileX = x;
		}
		*/
	}
    
	public void render(Graphics g) {
		g.drawImage(animations.get(animation_Index).getCurrentFrame(), (int) x, (int) y, null);
		/*
		if(animation_Index == 1) {
			g.drawImage(projectiles.get(0), (int) projectileX, (int) projectileY, null);
		}
		*/
		g.setColor(Color.GREEN);
		g.fillRect((int) x, (int) y-10, health, 5);
	}
	
	public int getCurrentIndex() {
		return animations.get(animation_Index).getIndex();
	}
}
