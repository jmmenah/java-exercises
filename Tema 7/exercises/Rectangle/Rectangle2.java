// Rectangle2 class
// See InvalidRectangleException.java
// Rectangle2Test.java

public class Rectangle2 {

    // Fields - State
    private int length;
    private int width;

    // no-arg constructor
    public Rectangle2() {
        length = 1;
        width = 1;
    }

    // parameterized constructor
    public Rectangle2(int length, int width) throws InvalidRectangleException {
        try {
            setLength(length);
            setWidth(width);
        } catch (InvalidRectangleException e) {
            e.getMessage();
            throw e;  // rethrow the exception
        }
    }

    // Methods - Behaviour

    // instance methods
    public int area() {
        return length * width;
    }

    public int perimeter() {
        return 2 * (length + width);
    }

    public boolean isSquare() {
        return length == width;
    }

    // getters - accessors
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    // setters - mutators
    // The set method should verify that length and width
    // are each larger than 0 and less than 20
    public void setLength(int length) throws InvalidRectangleException {
        if (length > 0 && length < 20) {
            this.length = length;
        } else {
            throw new InvalidRectangleException("length must be (0, 20)");
        }
    }

    public void setWidth(int width) throws InvalidRectangleException {
        if (width > 0 && width < 20) {
            this.width = width;
        } else {
            throw new InvalidRectangleException("width must be (0, 20)");
        }
    }

    // toString method
    public String toString() {
        return "Rectangle (width = " + width + ", length = " + length + ")";
    }

} // end Rectangle
