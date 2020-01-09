// Slides: ch08-classes.ppt
// 51 - 59

public class PointMain {
    public static void main(String[] args) {
        // create two Point objects
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);

	// Client code won't compile if it accesses private fields
	// System.out.println(p1.x);

        System.out.println(p1.getX());
	p1.setX(14);

        // print each point
        System.out.println("p1: (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("p2: (" + p2.getX() + ", " + p2.getY() + ")"); 

        // move p2 and then print it again
        p2.translate(2, 4);
        System.out.println("p2: (" + p2.getX() + ", " + p2.getY() + ")"); 
    }
}
