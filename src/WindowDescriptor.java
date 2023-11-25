public class WindowDescriptor
{
	public String name;
	public int width;
	public int height;
	public Breakout program;
	
	public WindowDescriptor(String name, int width, int height, Breakout program) 
	{
		this.name = name;
		this.width = width;
		this.height = height;
		this.program = program;
	}
}
