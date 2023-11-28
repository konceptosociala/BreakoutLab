import acm.graphics.GRect;

import java.awt.*;

public class Brick extends GRect {
	private static int brickCounter = 0;
	public int brickLives;
	private double brickBost;
	public Brick(double x, double y, double width, double height,int brickLives) {
		super(x, y, width, height);

		if (Breakout.row <= 2) {
			super.setColor(Color.RED);
		} else if (Breakout.row <= 4) {
			super.setColor(Color.ORANGE);
		} else if (Breakout.row <= 6) {
			super.setColor(Color.YELLOW);
		} else if (Breakout.row <= 8) {
			super.setColor(Color.GREEN);
		} else if (Breakout.row <= 10) {
			super.setColor(Color.CYAN);
		}
		this.brickLives=brickLives;
		super.setFilled(true);
        brickCounter++;
		brickBost = Game.rng.nextInt(0, 10);
	}

	public void destroy(Breakout program){
		setVisible(false);
		brickCounter--;

		program.remove(this);
		if(brickCounter <= 0) {
			Debug.print("Game.getState()");
			if (Game.getState().equals(GameState.Level1)) {

				Game.setState(GameState.Level2);
				Debug.print("Game.getState()");
			}
			else if (Game.getState().equals(GameState.Level2))
				Game.setState(GameState.Level3);
			else
				Game.setState(GameState.YouWin);

		}
	}

	public double getBrickBost() {
		return brickBost;
	}
}