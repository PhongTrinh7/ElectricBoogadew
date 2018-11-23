
import java.awt.Graphics;

public class CombatState extends State{
	
	private Player gravy;
	private NPC skele;
	private boolean action, enemy_Turn;
	private int actionIndex;
    private UIManager combatUI;
	
	public CombatState(Game game) {
		super(game);
		action = false;

		//Gravy assets.
		gravy = new Player(game, 480, 400, "Gravy", Assets.gravy);
		gravy.addAnimation(Assets.gravy_action);
		gravy.addProjectile(Assets.gravy_lightning);


		//Skele assets.
		skele = new NPC(780, 400, Assets.skeleman);
		skele.addAnimation(Assets.skeleman_tele);

		
		combatUI = new UIManager(game);
		game.getMouseManager().setUIManager(combatUI);
		// Attack button.
		combatUI.addObject(new UIImageButton(200, 400, 64, 64, new ClickListener() {
			
			public void onClick() {
				action = true;
				enemy_Turn = true;
				actionIndex = 1; //1 for attack.
			}}));
		//Something else button.
		combatUI.addObject(new UIImageButton(300, 400, 64, 64, new ClickListener() {

			public void onClick() {
				action = true;
				enemy_Turn = true;
				actionIndex = 2; //2 for something else i guess. So on and so forth if we want more buttons.
			}}));
    }

	@Override
	public void tick() {
		if (!enemy_Turn) {
			combatUI.tick();
		}

		gravy.tick();
		skele.tick();
	}

	@Override
	public void render(Graphics g) {
		if(action) {
			gravy.action(actionIndex);
			action = false;
		}
		if (enemy_Turn) {

		}
       
		//Make an if statement that compares the 
		//current frame of skele to see if they are done
		//with the attack animation.
		combatUI.render(g);
		skele.render(g);
		gravy.render(g);
	}

}
