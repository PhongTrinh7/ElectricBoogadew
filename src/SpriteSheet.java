import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage s) {
        sheet = s;
    }

    // This method crops a rectangle from the sprite sheet passed in as argument then returns the image cut out from the sprite sheet.
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
