
import java.awt.Graphics;

public class CombatState extends State{
	
	private Player gravy, bunj;
	private NPC skeleDog;
	private NPC sword;
	private boolean action, enemy_Turn;
	private int actionIndex;
    private UIManager combatUI;
	
	public CombatState(Game game) {
		super(game);
		action = false;

		//Gravy assets.
		gravy = new Player(game, 380, 400, "Gravy", Assets.gravy);
		gravy.addAnimation(Assets.gravy_action, 500);
		gravy.addProjectile(Assets.gravy_lightning);

		//Bunj assets.
		bunj = new Player(game, 250, 200, "Bunj", Assets.bunj);
		bunj.addAnimation(Assets.bunj_smash, 500);

		//SkeleDog assets.
		skeleDog = new NPC(480, 380, 300, 200, Assets.skeleDog);
		skeleDog.addAnimation(Assets.skeleDogAtk, 300);

		//Sword assets.
		sword = new NPC(520, 360, 300, 200, Assets.sword);
		sword.addAnimation(Assets.swordAtk, 500);

		
		combatUI = new UIManager(game);
		game.getMouseManager().setUIManager(combatUI);
		// Attack button.
		combatUI.addObject(new UIImageButton(200, 400, 64, 64, new ClickListener() {
			
			public void onClick() {
				action = true;
				//enemy_Turn = true;
				actionIndex = 1; //1 for attack.
			}}));
		//Something else button.
		combatUI.addObject(new UIImageButton(300, 400, 64, 64, new ClickListener() {

			public void onClick() {
				//action = true;
				enemy_Turn = true;
				actionIndex = 2; //2 for something else i guess. So on and so forth if we want more buttons.
			}}));
    }

	@Override
	public void tick() {
		if (!enemy_Turn) {
			combatUI.tick();
		}

		bunj.tick();
		sword.tick();
		gravy.tick();
		skeleDog.tick();
	}

	@Override
	public void render(Graphics g) {
		if(action) {
			gravy.action(actionIndex);
			action = false;
		}
		if (enemy_Turn) {
			//skeleDog.attack();
			//sword.attack();
			bunj.action(1);
			enemy_Turn = false;
		}
		combatUI.render(g);
		bunj.render(g);
		skeleDog.render(g);
		sword.render(g);
		gravy.render(g);
	}

}
