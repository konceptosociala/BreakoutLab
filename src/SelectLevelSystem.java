
public class SelectLevelSystem extends System 
{
	private boolean setup = false;
	/**
	 * Executes the logic for the level selection system. If the game state is the level selection,
	 * it sets up the graphical elements, including the heading and buttons for selecting
	 * different game levels.
	 *
	 * @param program The Breakout program instance.
	 */
	public void execute(Breakout program) 
	{
		if (!Game.getState().equals(GameState.SelectLevel)) {
			if (setup) {
				setup = false;
			}

			return;
		}
		
		if (!setup) {
			program.removeAll();
			
			program.add(new Heading("Select level"));
			program.add(new Button("Level 1", 300, GameState.Level1));
			program.add(new Button("Level 2", 400, GameState.Level2));
			program.add(new Button("Level 3", 500, GameState.Level3));
						
			setup = true;
		}
	}
}
