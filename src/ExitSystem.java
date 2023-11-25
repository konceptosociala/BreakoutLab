public class ExitSystem extends System 
{
	private boolean setup = false;
	
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
