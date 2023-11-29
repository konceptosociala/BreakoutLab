
public class SelectLevelSystem extends System 
{
	private boolean setup = false;
	
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
