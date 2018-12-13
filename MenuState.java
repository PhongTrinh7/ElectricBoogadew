
import java.awt.Color;
import java.awt.Graphics;

/**
 * This lcas displays the menu, this is where the user can start the game into the over world.
 * Wanted to implement options, such as loading, various display settings and what not.
 * Haven't done that that yet though.
 */

public class MenuState extends State{
	
	private UIManager uiManager;
	
	public MenuState(Game game) {
		super(game);
		uiManager = new UIManager(game);
		game.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(544, 528, 192, 192, Assets.start_button, new ClickListener() {

			@Override
			public void onClick() {
				game.getMouseManager().setUIManager(null);
				State.setState(game.gameState);
			}}));
	}

    /**
     * Listens for user interactions with the UI. In this case, just one start button for now.
     */
	@Override
	public void tick() {
		uiManager.tick();

	}

    /**
     * Displays the UI so the user can see what and where to click to do things.
     * @param g Graphics object to draw stuff.
     */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.cover, 0, 0, 1280, 720, null);
		uiManager.render(g);

	}

}
