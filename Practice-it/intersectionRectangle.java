/*
Add the following method to your Rectangle class from the previous exercises:

public Rectangle intersection(Rectangle rect)
Returns a new rectangle that represents the largest rectangular region completely contained within both this rectangle and the given other rectangle. If the rectangles do not intersect at all, returns null. Your method should not modify the current Rectangle or the one that is passed in as a parameter; you should create and return a new rectangle.

(You don't need to write the class header or declare the fields; assume that this is already done for you. Just write your method's complete code in the box provided.) See the previous exercises for a description of the Rectangle class and its public members.
*/
public Rectangle intersection(Rectangle rect) {
    int left = Math.max(this.x, rect.x);
    int top = Math.max(this.y, rect.y);
    int right = Math.min(this.x + this.width, rect.x + rect.width);
    int bottom = Math.min(this.y + this.height, rect.y + rect.height);
    int width = Math.max(0, right - left);
    int height = Math.max(0, bottom - top);
        
    return new Rectangle(left, top, width, height);
}
