
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage  combatBack, forestFore,forestMid, forestBack,  inn, gravy_lightning, dog, victory, dog_oil, dog_demon, egg;
	public static BufferedImage[] cart, skeleman, skeleman_tele, gravy, gravy_action, skele_hit, bunj, bunj_smash, sword;
	public static BufferedImage[] gravy_dead, bunj_dead, skele_dead, skeleDog_dead, sword_dead;
	public static BufferedImage[] skeleDog, skeleDogAtk, swordAtk;
	public static BufferedImage[] bunj_button, gravy_button, skele_button, start_button, potion_button;
	public static void init() { //Load in everything for our game.
		
		SpriteSheet skele = new SpriteSheet(ImageLoader.loadImage("/textures/SkelemanSprSht.png"));
		SpriteSheet overWorld = new SpriteSheet(ImageLoader.loadImage("/textures/CartSpriteSheet.png"));
		SpriteSheet dogEvent = new SpriteSheet(ImageLoader.loadImage("/textures/DogEvent.png"));
		SpriteSheet gravySprite = new SpriteSheet(ImageLoader.loadImage("/textures/GravySpriteSheet.png"));
		SpriteSheet gravySprite1 = new SpriteSheet(ImageLoader.loadImage("/textures/GravySprSht1.png"));
		SpriteSheet gravySprite2 = new SpriteSheet(ImageLoader.loadImage("/textures/GravySprSht2.png"));
		SpriteSheet bunjSprSht = new SpriteSheet(ImageLoader.loadImage("/textures/BunjSprSht.png"));
		SpriteSheet skeleDogSheet = new SpriteSheet(ImageLoader.loadImage("/textures/SkeleDogSprSht.png"));
		SpriteSheet swordSprSht = new SpriteSheet(ImageLoader.loadImage("/textures/SwordBitSprSht.png"));
		SpriteSheet buttonSprt = new SpriteSheet(ImageLoader.loadImage("/textures/ButtonsSprSht.png"));
		SpriteSheet WRequest = new SpriteSheet(ImageLoader.loadImage("/textures/WesleyRequests.png"));
		SpriteSheet dogOil = new SpriteSheet(ImageLoader.loadImage("/textures/Dog_Event_Oil.png"));
		SpriteSheet dogDemon = new SpriteSheet(ImageLoader.loadImage("/textures/Dog_Event_Play.png"));
		SpriteSheet eggEvent = new SpriteSheet(ImageLoader.loadImage("/textures/Event_Egg_Main.png"));
		
		//Victory Banner
		victory = WRequest.crop(0, 0, width*3, height);
		
		//Cart
		cart = new BufferedImage[2];
		cart[0] = overWorld.crop(0, 0, 94, 64); 
		cart[1] = overWorld.crop(0, 64, 94, 64);

		//Start button
		start_button = new BufferedImage[2];
		start_button[0] = buttonSprt.crop(0, 64, width, height);
		start_button[1] = buttonSprt.crop(32, 64, width, height);
		
		//Potions
		potion_button = new BufferedImage[2];
		potion_button[0] = buttonSprt.crop(64, 64, width, height/2);
		potion_button[1] = buttonSprt.crop(64, 80, width, height/2);
		
		
		//Skeleman
		skeleman = new BufferedImage[2];
		skeleman[0] = skele.crop(0, 0, width*3, height);
		skeleman[1] = skele.crop(0, 32, width*3, height);
		
		skeleman_tele = new BufferedImage[6];
		skeleman_tele[0] = skele.crop(0, 64, width*4, height);
		skeleman_tele[1] = skele.crop(0, 64, width*4, height);
		skeleman_tele[2] = skele.crop(0, 96, width*4, height);
		skeleman_tele[3] = skele.crop(0, 128, width*4, height); //buffer frame
		skeleman_tele[4] = skele.crop(0, 160, width*4, height);//Buffer frame for the enemy attack assuming skele is the last to go.
		skeleman_tele[5] = skele.crop(0, 160, width*4, height);

		skele_hit = new BufferedImage[3];
		skele_hit[0] = skele.crop(0, 0, width, height);
		skele_hit[1] = skele.crop(32, 64, width, height);
		skele_hit[2] = skele.crop(0, 0, width, height);
		
		skele_button = new BufferedImage[2];
		skele_button[0] = buttonSprt.crop(64, 0, width, height);
		skele_button[1] = buttonSprt.crop(64, 32, width, height);
		
		skele_dead = new BufferedImage[1];
		skele_dead[0] = skele.crop(64, 32, width, height);
		
		//Gravy
		gravy = new BufferedImage[2]; //Idle
		gravy[0] = gravySprite.crop(0, 0, width, height);
		gravy[1] = gravySprite.crop(32, 0, width, height);
		
		gravy_action = new BufferedImage[11];
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
		gravy_action[10] = gravySprite1.crop(0, 64, width*3, height);
		
	    gravy_lightning = gravySprite.crop(0, 64, width, height);
	    
	    gravy_dead = new BufferedImage[1];
	    gravy_dead[0] = gravySprite.crop(64, 32, width, height); 
	    
	    gravy_button = new BufferedImage[2];
	    gravy_button[0] = buttonSprt.crop(32, 0, width, height);
	    gravy_button[1] = buttonSprt.crop(32, 32, width, height);
	    
	    //Bunj
	    bunj = new BufferedImage[2];
		bunj[0] = bunjSprSht.crop(0,0, width*3, height);
		bunj[1] = bunjSprSht.crop(0,32, width*3, height);
		
		bunj_smash = new BufferedImage[10];
		bunj_smash[0] = bunjSprSht.crop(0,64, width*3, height);
		bunj_smash[1] = bunjSprSht.crop(0,64, width*3, height);
		bunj_smash[2] = bunjSprSht.crop(0,64, width*3, height);
		bunj_smash[3] = bunjSprSht.crop(0,96, width*3, height);
		bunj_smash[4] = bunjSprSht.crop(0,160, width*3, height);
		bunj_smash[5] = bunjSprSht.crop(0,160, width*3, height);
		bunj_smash[6] = bunjSprSht.crop(0,128, width*3, height);
		bunj_smash[7] = bunjSprSht.crop(0,128, width*3, height);
		bunj_smash[8] = bunjSprSht.crop(0,160, width*3, height);
		bunj_smash[9] = bunjSprSht.crop(0,160, width*3, height);
		
		bunj_button = new BufferedImage[2];
		bunj_button[0] = buttonSprt.crop(0, 0, width, height);
		bunj_button[1] = buttonSprt.crop(0, 32, width, height);
		
		bunj_dead = new BufferedImage[1];
		bunj_dead[0] = WRequest.crop(0, 32, width*3, height);
		
		//sword
		sword = new BufferedImage[2];
		sword[0] = swordSprSht.crop(0, 0, width*3, height);
		sword[1] = swordSprSht.crop(0, 32, width*3, height);

		swordAtk = new BufferedImage[8];
		swordAtk[0] = swordSprSht.crop(0, 64, width*3, height);
		swordAtk[1] = swordSprSht.crop(0, 96, width*3, height);
		swordAtk[2] = swordSprSht.crop(0, 128, width*3, height);
		swordAtk[3] = swordSprSht.crop(0, 96, width*3, height);
		swordAtk[4] = swordSprSht.crop(0, 128, width*3, height);
		swordAtk[5] = swordSprSht.crop(0, 96, width*3, height);
		swordAtk[6] = swordSprSht.crop(0, 128, width*3, height);
		swordAtk[7] = swordSprSht.crop(0, 0, width*3, height);
		
		sword_dead = new BufferedImage[1];
		sword_dead[0] = swordSprSht.crop(0, 160, width*3, height);
   
		//Event
		dog = dogEvent.crop(0, 0, 640, 360);
		dog_oil = dogOil.crop(0, 0, 640, 360); 
		dog_demon = dogDemon.crop(0, 0, 640, 360);
		egg = eggEvent.crop(0, 0, 640, 360);
		
		//SkeleDog
		skeleDog = new BufferedImage[2];
		skeleDog[0] = skeleDogSheet.crop(0, 0, width*3, height);
		skeleDog[1] = skeleDogSheet.crop(0, 32, width*3, height);

		skeleDogAtk = new BufferedImage[11];
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
		skeleDogAtk[10] = skeleDogSheet.crop(0, 64, width*3, height);//Buffer frame for second enemy attack.
		
		skeleDog_dead = new BufferedImage[1];
		skeleDog_dead[0] = WRequest.crop(0, 64, width*3, height);

		//Overworld
		SpriteSheet shops = new SpriteSheet(ImageLoader.loadImage("/textures/OverWorldStuffSpriteSheet.png"));
		inn = shops.crop(0, 0, 63, 63);
		
		forestFore = ImageLoader.loadImage("/textures/ForestForeGround.png");
		forestMid = ImageLoader.loadImage("/textures/ForestMidGround.png");
		forestBack = ImageLoader.loadImage("/textures/ForestBackGround.png");

		combatBack = ImageLoader.loadImage("/textures/CombatBackGround.png");

	}

}
