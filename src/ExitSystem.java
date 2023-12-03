public class ExitSystem extends System 
{
	private boolean setup = false;
	/**
	 * Executes the "Exit" system, handling the game's exit process.
	 * If the current GameState is not "Exit", the method returns without performing any action.
	 * Otherwise, it removes all elements from the program, exits the program, and sets up the necessary cleanup.
	 *
	 * @param program The Breakout program instance.
	 */
	public void execute(Breakout program)
	{		
		if (!Game.getState().equals(GameState.Exit)) {
			if (setup) {
				setup = false;
			}

			return;
		}
		
		if (!setup) {
			program.removeAll();
			program.exit();
			
			setup = true;
		}
	}
}
