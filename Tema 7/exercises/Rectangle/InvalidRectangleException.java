// User defined exception 

@SuppressWarnings("serial")
public class InvalidRectangleException extends Exception {

    public InvalidRectangleException(String message) {
        super(message);
    }

}
