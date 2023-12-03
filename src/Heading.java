import acm.graphics.GLabel;
/**
 * Constructs a Heading object with the specified label.
 * The font size is set to "Monospaced-48" and the initial location is centered horizontally.
 *
 * @param label The text for the heading label.
 */
public class Heading extends GLabel {
	public Heading(String label) {
		super(label, 0, 0);
		this.setFont("Monospaced-48");
		this.setLocation(Game.getWidth()/2 - this.getWidth()/2, 100);
	}
}