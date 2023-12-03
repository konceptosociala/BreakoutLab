import acm.graphics.GLabel;

import java.awt.*;

public class Points extends GLabel {
    private static int points=0;
    private String label;
    /**
     * Constructs a Points object with the specified initial label and position.
     * The initial label is set as the player's points, and the position is determined
     * by the Breakout application width and a fixed Y-coordinate.
     *
     * @param str The initial label for the points.
     */
    public Points(String str) {
        super(str,Breakout.APPLICATION_WIDTH-100,20);
        this.setFont("Monospaced-24");
        this.setColor(Color.BLACK);
        label=""+points;
        this.setLabel(label);
    }
    /**
     * Clears the player's points, resetting them to zero.
     */
    public void clear() {
        points=0;
    }
    /**
     * Gets the current points of the player.
     *
     * @return The current points.
     */
    public static int getPoints() {
        return points;
    }
    /**
     * Increments the player's points by 10 and updates the label accordingly.
     */
    public void incrementPoints() {
        label=(points+=10)+"";
        this.setLabel(label);
    }
}
