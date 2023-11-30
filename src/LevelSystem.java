import acm.graphics.GObject;

public class LevelSystem extends System 
{
	public Boost boost;
	protected Health health;
	protected Paddle paddle;
	protected Ball ball;
	protected int brickRow = 0;
	
	public void execute(Breakout program) {}
	
	protected void handleCollisionBonus(Breakout program) 
	{
		if(boost != null)
		{
			double bx1 = boost.getX() - 1;
			double by1 = boost.getY() - 1;

			double bx2 = boost.getX() + boost.getWidth() - 1;
			double by2 = by1;

			double bx3 = boost.getX() + 1;
			double by3 = boost.getY() + boost.getHeight() + 1;

			double bx4 = boost.getX() + boost.getWidth() + 1;
			double by4 = by3;

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
			if (obj instanceof Paddle) {
				int whatBonus = Game.rng.nextInt(0,3);
				Debug.print(whatBonus);
				boolean rand;
				switch ( whatBonus)
				{
					case 0:
						rand = Game.rng.nextBoolean();
						paddle.scale(rand ? 1.25: 0.85);
						if(rand) {
							Breakout.playMusic("src\\music\\bonusPickedUp.wav");
							paddle.setWidth(paddle.getWidth() * 1.25);
							paddle.setHeight(paddle.getHeight() * 1.25);
						} else {
							Breakout.playMusic("src\\music\\debuffPickedUp.wav");
							paddle.setWidth(paddle.getWidth() * 0.85);
							paddle.setHeight(paddle.getHeight() * 0.85);
						}
						break;
					case 1:
						Breakout.playMusic("src\\music\\bonusPickedUp.wav");
						health.increase(1);
						break;
					case 2:
						Breakout.playMusic("src\\music\\bonusPickedUp.wav");
						ball.setSpeedBonus(ball.getVx(),ball.getVy());
						break;
					case 3:
						Breakout.playMusic("src\\music\\bonusPickedUp.wav");
						ball.setSpeedBonus(ball.getVx(),ball.getVy());
						break;
				}


				program.remove(boost);
				boost = null;
			}
		}
	}
	
	protected void handleCollision(Breakout program) {
		double r = Breakout.BALL_RADIUS ;

		double bx1 = ball.getX() - 1;
		double by1 = ball.getY() - 1;

		double bx2 = ball.getX() + ball.getWidth() - 1;
		double by2 = by1;

		double bx3 = ball.getX() + 1;
		double by3 = ball.getY() + ball.getHeight() + 1;

		double bx4 = ball.getX() + ball.getWidth() + 1;
		double by4 = by3;

		double bx5 = ball.getX() + r;
		double by5= ball.getY();

		double bx6 = ball.getX();
		double by6 = ball.getY()+ r;

		double bx7 = ball.getX() + 2*r;
		double by7 = ball.getY()+ r;

		double bx8 = ball.getX() +r;
		double by8 = ball.getY()+ r;

		GObject obj = null;

		if(program.getElementAt(bx1, by1) != null) {
			obj = program.getElementAt(bx1, by1);
		} else if(program.getElementAt(bx2, by2) != null) {
			obj = program.getElementAt(bx2, by2);
		} else if(program.getElementAt(bx3, by3) != null) {
			obj = program.getElementAt(bx3, by3);
		} else if(program.getElementAt(bx4, by4) != null) {
			obj = program.getElementAt(bx4, by4);
		} else if(program.getElementAt(bx5, by5) != null) {
			obj = program.getElementAt(bx5, by5);
		} else if(program.getElementAt(bx6, by6) != null) {
			obj = program.getElementAt(bx6, by6);
		} else if(program.getElementAt(bx7, by7) != null) {
			obj = program.getElementAt(bx7, by7);
		} else if(program.getElementAt(bx8, by8) != null) {
			obj = program.getElementAt(bx8, by8);
		}

		if (obj instanceof Paddle) {
			Breakout.playMusic("src\\music\\hitTheWallSound.wav");
			ball.setVy(-ball.getVy());
		} else if (obj instanceof Brick) {
			Brick brick = (Brick) obj;
			if (brick.isVisible() && brick.brickLives == 1) {
				<<<<<<< Updated upstream
=======
				if(points!=null)
					points.incrementPoints();
>>>>>>> Stashed changes
				brick.destroy(program);
						brick.destroy(program);
				if(brick.getBrickBost() % 4 == 0 && boost == null)
				{
					boost = new Boost(brick.getX(), brick.getY(), 30, 30);
					program.add(boost);
				}
				brick.brickLives--;
				ball.setVy(-ball.getVy());
			} else {
				Breakout.playMusic("src\\music\\hitTheWallSound.wav");
				brick.brickLives--;
				ball.setVy(-ball.getVy());
			}
		}
	}
}
