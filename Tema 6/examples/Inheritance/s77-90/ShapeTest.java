// Slide 89

// Interfaces don't benefit the class so much as the client. 
// Interface's is-a relationship lets the client use polymorphism.

public class ShapeTest {

    public static void main(String[] args) {

	// Any object that implements the interface may be passed.

	Circle circ = new Circle(12.0);
	Rectangle rect = new Rectangle(4, 7);
	Triangle tri = new Triangle(5, 12, 13);
	printInfo(circ);
	printInfo(tri);
	printInfo(rect);

	Shape[] shapes = {tri, circ, rect};
        /*
	System.out.println(); 
        for (int i = 0; i < shapes.length; i++) {
 	    printInfo(shapes[i]);
        }

	System.out.println();
        for (Shape s : shapes)
	    printInfo(s);
        */
    }

    public static void printInfo(Shape s) {
	System.out.println("The shape: " + s);
	System.out.println("area : " + s.area());
	System.out.println("perim: " + s.perimeter());
    }

}
