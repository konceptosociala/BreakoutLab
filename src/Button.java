import java.awt.event.MouseEvent;

import acm.graphics.*;

public class Button extends GLabel {
	private GameState newState;

	public Button(String label, int posV, GameState newState) {
		super(label, 0, 0);
		this.setFont("Monospaced-24");
		this.setLocation(Game.getWidth()/2 - this.getWidth()/2, posV);
		this.newState = newState;
	}
	
	public void onClick(MouseEvent e) {
		Breakout.playMusic("src\\music\\buttonPressed.wav");
		Game.setState(newState);
	}
}