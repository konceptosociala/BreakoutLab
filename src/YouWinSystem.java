public class YouWinSystem extends System 
{
	private boolean setup = false;
	/**
	 * Executes the logic for the "You Win" system. If the game state is the victory screen,
	 * it sets up the graphical elements, including the heading and a button to return to the main menu.
	 *
	 * @param program The Breakout program instance.
	 */
	public void execute(Breakout program) 
	{
		if (!Game.getState().equals(GameState.YouWin)) {
			if (setup) {
				setup = false;
			}

			return;
		}
		
		if (!setup) {
			program.removeAll();
			Breakout.playMusic("src\\music\\victory.wav");
			program.add(new Heading("You win!"));
			program.add(new Button("Go to main menu", 300, GameState.MainMenu));
						
			setup = true;
		}
	}
}
