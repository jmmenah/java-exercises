
/************************************
 * GeometricObject                   *
 *-----------------------------------*
 * -color: String                    *
 * -filled: boolean                  *
 * -dateCreated: java.util.Date      *
 *-----------------------------------*
 * +GeometricObject()                *
 * +GeometricObject(color: String,   *
 *	filled: boolean)                *
 * +getColor(): String               *
 * +setColor(color: String): void    *
 * +isFilled(): boolean              *
 * +setFilled(filled: boolean): void *
 * +getDateCreated(): java.util.Date *
 * +toString(): String               *
 ************************************/

// Implement GeometricObject class
public class GeometricObject {
    private String color = "white"; // The color of the object (default: white)
    private boolean filled;  // Indicates whether the object is filled with a color
    private java.util.Date dateCreated;  // date when the object was created

    /**
     * Construct a default geometric object
     */
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with the specified color
     * and filled value
     */
    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return colot
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean,
     * its getter method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Return a string representation of this object
     */
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }
}