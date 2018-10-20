import java.awt.*;

public class CombatState extends State {

    private Player skele;

    public CombatState(Game game) {
        super(game);
        skele = new Player(game, 1000, 400, "Skeleman", Assets.skeleman);
    }

    @Override
    public void tick() {
        skele.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.forestBack, 0, 0, 1280, 720, null);
        skele.render(g);
    }
}
