public class YouWinSystem extends System 
{
	private boolean setup = false;
	
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
