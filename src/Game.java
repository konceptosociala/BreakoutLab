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
	/**
	 * Constructs a Game object with the specified window descriptor.
	 * Initializes the game state to "MainMenu" and sets up the window.
	 *
	 * @param descriptor The window descriptor for the game.
	 */
	public Game(WindowDescriptor descriptor) 
	{
		program = descriptor.program;
		program.setName(descriptor.name);
		program.setSize(descriptor.width+10, 50+descriptor.height);
		Game.state = GameState.MainMenu;
		Game.window = descriptor;
	}
	/**
	 * Adds a system to the game.
	 *
	 * @param system The system to be added to the game.
	 * @return The Game instance for method chaining.
	 */
	public Game addSystem(System system) 
	{
		this.systems.add(system);
		return this;
	}
	/**
	 * Gets the current game state.
	 *
	 * @return The current game state.
	 */
	public static GameState getState() {
		return Game.state;
	}
	/**
	 * Sets the game state to the specified state.
	 *
	 * @param state The new game state.
	 */
	public static void setState(GameState state) {
		Game.state = state;
	}
	/**
	 * Gets the width of the game window.
	 *
	 * @return The width of the game window.
	 */
	public static int getWidth() {
		return Game.window.width;
	}
	/**
	 * Gets the height of the game window.
	 *
	 * @return The height of the game window.
	 */
	public static int getHeight() {
		return Game.window.height;
	}
	/**
	 * Gets the title of the game window.
	 *
	 * @return The title of the game window.
	 */
	public static String getTitle() {
		return Game.window.name;
	}
	/**
	 * Runs the game loop, executing each system in the process.
	 * The loop continues indefinitely until the game state is set to "Exit".
	 */
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
