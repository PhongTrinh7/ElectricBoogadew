
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage  forestFore, forestMid, forestBack, inn, dog, gravy_lightning;
	public static BufferedImage[] cart, skeleman, skeleman_tele, gravy, gravy_action;
	
	public static void init() { //Load in everything for our game.
		SpriteSheet skele = new SpriteSheet(ImageLoader.loadImage("/textures/SkelemanSpriteSheet.png"));
		SpriteSheet overWorld = new SpriteSheet(ImageLoader.loadImage("/textures/CartSpriteSheet.png"));
		SpriteSheet dogEvent = new SpriteSheet(ImageLoader.loadImage("/textures/DogEvent.png"));
		SpriteSheet gravySprite = new SpriteSheet(ImageLoader.loadImage("/textures/GravySpriteSheet.png"));


		//Cart Stuff.
		cart = new BufferedImage[2];
		
		cart[0] = overWorld.crop(0, 0, 94, 64); 
		cart[1] = overWorld.crop(0, 64, 94, 64);


		//Skeleman Stuff.
		skeleman = new BufferedImage[2]; //Idle.
		skeleman[0] = skele.crop(0, 0, width, height);
		skeleman[1] = skele.crop(32, 0, width, height);
		
		skeleman_tele = new BufferedImage[4];
		skeleman_tele[0] = skele.crop(0, 0, width, height);//buffer frame
		skeleman_tele[1] = skele.crop(64, 0, width, height);
		skeleman_tele[2] = skele.crop(0, 32, width, height);
		skeleman_tele[3] = skele.crop(0, 0, width, height); //buffer frame



		//Gravy Stuff.
		gravy = new BufferedImage[2]; //Idle.
		gravy[0] = gravySprite.crop(0, 0, width, height);
		gravy[1] = gravySprite.crop(32, 0, width, height);
		
		gravy_action = new BufferedImage[6];
		gravy_action[0] = gravySprite.crop(32, 0, width, height);
		gravy_action[1] = gravySprite.crop(0, 0, width, height);
		gravy_action[2] = gravySprite.crop(0, 32, width, height);
		gravy_action[3] = gravySprite.crop(0, 32, width, height);
		gravy_action[4] = gravySprite.crop(64, 0, width, height);
		gravy_action[5] = gravySprite.crop(64, 0, width, height);
		
		
		gravy_lightning = gravySprite.crop(0, 64, width, height);



		//Events
		dog = dogEvent.crop(0, 0, 640, 360);




		//Over world objects. Use these to mark event triggers i guess.
		SpriteSheet shops = new SpriteSheet(ImageLoader.loadImage("/textures/OverWorldStuffSpriteSheet.png"));
		inn = shops.crop(0, 0, 63, 63);



		//Background.
		forestFore = ImageLoader.loadImage("/textures/ForestForeGround.png");
		forestMid = ImageLoader.loadImage("/textures/ForestMidGround.png");
		forestBack = ImageLoader.loadImage("/textures/ForestBackGround.png");

	}

}
