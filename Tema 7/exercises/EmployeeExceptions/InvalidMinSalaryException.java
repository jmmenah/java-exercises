// User defined exception 
// See Employee2 class and Employee2Test

@SuppressWarnings("serial")
public class InvalidMinSalaryException extends Exception {

    public InvalidMinSalaryException(String message) {
        super(message);
    }

}
