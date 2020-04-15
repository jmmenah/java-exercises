// https://www.toolsqa.com/rest-assured/serialization-and-deserialization-in-java/

import java.io.Serializable;

public class Rectangle implements Serializable {

    private static final long serialVersionUID = 1L;

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double Area() {
        return height * width;
    }

    public double Perimeter() {
        return 2 * (height + width);
    }
}
