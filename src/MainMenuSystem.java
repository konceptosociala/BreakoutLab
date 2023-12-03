import acm.graphics.GImage;

public class MainMenuSystem extends System
{
	private boolean setup = false;
	
	public void execute(Breakout program)
	{		
		if (!Game.getState().equals(GameState.MainMenu)) {
			if (setup) {
				setup = false;
			}

			return;
		}
		
		if (!setup) {
			program.removeAll();
			GImage Background = new GImage("src\\bg.jpg");
			Background.setSize(Breakout.APPLICATION_WIDTH,Breakout.APPLICATION_HEIGHT);
			program.add(Background);
			program.add(new Heading("Breakout ACM"));
			program.add(new Button("Play game", 200, GameState.SelectLevel));
			program.add(new Button("Quit", 300, GameState.Exit));
						
			setup = true;
		}
	}
}