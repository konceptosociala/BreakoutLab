import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Ball extends GOval {
	private double vx , vy;
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
		
		if (x >= Game.getWidth()-d || x <= 0)
			vx = -vx;
		
		if (y >= Game.getHeight() || y <= 0)
			vy = -vy;
		//handleCollision(program);

		setLocation(x + vx, y + vy);
	}
	
	private void handleCollision(Breakout program) {
		double r = Breakout.BALL_RADIUS ;

		double bx1 = this.getX() - 1;
		double by1 = this.getY() - 1;

		double bx2 = this.getX() + this.getWidth() - 1;
		double by2 = by1;

		double bx3 = this.getX() + 1;
		double by3 = this.getY() + this.getHeight() + 1;

		double bx4 = this.getX() + this.getWidth() + 1;
		double by4 = by3;

		double bx5 = this.getX() + r;
		double by5= this.getY();

		double bx6 = this.getX();
		double by6 = this.getY()+ r;

		double bx7 = this.getX() + 2*r;
		double by7 = this.getY()+ r;

		double bx8 = this.getX() +r;
		double by8 = this.getY()+ r;


		GObject obj = null;

		if(program.getElementAt(bx1, by1) != null) {
			obj = program.getElementAt(bx1, by1);
		}
		else if(program.getElementAt(bx2, by2) != null) {
			obj = program.getElementAt(bx2, by2);
		}
		else if(program.getElementAt(bx3, by3) != null) {
			obj = program.getElementAt(bx3, by3);
		}
		else if(program.getElementAt(bx4, by4) != null) {
			obj = program.getElementAt(bx4, by4);
		}
		else if(program.getElementAt(bx5, by5) != null) {
			obj = program.getElementAt(bx5, by5);
		}
		else if(program.getElementAt(bx6, by6) != null) {
			obj = program.getElementAt(bx6, by6);
		}
		else if(program.getElementAt(bx7, by7) != null) {
			obj = program.getElementAt(bx7, by7);
		}
		else if(program.getElementAt(bx8, by8) != null) {
			obj = program.getElementAt(bx8, by8);
		}

		if (obj instanceof Paddle) {
            vx = -vx;
            vy = -vy;

	    } else if (obj instanceof Brick) {
	        Brick brick = (Brick) obj;
	        if (brick.isVisible()&&brick.brickLives==1) {
	            brick.destroy(program);
				Debug.print(""+brick.getBrickBost());
				if(brick.getBrickBost()%2==0)
				{
					//boost=new Boost(this.getX(),this.getY(),this.getWidth(),this.getHeight());
				}
				brick.brickLives--;
	            vx = -vx;
	            vy = -vy;
	        }
			else{
				brick.brickLives--;
				vx = -vx;
				vy = -vy;
			}
	    }
	}
}
