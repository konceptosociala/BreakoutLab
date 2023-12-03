import acm.graphics.GRect;

import java.awt.*;

public class Brick extends GRect {
	private static int brickCounter = 0;
	public int brickLives;
	private double brickBost;
	/**
	 * Constructs a Brick object with the specified position, dimensions, lives, and row.
	 * The color of the brick is determined based on the row it belongs to.
	 * The brick is initially filled, and the counter is incremented.
	 *
	 * @param x          The x-coordinate of the brick's position.
	 * @param y          The y-coordinate of the brick's position.
	 * @param width      The width of the brick.
	 * @param height     The height of the brick.
	 * @param brickLives The initial number of lives the brick has.
	 * @param brickRow   The row to determine the color of the brick.
	 */
	public Brick(double x, double y, double width, double height, int brickLives, int brickRow) {
		super(x, y, width, height);

		if (brickRow <= 2) {
			super.setColor(Color.RED);
		} else if (brickRow <= 4) {
			super.setColor(Color.ORANGE);
		} else if (brickRow <= 6) {
			super.setColor(Color.YELLOW);
		} else if (brickRow <= 8) {
			super.setColor(Color.GREEN);
		} else if (brickRow <= 10) {
			super.setColor(Color.CYAN);
		}
		this.brickLives=brickLives;
		super.setFilled(true);
        brickCounter++;
		brickBost = Game.rng.nextInt(0, 12);
	}
	/**
	 * Destroys the brick by making it invisible, playing a sound, updating the counter, and removing it from the program.
	 * If all bricks are destroyed, it updates the game state to the next level or "YouWin" if the final level is reached.
	 *
	 * @param program The Breakout program instance.
	 */
	public void destroy(Breakout program){
		Breakout.playMusic("src\\music\\brickHitSound.wav");
		setVisible(false);
		brickCounter--;
		Debug.print(brickCounter);
		program.remove(this);
		if(brickCounter <= 0) {
			Debug.print("Game.getState()");
			if (Game.getState().equals(GameState.Level1))
				Game.setState(GameState.Level2);
			else if (Game.getState().equals(GameState.Level2))
				Game.setState(GameState.Level3);
			else
				Game.setState(GameState.YouWin);

		}
	}
	/**
	 * Clears the brick counter, resetting the total number of bricks.
	 */
	public static void clearCounter() {
		brickCounter = 0;
	}
	/**
	 * Returns the number of bricks left in the game.
	 *
	 * @return The number of bricks left.
	 */
	public static int bricksLeft() {
		return brickCounter;
	}
	/**
	 * Gets the boost value of the brick.
	 *
	 * @return The boost value of the brick.
	 */
	public double getBrickBost() {
		return brickBost;
	}
}