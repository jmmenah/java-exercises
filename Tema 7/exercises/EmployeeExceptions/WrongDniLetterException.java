// User defined exception 
// See Employee2 class and Employee2Test

@SuppressWarnings("serial")
public class WrongDniLetterException extends Exception {

    public WrongDniLetterException(String message) {
        super(message);
    }

}
