import acm.graphics.GImage;
import acm.graphics.GRect;

/*public class Boost extends GRect {

    public Boost(double x, double y,double width, double height) {
        super(x,y,width, height);
    }
}*/
public class Boost extends GImage {

    public Boost(double x, double y,double width, double height) {
        super("boost.png",x,y);
        setSize(width*2, height*2);

    }
}