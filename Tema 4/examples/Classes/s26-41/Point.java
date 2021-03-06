// Slides: ch08-classes.ppt
// 26 - 41

// A Point object represents a pair of (x, y) coordinates.
// Bomb

import java.awt.Graphics;

public class Point {
    int x;
    int y;

    // Returns a String representing this Point.
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
 
    // Draws this Point object on the DrawingPanel
    public void draw(Graphics g) {
        g.fillOval(x, y, 3, 3);
        //g.drawString("(" + x + ", " + y + ")", x, y);
        g.drawString(this.toString(), x, y);
    }

    // Computes the distance between a Point and another Point parameter
    public double distance(Point other) {
        int dx = x - other.x;
        int dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
/*
    public double distance(Point other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }
*/

    // Sets this point's (x, y) location to the given values.
    public void setLocation(int newX, int newY) {
        x = newX;
        y = newY;
    }

    // Returns the distance between this point and (0, 0).
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Shifts this point's location by the given amount.
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

   // alternative solution that utilizes setLocation
/*
   public void translate(int dx, int dy) {
       setLocation(x + dx, y + dy);
   }
*/
}
