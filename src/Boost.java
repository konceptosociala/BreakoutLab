import acm.graphics.GImage;
import acm.graphics.GRect;

/*public class Boost extends GRect {

    public Boost(double x, double y,double width, double height) {
        super(x,y,width, height);
    }
}*/
public class Boost extends GImage {
    /**
     * Constructs a Boost object with the specified position, dimensions, and an image file.
     * The size of the boost is adjusted based on the provided width and height.
     *
     * @param x      The x-coordinate of the boost's position.
     * @param y      The y-coordinate of the boost's position.
     * @param width  The width of the boost (scaled for the image).
     * @param height The height of the boost (scaled for the image).
     */
    public Boost(double x, double y,double width, double height) {
        super("boost.png",x,y);
        setSize(width*2, height*2);

    }
}