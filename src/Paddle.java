import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GRect;

public class Paddle extends GCompound {
    private double X;
    private double Y;
    private double width;
    private double trgX;
    private GRect paddle;

    // needed
    public static int MouseX;
    public static int MouseY;

    public Paddle(double X, double Y, double width, double height) {
        this.X = X;
        this.Y = Y;
        this.width = width;
        this.trgX = X;
        paddle = new GRect(X, Y, width, height);
        paddle.setFilled(true);
        add(paddle);
        setLocation(0, Breakout.APPLICATION_HEIGHT-height-150);
        setColor(Color.BLACK);
    }

    public void move() {

        trgX = MouseX - width / 2;
        paddle.setLocation(trgX, Y);
    }
}
