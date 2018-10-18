import java.awt.*;

/* This state should be a vehicle of some sort(WIP)
 meandering languidly across an auto scroll or fixed background.
  */
public class GameState extends State{

    private Animation cart_Animation;

    public GameState(Game game) {
        super(game);
        cart_Animation = new Animation(500, Assets.cart);
    }
    int bgx = 0; // Background position.
    int cartx = 150; //Cart position.
    @Override
    public void tick() {
        if (bgx > -640) {
            cart_Animation.tick();
            bgx -= 1;
        }
        else {
            if (cartx < 1000) {
                cartx += 1;
                cart_Animation.tick();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.mountains,0,0,1280,720,null);
        g.drawImage(Assets.grassLand,bgx,0,1920,720,null);
        g.drawImage(Assets.inn, bgx + 1200, 350, 200, 200, null);
        g.drawImage(cart_Animation.getAnimationFrame(),cartx,500, 150,100,null);
    }
}
