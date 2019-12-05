/*
(You should complete Self-Check 8.26 before answering this question. Go back to that exercise and copy/paste your solution here as a starting point.)

Add mutator methods called setFirstName, setMiddleInitial, and setLastName to your encapsulated version of the Name class from the last exercise. Give the parameters the same names as your fields, and use the keyword this in your solution.
*/
public class Name {
    private String firstName;
    private char middleInitial;
    private String lastName;
    public Name(String firstName, char middleInitial, String lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
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
	public void setFirstName ( String firstName ) {
       this.firstName=firstName;
    }
    public void setLastName ( String lastName ) {
       this.lastName=lastName;
    }
    public void setMiddleInitial ( char middleInitial ) {
       this.middleInitial=middleInitial;
    }
}
