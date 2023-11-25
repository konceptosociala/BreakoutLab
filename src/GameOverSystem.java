public class GameOverSystem extends System 
{
	private boolean setup = false;
	
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
			
			program.add(new Heading("Game is over"));
			program.add(new Button("Go to main menu", 300, GameState.MainMenu));
						
			setup = true;
		}
	}
}
