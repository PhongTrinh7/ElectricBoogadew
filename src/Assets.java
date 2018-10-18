import java.awt.image.BufferedImage;

public class Assets {

    private static final int W = 31, H = 31;
    public static BufferedImage skeleman_idle1, skeleman_idle2, skele_tele, skeleman_backstab, skeleman_portrait,
            mountains, grassLand, inn;
    public static BufferedImage[] cart;

    public static void init() {
        SpriteSheet skele = new SpriteSheet(ImageLoader.loadImage("textures/SkelemanSpriteSheet.png"));
        skeleman_idle1 = skele.crop(0,0,W,H);
        skeleman_idle2 = skele.crop(32,0,W,H);
        skele_tele = skele.crop(65,0,W,H);
        skeleman_backstab = skele.crop(0,32,W,H);

        SpriteSheet overWorld = new SpriteSheet((ImageLoader.loadImage("textures/CartSpriteSheet.png")));
        cart = new BufferedImage[2]; //Cart animations.
        cart[0] = overWorld.crop(0,0,94,64);
        cart[1] = overWorld.crop(0,64,94,64);

        SpriteSheet shops = new SpriteSheet(ImageLoader.loadImage("textures/OverWorldStuffSpriteSheet.png"));
        inn = shops.crop(0,0, 63, 63);

        grassLand = ImageLoader.loadImage("textures/GrassLandsMidGround2.png");
        mountains = ImageLoader.loadImage("textures/MountainBackdrop.png");
    }
}
