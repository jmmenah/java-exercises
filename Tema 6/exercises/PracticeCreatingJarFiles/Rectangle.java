// Rectangle class
// See RectangleTest.java

public class Rectangle {

	// Fields - State
	private int length;
	private int width;

	// no-arg constructor
	public Rectangle() {
		length = 1;
		width = 1;
	}

	// parameterized constructor
	public Rectangle(int length, int width) {
		// this.length = length;
		// this.width = width;
		setLength(length);
		setWidth(width);
	}

	// Methods - Behaviour

	// instance methods
	public int area() {
		return length * width;
	}

	public int perimeter() {
		return 2 * (length + width);
	}

	public boolean isSquare() {
		return length == width;
	}

	// getters - accessors
	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	// setters - mutators
	public void setLength(int length) {
		if (length > 0 && length < 20) {
			this.length = length;
		} else {
			this.length = 1;
		}
	}

	public void setWidth(int width) {
		if (width > 0 && width < 20) {
			this.width = width;
		} else {
			this.width = 1;
		}
	}

	// toString method
	public String toString() {
		return "Rectangle (width = " + width + ", length = " + length + ")";
	}

} // end Rectangle
