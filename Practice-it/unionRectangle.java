/*
Add the following method to your Rectangle class from the previous exercises:

public Rectangle union(Rectangle rect)
Returns a new Rectangle that represents the area occupied by the tightest bounding box that contains both this Rectangle and the given other Rectangle. Your method should not modify the current Rectangle or the one that is passed in as a parameter; you should create and return a new rectangle.

(You don't need to write the class header or declare the fields; assume that this is already done for you. Just write your method's complete code in the box provided.) See previous exercises for a description of the Rectangle class and its public members.
*/
public Rectangle union(Rectangle rect) {
    int left = Math.min(this.x, rect.x);
    int top = Math.min(this.y, rect.y);
    int right = Math.max(this.x + this.width, rect.x + rect.width);
    int bottom = Math.max(this.y + this.height, rect.y + rect.height);
        
    return new Rectangle(left, top, right - left, bottom - top);
}
