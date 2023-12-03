import acm.graphics.GImage;

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
			GImage win = new GImage("src\\victory.gif");
			win.setSize(Breakout.APPLICATION_WIDTH,Breakout.APPLICATION_HEIGHT);
			program.add(win);
			Breakout.playMusic("src\\music\\victory.wav");
			program.add(new Heading("You win!"));
			program.add(new Button("Go to main menu", 300, GameState.MainMenu));
						
			setup = true;
		}
	}
}
