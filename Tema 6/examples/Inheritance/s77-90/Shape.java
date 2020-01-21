// Slide 83

// interface: A list of methods that a class can implement.

// A general interface for shape classes.

public interface Shape {
   // This interface describes the features common to all shapes.
   // (Every shape has an area and perimeter.)
    public double area();
    public double perimeter();
}

// abstract method: A header without an implementation.
// The actual body is not specified, to allow/force different classes 
// to implement the behavior in its own way.


