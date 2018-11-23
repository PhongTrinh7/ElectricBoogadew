package dev.pro.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage  forestFore,forestMid, forestBack,  inn;
	public static BufferedImage[] cart, skeleman, skeleman_tele, gravy, gravy_action, gravy_lightning;
	public static BufferedImage dog;
	
	public static void init() { //Load in everything for our game.
		SpriteSheet skele = new SpriteSheet(ImageLoader.loadImage("/textures/SkelemanSpriteSheet.png"));
		SpriteSheet overWorld = new SpriteSheet(ImageLoader.loadImage("/textures/CartSpriteSheet.png"));
		SpriteSheet dogEvent = new SpriteSheet(ImageLoader.loadImage("/textures/DogEvent.png"));
		SpriteSheet gravySprite = new SpriteSheet(ImageLoader.loadImage("/textures/GravySpriteSheet.png"));
		cart = new BufferedImage[2];
		
		cart[0] = overWorld.crop(0, 0, 94, 64); 
		cart[1] = overWorld.crop(0, 64, 94, 64);
		
		skeleman = new BufferedImage[2];
		skeleman[0] = skele.crop(0, 0, width, height);
		skeleman[1] = skele.crop(32, 0, width, height);
		
		skeleman_tele = new BufferedImage[4];
		skeleman_tele[0] = skele.crop(0, 0, width, height);//buffer frame
		skeleman_tele[1] = skele.crop(64, 0, width, height);
		skeleman_tele[2] = skele.crop(0, 32, width, height);
		skeleman_tele[3] = skele.crop(0, 0, width, height); //buffer frame
		
		gravy = new BufferedImage[2];
		gravy[0] = gravySprite.crop(0, 0, width, height);
		gravy[1] = gravySprite.crop(32, 0, width, height);
		
		gravy_action = new BufferedImage[3];
		gravy_action[0] = gravySprite.crop(0, 0, width, height);
		gravy_action[1] = gravySprite.crop(64, 0, width, height);
		gravy_action[2] = gravySprite.crop(0, 0, width, height);
		
		
		gravy_lightning = new BufferedImage[1];
		gravy_lightning[0] = gravySprite.crop(0, 64, width, height);
		
		dog = dogEvent.crop(0, 0, 640, 360);

		
		SpriteSheet shops = new SpriteSheet(ImageLoader.loadImage("/textures/OverWorldStuffSpriteSheet.png"));
		inn = shops.crop(0, 0, 63, 63);
		
		forestFore = ImageLoader.loadImage("/textures/ForestForeGround.png");
		forestMid = ImageLoader.loadImage("/textures/ForestMidGround.png");
		forestBack = ImageLoader.loadImage("/textures/ForestBackGround.png");

	}

}
