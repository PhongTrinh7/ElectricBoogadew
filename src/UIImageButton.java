

import java.awt.Color;
import java.awt.Graphics;

public class UIImageButton extends UIObject{
	
	private ClickListener clicker;

	public UIImageButton(float x, float y, int width, int height, ClickListener clicker) {
		super(x, y, width, height);
		this.clicker = clicker;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering) {
			g.setColor(Color.GREEN);
			g.fillRect((int) x, (int) y, width , height);
		}
		else {
			g.setColor(Color.RED);
			g.fillRect((int) x, (int) y, width, height);
		}
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
