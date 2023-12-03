import java.awt.event.MouseEvent;

import acm.graphics.*;

public class Button extends GLabel {
	private GameState newState;
	/**
	 * Constructs a Button object with the specified label, vertical position, and new GameState.
	 * The font is set to "Monospaced-24", and the initial location is centered horizontally.
	 *
	 * @param label    The label text for the button.
	 * @param posV     The vertical position of the button.
	 * @param newState The GameState to transition to when the button is clicked.
	 */
	public Button(String label, int posV, GameState newState) {
		super(label, 0, 0);
		this.setFont("Monospaced-24");
		this.setLocation(Game.getWidth()/2 - this.getWidth()/2, posV);
		this.newState = newState;
	}
	/**
	 * Handles the onClick event for the button.
	 * Plays a button-pressed sound and transitions the game state to the associated new state.
	 *
	 * @param e The MouseEvent representing the button click.
	 */
	public void onClick(MouseEvent e) {
		Breakout.playMusic("src\\music\\buttonPressed.wav");
		Game.setState(newState);
	}
}