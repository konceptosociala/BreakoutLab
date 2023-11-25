import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Ball extends GOval {
	private double vx , vy;

	public Ball(double x, double y, double width, double height) {
		super(x, y, width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		
		vx = Game.rng.nextDouble(0.5, 1.0); 
		if (Game.rng.nextBoolean(0.5)) 
			vx = -vx;
		
		vy = Game.rng.nextDouble(0.5, 1.0); 
		if (Game.rng.nextBoolean(0.5)) 
			vy = -vy;
	}
	
	public void move(Breakout program) {
		double x = getX();
		double y = getY();
		double d = Breakout.BALL_RADIUS * 2;
		
		if (x >= Game.getWidth() || x <= 0)
			vx = -vx;
		
		if (y >= Game.getHeight() || y <= 0)
			vy = -vy;
				
		handleCollision(program.getElementAt(x, y + d));
		handleCollision(program.getElementAt(x + d, y + d));
		handleCollision(program.getElementAt(x, y));
		handleCollision(program.getElementAt(x + d, y));
		
		setLocation(x + vx, y + vy);
	}
	
	private void handleCollision(GObject object) {
		if (object instanceof Paddle) {
            vx = -vx;
            vy = -vy;
	    } else if (object instanceof Brick) {
	        Brick brick = (Brick) object;
	        if (brick.isVisible()) {
	            brick.destroy();
	            vx = -vx;
	            vy = -vy;
	        }
	    } 
	}
}