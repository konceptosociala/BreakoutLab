import acm.graphics.GRect;

import acm.graphics.GRect;


import java.awt.*;

public class Brick extends GRect {
private static int brickCounter = 0;
	public Brick(double x, double y, double width, double height) {
		super(x, y, width, height);


		if (Breakout.row <= 2) {
			super.setColor(Color.RED);}

		else if (Breakout.row <= 4) {
			super.setColor(Color.ORANGE);
		}
		else if (Breakout.row <= 6) {
			super.setColor(Color.YELLOW);
		}
		else if (Breakout.row <= 8) {
			super.setColor(Color.GREEN);
		}
		else if (Breakout.row <= 10) {
			super.setColor(Color.CYAN);
		}
		super.setFilled(true);
                brickCounter++;
		}
	private void deleteBrick(){
		brickCounter--;
		if(brickCounter<=0){
			gameIsOver = true;
		}
		}

	//Move somewhere else. Game is over if brickCounter == 0.
		private boolean gameIsOver;


	}
