import java.awt.*;

public class MenuState extends State {
    public MenuState(Game game) {
        super(game);
    }

    @Override
    //NEW When you press the right and left mouse button at the same time, it will
    //switch to gameState.
    public void tick() {
        if(game.getMouseManager().isLeftPressed() && game.getMouseManager().isRightPressed()){
            State.setState(game.gameState);
        }
    }

    @Override
    //NEW Test that makes a small red square follow your mouse.
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(game.getMouseManager().getMouseX(), game.getMouseManager.getMouseY(), 8, 8);

    }
}
