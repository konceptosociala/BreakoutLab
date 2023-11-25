import acm.graphics.GLabel;

public class Heading extends GLabel {
	public Heading(String label) {
		super(label, 0, 0);
		this.setFont("Monospaced-48");
		this.setLocation(Game.getWidth()/2 - this.getWidth()/2, 100);
	}
}