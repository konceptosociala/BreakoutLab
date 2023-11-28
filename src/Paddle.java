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
     public void move() {
         //Debug.print("12:"+this.getWidth());
         //Debug.print("34:"+width);
        trgX = MouseX - this.getWidth() / 2;
        paddle.setLocation(trgX, Y);

    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
