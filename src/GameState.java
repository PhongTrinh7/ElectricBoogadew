import java.awt.*;

/* This state should be a vehicle of some sort(WIP)
 meandering languidly across an auto scroll or fixed background.
  */
public class GameState extends State{

    private boolean event;
    private UIManager gameUI;
    private Event dogEvent;

    private Animation cart_Animation;

    public GameState(Game game) {
        super(game);
        cart_Animation = new Animation(470, Assets.cart);

        gameUI = new UIManager(game);
        game.getMouseManager().setUIManager(gameUI);

        event = false;

        dogEvent = new Event(Assets.dog);
    }

    int fgx = 0; // Foreground position.
    int mgx = 0;
    int cartx = 150; //Cart position.

    @Override
    public void tick() {

        if (!event) {
            if (fgx == -200) {
                event = true;
                //setState(new CombatState(game));
            }
            if (mgx > -1160) {
                mgx -= 1;
            }
            if (fgx > -2320) {
                cart_Animation.tick();
                fgx -= 2;
            } else {
                if (cartx < 900) {
                    cartx += 1;
                    cart_Animation.tick();
                }
            }
        }
        else {
            gameUI.tick();
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.forestBack,0,0,1280,720,null);
        g.drawImage(Assets.forestMid, mgx, 0, 2800, 720, null);
        g.drawImage(Assets.forestFore, fgx,0,3600,720,null);
        g.drawImage(Assets.inn, fgx + 3350, 435, 200, 200, null);
        g.drawImage(cart_Animation.getCurrentFrame(),cartx,530, 150,100,null);
        if (event) {
            dogEvent.render(g);
            event();
            gameUI.render(g);
        }
    }

    private void event() {
        gameUI.addObject(new UIImageButton(200, 200, 64, 64, new ClickListener() {
            public void onClick() {
                event = false;
            }}));

    }
}
