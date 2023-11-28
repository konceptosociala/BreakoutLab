import acm.graphics.GObject;

public class Level1System extends System
{
	private boolean setup = false;
	public Boost boost;
	private Paddle paddle = new Paddle(
		0,
		0,
		Breakout.PADDLE_WIDTH, 
		Breakout.PADDLE_HEIGHT
	);
	
	private Ball ball = new Ball(
		Game.getWidth()/2 - Breakout.BALL_RADIUS, 
		Game.getHeight() - 150,
		Breakout.BALL_RADIUS * 2, 
		Breakout.BALL_RADIUS * 2
	);
	
	public void execute(Breakout program) 
	{
		if (!Game.getState().equals(GameState.Level1)) {
			if (setup) {
				setup = false;
			}

			return;
		}
		
		if (!setup) {
			program.removeAll();
			program.add(paddle);
			program.add(ball);
			
			for(int i = 0; i < Breakout.NBRICK_ROWS; i++) {
				Breakout.row++;
				for (int j = 0; j < Breakout.NBRICKS_PER_ROW; j++) {

					Brick brick = new Brick(
						(Breakout.BRICK_WIDTH + Breakout.BRICK_SEP) * j, 
						Breakout.BRICK_Y_OFFSET+i*(Breakout.BRICK_HEIGHT+Breakout.BRICK_SEP), 
						Breakout.BRICK_WIDTH, 
						Breakout.BRICK_HEIGHT,
							1
					);

					program.add(brick);
				}
			}
			
			setup = true;
		}
		
		paddle.move();
		handleCollisionBonus(program);
		handleCollision(program);
		if(boost!=null)
		{
			boost.move(0,0.2);
		}
		ball.move(program);

		program.pause(2);
	}
	private void handleCollisionBonus(Breakout program) {
		if(boost!=null)
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
				boolean rand=Game.rng.nextBoolean();
				paddle.scale(rand ? 1.2: 0.85);
				if(rand) {
					paddle.setWidth(paddle.getWidth() * 1.2);
					paddle.setHeight(paddle.getHeight() * 1.2);
				}else
				{
					paddle.setWidth(paddle.getWidth() * 0.85);
					paddle.setHeight(paddle.getHeight() * 0.85);
				}

				program.remove(boost);
				boost=null;
			}
		}
	}
	private void handleCollision(Breakout program) {
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
			ball.setVx(-ball.getVx());
			ball.setVy(-ball.getVy());

		} else if (obj instanceof Brick) {
			Brick brick = (Brick) obj;
			if (brick.isVisible()&&brick.brickLives==1) {
				brick.destroy(program);
				Debug.print(""+brick.getBrickBost());
				if(brick.getBrickBost()%5==0&&boost==null)
				{
					boost=new Boost(brick.getX(),brick.getY(),30,30);
					program.add(boost);
				}
				brick.brickLives--;
				ball.setVx(-ball.getVx());
				ball.setVy(-ball.getVy());
			}
			else{
				brick.brickLives--;
				ball.setVx(-ball.getVx());
				ball.setVy(-ball.getVy());
			}
		}
}
}
