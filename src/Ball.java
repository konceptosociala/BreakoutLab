import java.awt.Color;
import acm.graphics.GOval;

public class Ball extends GOval {
	private double vx , vy;
	double timer;
	int counter=0;

	/**
	 * Gets the x-component of the ball's velocity.
	 *
	 * @return The x-component of the velocity.
	 */
	public double getVx() {
		return vx;
	}
	/**
	 * Gets the y-component of the ball's velocity.
	 *
	 * @return The y-component of the velocity.
	 */
	public double getVy() {
		return vy;
	}
	/**
	 * Sets the y-component of the ball's velocity.
	 *
	 * @param vy The new y-component of the velocity.
	 */
	public void setVy(double vy) {
		this.vy = vy;
	}
	/**
	 * Sets the x-component of the ball's velocity.
	 *
	 * @param vx The new x-component of the velocity.
	 */
	public void setVx(double vx) {
		this.vx = vx;
	}
	/**
	 * Sets a speed bonus for the ball, modifying both x and y components of velocity.
	 * Also, sets a timer for the duration of the speed bonus.
	 *
	 * @param vx The new x-component of the velocity.
	 * @param vy The new y-component of the velocity.
	 */
	public void setSpeedBonus(double vx,double vy) {
		this.vx = vx;
		this.vy = vy;
		timer=0.3;
	}
	/**
	 * Constructs a Ball object with specified position, dimensions, and initial speed.
	 * The ball is filled and has a black color.
	 * The initial velocity is random and can be negative.
	 *
	 * @param x      The x-coordinate of the ball's position.
	 * @param y      The y-coordinate of the ball's position.
	 * @param width  The width of the ball.
	 * @param height The height of the ball.
	 * @param speed  The initial speed of the ball.
	 */
	public Ball(double x, double y, double width, double height, double speed) {
		super(x, y, width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		
		vx = Game.rng.nextDouble(0.5, 1.0) * speed; 
		if (Game.rng.nextBoolean(0.5)) 
			vx = -vx;
		
		vy = Game.rng.nextDouble(0.5, 1.0) * speed; 
		if (Game.rng.nextBoolean(0.5)) 
			vy = -vy;
	}
	/**
	 * Handles the movement of the ball based on its velocity and game environment.
	 * Checks for collisions with walls and updates the position accordingly.
	 * Handles special cases, such as a speed bonus timer.
	 *
	 * @param program The Breakout program instance.
	 * @param health  The Health instance representing player's health.
	 */
	public void move(Breakout program, Health health) {
		double x = getX();
		double y = getY();
		double d = Breakout.BALL_RADIUS * 2;
		if(timer<1&&timer!=0)
		{
			timer+=0.0001;
		}

		if (x <= 0 || x >= Game.getWidth() - d-d/2) {
			LevelSystem.touchedPaddle=false;
			vx = -vx;
			Breakout.playMusic("src\\music\\hitTheWallSound.wav");
		}
		if (y <= 0) {
			LevelSystem.touchedPaddle=false;
			vy = -vy;
			Breakout.playMusic("src\\music\\hitTheWallSound.wav");
		}
		if (y >= Game.getHeight()- d) {
			x= (double) Game.getWidth() /2 - Breakout.BALL_RADIUS;
			y= (double) Game.getHeight() /2-70;
			setLocation(x,y);
			health.decrease(1);
			LevelSystem.touchedPaddle=false;
		}
		if(timer!=0)
			setLocation(x + (vx)*timer, y + (vy)*timer);
		else
			setLocation((x + vx), y + vy);
	}
}
