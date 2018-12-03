
import java.awt.Color;
import java.awt.Graphics;

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
				game.combatState = new CombatState(game); //NEW Instantiates combat state here instead of Game.
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
