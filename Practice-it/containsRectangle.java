/*
Add the following accessor methods to your Rectangle class from the previous exercises:

public boolean contains(int x, int y)
public boolean contains(Point p)
Returns whether the given Point or coordinates lie inside the bounds of this Rectangle. The edges are included; for example, a rectangle with [x=2,y=5,width=8,height=10] will return true for any point from (2, 5) through (10, 15) inclusive.

(You don't need to write the class header or declare the fields; assume that this is already done for you. Just write your methods' complete code in the box provided.) See previous exercises for a description of the Rectangle and Point classes and their public members.
*/
public boolean contains(int x, int y) {
    return (x <= (this.x + width) && x >= this.x) && (y <= (this.y + height) && y >= this.y);
}

public boolean contains(Point p) {
    return (p.getX() <= (this.x + width) && p.getX() >= this.x) && (p.getY() <= (this.y + height) && p.getY() >= this.y);
}
