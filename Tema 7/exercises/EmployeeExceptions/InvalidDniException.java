// User defined exception 
// See Employee2 class and Employee2Test

@SuppressWarnings("serial")
public class InvalidDniException extends Exception {

    public InvalidDniException(String message) {
        super(message);
    }

}
