import acm.graphics.GImage;

public class GameOverSystem extends System
{
	private boolean setup = false;
	/**
	 * Executes the "GameOver" system, handling the setup of the game over screen.
	 * If the current GameState is not "GameOver", the method returns without performing any action.
	 * Otherwise, it removes all elements from the program, plays a loss sound, and sets up the game over screen.
	 *
	 * @param program The Breakout program instance.
	 */
	public void execute(Breakout program) 
	{
		if (!Game.getState().equals(GameState.GameOver)) {
			if (setup) {
				setup = false;
			}

			return;
		}
		
		if (!setup) {
			program.removeAll();
			GImage iloss = new GImage("src\\loss.jpg");
			iloss.setSize(Breakout.APPLICATION_WIDTH,Breakout.APPLICATION_HEIGHT);
			program.add(iloss);
			Breakout.playMusic("src\\music\\loss.wav");
			program.add(new Heading("Game is over"));
			program.add(new Button("Go to main menu", 300, GameState.MainMenu));
						
			setup = true;
		}
	}
}
