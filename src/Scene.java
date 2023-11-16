public class Scene {
	private int index;

	private Scene(int index) {
		this.index = index;
	}

	public static Scene MainMenu = new Scene(0);
	public static Scene Level1 = new Scene(1);
	public static Scene Level2 = new Scene(2);
	public static Scene Level3 = new Scene(3);
	public static Scene GameOver = new Scene(4);
	
	public boolean equals(Scene scene) {
		return (this.index == scene.index);
	}
}
