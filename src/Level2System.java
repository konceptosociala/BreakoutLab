public class Level2System extends System
{
	private boolean setup = false;
	
	private Paddle paddle = new Paddle(
		100,
		100, 
		Breakout.PADDLE_WIDTH, 
		Breakout.PADDLE_HEIGHT
	);
	
	private Ball ball = new Ball(
		Game.getWidth()/2 - Breakout.BALL_RADIUS, 
		Game.getHeight() - 100, 
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
							2
					);

					program.add(brick);
				}
			}
			
			setup = true;
		}
		
		paddle.move();
		ball.move(program);
		
	}
}
