
import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State{
	
	private UIManager uiManager;
	
	public MenuState(Game game) {
		super(game);
		uiManager = new UIManager(game);
		game.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(200, 200, 64, 64, new ClickListener() {

			@Override
			public void onClick() {
				game.getMouseManager().setUIManager(null);
				State.setState(game.gameState);
			}}));
	}

	@Override
	public void tick() {
		uiManager.tick();

	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
