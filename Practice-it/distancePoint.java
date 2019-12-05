/*
Add the following method to the Point class:

public double distance(Point other)

Returns the distance between the current Point object and the given other Point object. The distance between two points is equal to the square root of the sum of the squares of the differences of their x- and y-coordinates. In other words, the distance between two points (x1, y1) and (x2, y2) can be expressed as the square root of (x2 - x1)2 + (y2 - y1)2. Two points with the same (x, y) coordinates should return a distance of 0.0.

public class Point {

    int x;

    int y;

    

    // // your code goes here

    

}
*/
public double distance(Point other) {
    int dx = x - other.x;
    int dy = y - other.y;
    return Math.sqrt(dx * dx + dy * dy);
}
