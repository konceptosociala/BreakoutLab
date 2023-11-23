import acm.graphics.GRect;

import acm.graphics.GRect;


import java.awt.*;

public class Brick extends GRect {

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

		}


	}
