
import java.awt.Graphics;

public class CombatState extends State{

    private Player skele;
	
    private UIManager combatUI;
	//private Animation skele_tele_animation;
	private boolean action;
	
	public CombatState(Game game) {
		super(game);

		skele = new Player(game, 480, 400, "Skele", Assets.skeleman);
		skele.addAnimation(Assets.skeleman_tele);
		action = false;
		
		combatUI = new UIManager(game);
		game.getMouseManager().setUIManager(combatUI);
		combatUI.addObject(new UIImageButton(200, 200, 64, 64, new ClickListener() {
			
			public void onClick() {
                action = true;
				//game.getMouseManager().setUIManager(null);
				//State.setState(game.gameState);
			}}));
		
		
		//skele_tele_animation = new Animation(500, Assets.skeleman_tele);
		  
    }

	@Override
	public void tick() {
	    combatUI.tick();
	    skele.tick();
	}

	@Override
	public void render(Graphics g) {
	    if (action) {
	        skele.action(g, 1);
	        action = false;
        }
        else {
            combatUI.render(g);
            skele.render(g);
            //g.drawImage(skele_tele_animation.getAnimationFrame(), skeleX, 530, 150, 100, null);
        }
	}

}
