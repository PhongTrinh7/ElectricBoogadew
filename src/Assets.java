import java.awt.image.BufferedImage;

public class Assets {

    private static final int W = 31, H = 31;
    public static BufferedImage skeleman_idle1, skeleman_idle2, skeleman_tele, skeleman_backstab, skeleman_portrait;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("textures/SkelemanSpriteSheet.png"));
        skeleman_idle1 = sheet.crop(0,0,W,H);
        skeleman_idle2 = sheet.crop(32,0,W,H);
        //skeleman_tele = sheet.crop(66,0,W,H);
        //skeleman_backstab = sheet.crop(0,32,W,H);
    }
}
