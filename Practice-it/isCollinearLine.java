/*
Add the following method to your Line class:

public boolean isCollinear(Point p)

Returns true if the given point is collinear with the points of this line; that is, if, when this Line is stretched infinitely, it would eventually hit the given point. Points are collinear if a straight line can be drawn that connects them. Two basic examples are three points that have the same x- or y-coordinate. The more general case can be determined by calculating the slope of the line between each pair of points and checking whether this slope is the same for all pairs of points. Use the formula (y2 - y1) / (x2 - x1) to determine the slope between two points (x1, y1) and (x2, y2).

(Note that this formula fails for points with identical x-coordinates, so this will have to be a special case in your code.) Since Java's double type is imprecise, round all slope values to four digits past the decimal point before you compare them.

(You don't need to write the class header or declare the fields; assume that this is already done for you. Just write your constructor's complete code in the box provided.) See the previous exercises for a description of the Line class and its public members.
*/
public boolean isCollinear(Point p) {
    if(p1.getX() == p2.getX())
        return p.getX() == p1.getX();
        
    double m1 = ((double) (p.getY() - p1.getY()) / (p.getX() - p1.getX()));
    double m2 = ((double) (p.getY() - p2.getY()) / (p.getX() - p2.getX()));
    
    return m1 == m2;
}
