import java.awt.Color;
import acm.graphics.GOval;

public class Ball extends GOval {
	private double vx , vy;
	double timer;
	int counter=0;

	public double getVx() {
		return vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}
	public void setSpeedBonus(double vx,double vy) {
		this.vx = vx;
		this.vy = vy;
		timer=0.3;
	}

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
	
	public void move(Breakout program, Health health) {
		double x = getX();
		double y = getY();
		double d = Breakout.BALL_RADIUS * 2;
		if(timer<1&&timer!=0)
		{
			timer+=0.0001;
		}

		if (x <= 0 || x >= Game.getWidth() - d-d/2) {
			vx = -vx;
			Breakout.playMusic("src\\music\\hitTheWallSound.wav");
		}
		if (y <= 0) {
			vy = -vy;
			Breakout.playMusic("src\\music\\hitTheWallSound.wav");
		}
		if (y >= Game.getHeight()- d) {
			vy = -vy;
			health.decrease(1);
		}
		if(timer!=0)
			setLocation(x + (vx)*timer, y + (vy)*timer);
		else
			setLocation((x + vx), y + vy);
	}
}
