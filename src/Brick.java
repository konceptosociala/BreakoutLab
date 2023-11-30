import acm.graphics.GRect;

import java.awt.*;

public class Brick extends GRect {
	private static int brickCounter = 0;
	public int brickLives;
	private double brickBost;
	
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
	
	public static void clearCounter() {
		brickCounter = 0;
	}
	
	public static int bricksLeft() {
		return brickCounter;
	}

	public double getBrickBost() {
		return brickBost;
	}
}