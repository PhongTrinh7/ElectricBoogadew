
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage  forestFore, forestMid, forestBack, inn, dog, gravy_lightning;
	public static BufferedImage[] cart;
	public static BufferedImage[] skeleman, skeleman_tele, gravy, gravy_action;
	public static BufferedImage[] skeleDog, skeleDogAtk;
	public static BufferedImage[] sword, swordAtk;
	
	public static void init() { //Load in everything for our game.
		//Skeleman Stuff.
		SpriteSheet skele = new SpriteSheet(ImageLoader.loadImage("/textures/SkelemanSpriteSheet.png"));
		skeleman = new BufferedImage[2]; //Idle.
		skeleman[0] = skele.crop(0, 0, width, height);
		skeleman[1] = skele.crop(32, 0, width, height);
		
		skeleman_tele = new BufferedImage[4];
		skeleman_tele[0] = skele.crop(0, 0, width, height);//buffer frame
		skeleman_tele[1] = skele.crop(64, 0, width, height);
		skeleman_tele[2] = skele.crop(0, 32, width, height);
		skeleman_tele[3] = skele.crop(0, 0, width, height); //buffer frame



		//Gravy Stuff.
		SpriteSheet gravySprite = new SpriteSheet(ImageLoader.loadImage("/textures/GravySpriteSheet.png"));
		SpriteSheet gravySprite1 = new SpriteSheet(ImageLoader.loadImage("/textures/GravySprSht1.png"));
		SpriteSheet gravySprite2 = new SpriteSheet(ImageLoader.loadImage("/textures/GravySprSht2.png"));
		gravy = new BufferedImage[2]; //Idle.
		gravy[0] = gravySprite1.crop(0, 0, width, height);
		gravy[1] = gravySprite1.crop(0, 32, width, height);
		
		gravy_action = new BufferedImage[10];
		gravy_action[0] = gravySprite1.crop(0, 64, width*3, height);
		gravy_action[1] = gravySprite1.crop(0, 64, width*3, height);
		gravy_action[2] = gravySprite2.crop(0, 0, width*3, height);
		gravy_action[3] = gravySprite2.crop(0, 32, width*3, height);
		gravy_action[4] = gravySprite2.crop(0, 64, width*3, height);
		gravy_action[5] = gravySprite2.crop(0, 96, width*3, height);
		gravy_action[6] = gravySprite2.crop(0, 128, width*3, height);
		gravy_action[7] = gravySprite2.crop(0, 96, width*3, height);
		gravy_action[8] = gravySprite2.crop(0, 128, width*3, height);
		gravy_action[9] = gravySprite2.crop(0, 96, width*3, height);
		
		
		gravy_lightning = gravySprite.crop(0, 64, width, height);



		//EVENTS.

		//Dog.
		SpriteSheet dogEvent = new SpriteSheet(ImageLoader.loadImage("/textures/DogEvent.png"));
		SpriteSheet skeleDogSheet = new SpriteSheet(ImageLoader.loadImage("/textures/SkeleDogSprSht.png"));
		dog = dogEvent.crop(0, 0, 640, 360);
		skeleDog = new BufferedImage[2];
		skeleDog[0] = skeleDogSheet.crop(0, 0, width*3, height);
		skeleDog[1] = skeleDogSheet.crop(0, 32, width*3, height);

		skeleDogAtk = new BufferedImage[10];
		skeleDogAtk[0] = skeleDogSheet.crop(0, 64, width*3, height);
		skeleDogAtk[1] = skeleDogSheet.crop(0, 64, width*3, height);
		skeleDogAtk[2] = skeleDogSheet.crop(0, 96, width*3, height);
		skeleDogAtk[3] = skeleDogSheet.crop(0, 64, width*3, height);
		skeleDogAtk[4] = skeleDogSheet.crop(0, 96, width*3, height);
		skeleDogAtk[5] = skeleDogSheet.crop(0, 64, width*3, height);
		skeleDogAtk[6] = skeleDogSheet.crop(0, 96, width*3, height);
		skeleDogAtk[7] = skeleDogSheet.crop(0, 64, width*3, height);
		skeleDogAtk[8] = skeleDogSheet.crop(0, 96, width*3, height);
		skeleDogAtk[9] = skeleDogSheet.crop(0, 64, width*3, height);

		//Sword
		SpriteSheet swordSprSht = new SpriteSheet(ImageLoader.loadImage("/textures/SwordBitSprSht.png"));
		sword = new BufferedImage[2];
		sword[0] = swordSprSht.crop(0, 0, width*3, height);
		sword[1] = swordSprSht.crop(0, 32, width*3, height);

		swordAtk = new BufferedImage[7];
		swordAtk[0] = swordSprSht.crop(0, 64, width*3, height);
		swordAtk[1] = swordSprSht.crop(0, 96, width*3, height);
		swordAtk[2] = swordSprSht.crop(0, 128, width*3, height);
		swordAtk[3] = swordSprSht.crop(0, 96, width*3, height);
		swordAtk[4] = swordSprSht.crop(0, 128, width*3, height);
		swordAtk[5] = swordSprSht.crop(0, 96, width*3, height);
		swordAtk[6] = swordSprSht.crop(0, 128, width*3, height);

		//Over world objects. Use these to mark event triggers i guess.
		SpriteSheet overWorld = new SpriteSheet(ImageLoader.loadImage("/textures/CartSpriteSheet.png"));
		//Cart Stuff.
		cart = new BufferedImage[2];

		cart[0] = overWorld.crop(0, 0, 94, 64);
		cart[1] = overWorld.crop(0, 64, 94, 64);

		SpriteSheet shops = new SpriteSheet(ImageLoader.loadImage("/textures/OverWorldStuffSpriteSheet.png"));
		inn = shops.crop(0, 0, 63, 63);



		//Background.
		forestFore = ImageLoader.loadImage("/textures/ForestForeGround.png");
		forestMid = ImageLoader.loadImage("/textures/ForestMidGround.png");
		forestBack = ImageLoader.loadImage("/textures/ForestBackGround.png");

	}

}
