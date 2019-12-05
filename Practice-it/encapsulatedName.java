/*
(You should complete Self-Check 8.7 before answering this question. You may also want to consult your solution to Self-Checks 8.11, 8.15, and 8.19.)

Encapsulate the Name class. Modify the existing code shown below to make its fields private, and add appropriate accessor methods to the class named getFirstName, getMiddleInitial, and getLastName.
*/
// A Name object represents a person's name such as "John Q. Public".
public class Name {
    private String firstName;
    private char middleInitial;
    private String lastName;
    
    public Name(String first, char middle, String last) {
        firstName = first;
        middleInitial = middle;
        lastName = last;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public char getMiddleInitial(){
        return middleInitial;
    }
}
