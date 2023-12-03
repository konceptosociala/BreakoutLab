public class WindowDescriptor
{
	public String name;
	public int width;
	public int height;
	public Breakout program;
	/**
	 * Constructs a WindowDescriptor with the specified window name, width, height, and Breakout program.
	 *
	 * @param name The name of the graphical window.
	 * @param width The width of the graphical window.
	 * @param height The height of the graphical window.
	 * @param program The associated Breakout program instance.
	 */
	public WindowDescriptor(String name, int width, int height, Breakout program) 
	{
		this.name = name;
		this.width = width;
		this.height = height;
		this.program = program;
	}
}
