/*
Suppose that a class Point2D has been defined for storing a 2-dimensional point with x and y coordinates (both as doubles). (In our section handout, the class was called Point, but we have renamed it here because Practice-It uses a class named Point for other purposes.) The class includes the following members:
Name	Description
private double x 	the x coordinate
private double y 	the y coordinate
public Point2D() 	constructs the point (0, 0)
public Point2D(double x, double y) 	constructs a point with the given coordinates
public void setLocation(double x, double y) 	sets the coordinates to the given values
public double getX() 	returns the x coordinate
public double getY() 	returns the y coordinate
public String toString() 	returns a String in standard "(x, y)" notation
public double distance(Point2D other) 	returns the distance from another point

Your task is to modify the class to be Comparable by adding an appropriate compareTo method. Points should be compared relative to their distance from the origin, with points closer to the origin considered "less" than points farther from it. The distance between two points is defined as the square root of the sum of the squares of the differences between the x and y coordinates.
*/
public int compareTo(Point2D p) {
    double distance1 = Math.sqrt(x * x + y * y);
    double distance2 = Math.sqrt(p.x * p.x + p.y * p.y);
    if (distance1 - distance2 < 0) {
        return -1;
    } else if (distance1 - distance2 > 0) {
        return 1;
    } else {
        return 0;
    }
}
