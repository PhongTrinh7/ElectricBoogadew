import java.awt.image.BufferedImage;

public class Assets {

    private static final int W = 32, H = 32; //Default for players, maybe some monsters.
    public static BufferedImage forestBack, forestMid, forestFore, inn;
    public static BufferedImage[] cart, skeleman;

    public static void init() {
        SpriteSheet skele = new SpriteSheet(ImageLoader.loadImage("textures/SkelemanSpriteSheet.png"));
        skeleman = new BufferedImage[2];
        skeleman[0] = skele.crop(0,0, W, H);
        skeleman[1] = skele.crop(32,0, W, H);
        //skeleman[2] = skele.crop(64,0, W, H);
        //skeleman[3] = skele.crop(0,32, W, H);

        SpriteSheet overWorld = new SpriteSheet((ImageLoader.loadImage("textures/CartSpriteSheet.png")));
        cart = new BufferedImage[2]; //Cart animations.
        cart[0] = overWorld.crop(0,0,94,64);
        cart[1] = overWorld.crop(0,64,94,64);

        SpriteSheet shops = new SpriteSheet(ImageLoader.loadImage("textures/OverWorldStuffSpriteSheet.png"));
        inn = shops.crop(0,0, 63, 63);

        forestFore = ImageLoader.loadImage("textures/ForestForeGround.png");
        forestMid = ImageLoader.loadImage("textures/ForestMidGround.png");
        forestBack = ImageLoader.loadImage("textures/ForestBackGround.png");
    }
}
