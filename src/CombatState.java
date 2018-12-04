
import java.awt.*;

public class CombatState extends State{
	
	private NPC enemy;
	private boolean action1, action2, action3, enemyTurn;
	private int actionIndex, actionIndex2, actionIndex3;
	private int potionCount;
	
    private UIManager combatUI;

	
	public CombatState(Game game, NPC enemy) {
		super(game);

		this.enemy = enemy;

		action1 = false; //action for each character
		action2 = false;
		action3 = false;
	
		potionCount = 3;
		
		combatUI = new UIManager(game);
		game.getMouseManager().setUIManager(combatUI);
		
		combatUI.addObject(new UIImageButton(140, 104, 129, 96, Assets.gravy_button, new ClickListener() { //Button for the first Player.
			
			public void onClick() {
				if (!enemyTurn && !action2 && !action3) {
					action1 = true;
					actionIndex = 1;
				}
			}}));

		combatUI.addObject(new UIImageButton(140, 304, 128, 96, Assets.skele_button, new ClickListener() { //Button for the third Player.

			public void onClick() {
				if (!enemyTurn && !action1 && !action3) {
					action2 = true;
					actionIndex2 = 1;
				}
			}}));

		combatUI.addObject(new UIImageButton(140, 204, 128, 96, Assets.bunj_button, new ClickListener() { //Button for the second Player.

			public void onClick() {
				if (!enemyTurn && !action1 && !action2) {
					action3 = true;
					actionIndex3 = 1;
				}
			}}));
			
		
		//Potion Buttons
		combatUI.addObject(new UIImageButton(128, 400, 128, 64, Assets.potion_button, new ClickListener() { //Potion for Gravy.

			public void onClick() {
				if(potionCount != 0) {
					game.gravy.setHealth((game.gravy.getHealth() + 10));
					game.bunj.setHealth((game.bunj.getHealth() + 10));
					game.skele.setHealth((game.skele.getHealth() + 10));
					potionCount -= 1;
				}
			}}));
    }

	@Override
	public void tick() {
		if(enemy.getHealth() <= 0) { //No death animation so it just switches.
			if(game.getKeyManager().enter) {
				game.getMouseManager().setUIManager(null);
				State.setState(game.gameState);
			}
		}
		enemy.tick();
		game.skele.tick();
		game.gravy.tick();
		game.bunj.tick();
		combatUI.tick();
		if (!enemyTurn && enemy.health > 0) {
			if (action1) { //Gravy's action
				game.gravy.action(actionIndex);

				if (game.gravy.animations.get(1).getIndex() == game.gravy.animations.get(1).getSize()-1) {
					enemy.setHealth((enemy.getHealth() - 15));
					action1 = false;
					enemyTurn = true;
				}
			}
			if (action2) { //Skele's actions
				game.skele.action(actionIndex2);

				if (game.skele.animations.get(1).getIndex() == game.skele.animations.get(1).getSize()-1) {
					enemy.setHealth((enemy.getHealth() - 15));
					action2 = false;
					enemyTurn = true;
				}
			}
			if (action3) { //Bunj's actions
				game.bunj.action(actionIndex3);

				if (game.bunj.animations.get(1).getIndex() == game.bunj.animations.get(1).getSize()-1) {
					enemy.setHealth((enemy.getHealth() - 15));
					action3 = false;
					enemyTurn = true;
				}
			}
		}

		if(enemyTurn) {//Enemy's actions
			enemy.attack();

			if (enemy.animations.get(1).getIndex() == enemy.animations.get(1).getSize()-1) {
				game.gravy.setHealth(game.gravy.health - (int) Math.floor(Math.random() * 10));
				game.skele.setHealth(game.gravy.health - (int) Math.floor(Math.random() * 10));
				game.bunj.setHealth(game.gravy.health - (int) Math.floor(Math.random() * 10));
				enemyTurn = false;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.forestBack, 0, 0, null);
		g.setColor(Color.GREEN);
		g.fillRect( 128, 100, game.gravy.health*3, 20);
		g.fillRect( 128, 200, game.bunj.health*3, 20);
		g.fillRect( 128, 300, game.skele.health*3, 20);

		g.setColor(Color.RED);
		g.fillRect(900, 100, enemy.health*3, 20);

		if(enemy.getHealth() <= 0) {
			g.drawImage(Assets.victory, 420, 80, 420, 140, null);
		}

		//Render each button separately. I try.
		combatUI.render(g);
		game.bunj.render(g);
		enemy.render(g);
		game.skele.render(g);
		game.gravy.render(g);
		
	}

}
