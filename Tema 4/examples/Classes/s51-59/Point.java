// Slides: ch08-classes.ppt
// 51 - 59

// A Point object represents an (x, y) location.
public class Point {
    private int x;
    private int y;

    // Constructs a Point at the given x/y location.    
    public Point(int initialX, int initialY) {
        x = initialX;
        y = initialY;
    }

    public Point() {
        this(0, 0);     // calls (x, y) constructor
    }

    // A "read-only" access to the x field ("accessor")    
    public int getX() {
        return x;
    }

    // A "read-only" access to the y field ("accessor")    
    public int getY() {
        return y;
    }

    // Allows clients to change the x field ("mutator")
    public void setX(int newX) {
	x = newX;
    }

    // Returns the distance between this point and (0, 0).    
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Sets this point's (x, y) location to the given values.    
/*
    public void setLocation(int newX, int newY) {
        x = newX;
        y = newY;
    }
*/
    public void setLocation(int x, int y) {
	this.x = x;
	this.y = y;
    }

    // Shifts this point's location by the given amount.
    public void translate(int dx, int dy) {
        setLocation(x + dx, y + dy);
    }
}

