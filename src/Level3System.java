import acm.graphics.GLabel;

public class Level3System extends LevelSystem
{	
	private boolean setup = false;
	private GLabel title = new GLabel("Level 3", 5, Game.getHeight() - 40);
	private GLabel brickCount;
	/**
	 * Executes the logic for the third level of the Breakout game.
	 * Sets up the initial game state, including the paddle, ball, bricks, health, and points.
	 * Handles user input, collisions, and updates game elements. Introduces increased difficulty
	 * with a smaller paddle size, fewer health points, and faster ball speed.
	 *
	 * @param program The Breakout program instance.
	 */
	public void execute(Breakout program) 
	{
		if (!Game.getState().equals(GameState.Level3)) {
			if (setup) {
				setup = false;
			}

			return;
		}
		
		if (!setup) {
			program.removeAll();
			
			Brick.clearCounter();
			brickRow = 0;
			points=new Points(points.getPoints()+"");
			health = new Health(2);
			paddle = new Paddle(0, 0, Breakout.PADDLE_WIDTH * 0.6, Breakout.PADDLE_HEIGHT * 0.6);
			ball = new Ball(
				Game.getWidth()/2 - Breakout.BALL_RADIUS, 
				Game.getHeight() - 150, 
				Breakout.BALL_RADIUS * 2, 
				Breakout.BALL_RADIUS * 2,
				1.5
			);
			
			program.add(paddle);
			program.add(points);
			program.add(ball);
			program.add(health);
			program.add(title);
			
			for(int i = 0; i < Breakout.NBRICK_ROWS; i++) {
				brickRow++;
				for (int j = 0; j < Breakout.NBRICKS_PER_ROW; j++) {

					Brick brick = new Brick(
						(Breakout.BRICK_WIDTH + Breakout.BRICK_SEP) * j, 
						Breakout.BRICK_Y_OFFSET+i*(Breakout.BRICK_HEIGHT+Breakout.BRICK_SEP), 
						Breakout.BRICK_WIDTH, 
						Breakout.BRICK_HEIGHT,
						2, brickRow
					);

					program.add(brick);
				}
			}
			
			brickCount = new GLabel("Bricks left: " + Brick.bricksLeft(), 5, Game.getHeight() - 25);
			program.add(brickCount);
			
			setup = true;
		}
		
		paddle.move();
		handleCollisionBonus(program);
		handleCollision(program);
		
		if (boost != null)
		{
			boost.move(0, 0.2);
		}
		
		ball.move(program, health);
		
		brickCount.setLabel("Bricks left: " + Brick.bricksLeft());
		
		if (health.isDead())
			Game.setState(GameState.GameOver);

		program.pause(2);
	}
}
