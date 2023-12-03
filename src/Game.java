import java.util.ArrayList;
import java.util.List;

import acm.util.RandomGenerator;

public class Game 
{
	private static GameState state;
	private static WindowDescriptor window;	
	public static RandomGenerator rng = new RandomGenerator();

	private List<System> systems = new ArrayList<System>();
	private Breakout program;
	
	public Game(WindowDescriptor descriptor) 
	{
		program = descriptor.program;
		program.setName(descriptor.name);
		Debug.print(descriptor.height);
		program.setSize(descriptor.width+10, 50+descriptor.height);
		Game.state = GameState.MainMenu;
		Game.window = descriptor;
	}
	
	public Game addSystem(System system) 
	{
		this.systems.add(system);
		return this;
	}
	
	public static GameState getState() {
		return Game.state;
	}
	
	public static void setState(GameState state) {
		Game.state = state;
	}

	public static int getWidth() {
		return Game.window.width;
	}

	public static int getHeight() {
		return Game.window.height;
	}

	public static String getTitle() {
		return Game.window.name;
	}
	
	public void run() 
	{
		while(true) {
			for (System system : systems) {
				system.execute(this.program);
				if (Game.getState().equals(GameState.Exit)) {
					program.removeAll();
					program.exit();
					return;
				}
			}
		}
	}
}
