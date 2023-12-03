import acm.graphics.GImage;

public class MainMenuSystem extends System
{
	private boolean setup = false;
	/**
	 * Executes the logic for the main menu system. If the game state is the main menu,
	 * it sets up the graphical elements, including the heading and buttons for starting
	 * the game or quitting.
	 *
	 * @param program The Breakout program instance.
	 */
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