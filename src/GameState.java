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
    int fgx = 0; // Foreground position.
    int mgx = 0;
    int cartx = 150; //Cart position.
    @Override
    public void tick() {
        if (fgx == -200) {
            setState(new CombatState(game));
        }
        if (mgx > -800) {
            mgx -= 1;
        }
        if (fgx > -1600) {
            cart_Animation.tick();
            fgx -= 2;
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
        g.drawImage(Assets.forestBack,0,0,1280,720,null);
        g.drawImage(Assets.forestMid, mgx, 0, 2160, 720, null);
        g.drawImage(Assets.forestFore, fgx,0,2880,720,null);
        g.drawImage(Assets.inn, fgx + 2700, 435, 200, 200, null);
        g.drawImage(cart_Animation.getAnimationFrame(),cartx,530, 150,100,null);
    }
}
