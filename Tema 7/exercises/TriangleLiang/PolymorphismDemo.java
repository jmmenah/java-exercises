public class PolymorphismDemo {
    /**
     * Main method
     */
    public static void main(String[] args) {
        // Display circle and rectangle properties
        displayObject(new Circle(1, "red", false));
        displayObject(new Rectangle(1, 1, "black", true));
        displayObject(new Triangle(1, 2, 3));
    }

    /**
     * Display geometric object properties
     */
    public static void displayObject(GeometricObject object) {
        System.out.println("Created on " + object.getDateCreated() + ". Color is " + object.getColor());
    }
}