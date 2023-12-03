import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class Paddle extends GCompound {
    private double X;
    private double Y;
    private double width;
    private double height;
    private double trgX;
    private GRect paddle;

    // needed
    public static int MouseX;
    public static int MouseY;
    /**
     * Constructs a Paddle object with the specified initial position, width, and height.
     * The paddle is initially positioned at the specified X and Y coordinates, and its
     * dimensions are set by the provided width and height.
     *
     * @param X The initial X-coordinate of the paddle.
     * @param Y The initial Y-coordinate of the paddle.
     * @param width The initial width of the paddle.
     * @param height The initial height of the paddle.
     */
    public Paddle(double X, double Y, double width, double height) {
        this.X = X;
        this.Y = Y;
        this.width = width;
        this.height=height;
        this.trgX = X;
        paddle = new GRect(X, Y, width, height);
        paddle.setFilled(true);
        add(paddle);
        setLocation(0,Breakout.APPLICATION_HEIGHT-Breakout.PADDLE_HEIGHT-100);
        setColor(Color.BLACK);
    }
    /**
     * Moves the paddle based on the current mouse coordinates.
     * The paddle's X-coordinate is set to the current mouse X-coordinate minus half of its width.
     */
     public void move() {
        trgX = MouseX - this.getWidth() / 2;
        paddle.setLocation(trgX, Y);

    }
    /**
     * Sets the width of the paddle to the specified value.
     *
     * @param width The new width of the paddle.
     */
    public void setWidth(double width) {
        this.width = width;
    }
    /**
     * Sets the height of the paddle to the specified value.
     *
     * @param height The new height of the paddle.
     */
    public void setHeight(double height) {
        this.height = height;
    }
}
