/*
Add the following constructor to your Rectangle class from the previous exercise:

public Rectangle(Point p, int width, int height)
Constructs a new rectangle whose top-left corner is specified by the given point and with the given width and height.

(You don't need to write the class header or declare the fields; assume that this is already done for you. Just write your constructor's complete code in the box provided.) See previous exercises for a description of the Rectangle and Point classes and their public members.
*/
public Rectangle(Point p, int width, int height) {
    this(p.getX(), p.getY(), width, height);
}
