/*
Add a constructor to the Point class that accepts another Point as a parameter and initializes the new Point to have the same (x, y) values. Use the keyword this in your solution.

Recall that your code is being added to the following class:

public class Point {

    int x;

    int y;

    

    // // your code goes here

    

}

(You don't need to write the class header or declare the fields; assume that this is already done for you. Just write your constructor's complete code in the box provided.)
*/
public Point(Point p) {
    this.x = p.x;
    this.y = p.y;
}
