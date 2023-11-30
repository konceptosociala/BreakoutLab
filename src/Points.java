import acm.graphics.GLabel;

import java.awt.*;

public class Points extends GLabel {
    private static int points=0;
    private String label;
    public Points(String str) {
        super(str,Breakout.APPLICATION_WIDTH-100,20);
        this.setFont("Monospaced-24");
        this.setColor(Color.BLACK);
        label=""+points;
        this.setLabel(label);
    }
    public void clear() {
        points=0;
    }

    public static int getPoints() {
        return points;
    }

    public void incrementPoints() {
        //String str=(points+=10)+"";
        label=(points+=10)+"";
        this.setLabel(label);
    }
}
