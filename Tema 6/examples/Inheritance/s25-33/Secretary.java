// Slide 31
// Modified Secretary class

// A class to represent secretaries.
public class Secretary extends Employee {
    
    public Secretary() {
        super(0);
    }
    
    public void takeDictation(String text) {
        System.out.println("Taking dictation of text: " + text);
    }
}
