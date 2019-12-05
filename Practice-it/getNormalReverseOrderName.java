/*
(You should complete Self-Check 8.7 before answering this question.)

Add two new methods to the Name class:

public String getNormalOrder()

Returns the person's name in normal order, with the first name followed by the middle initial and last name. For example, if the first name is "John", the middle initial is 'Q', and the last name is "Public", this method returns "John Q. Public".

public String getReverseOrder()

Returns the person's name in reverse order, with the last name preceding the first name and middle initial. For example, if the first name is "John", the middle initial is 'Q', and the last name is "Public", this method returns "Public, John Q.".

(You don't need to write the class header or declare the fields; assume that this is already done for you. Just write your two methods' complete code in the box provided.)
*/
public String getNormalOrder(){
    return firstName+" "+middleInitial+". "+lastName;
}
public String getReverseOrder(){
    return lastName+", "+firstName+" "+middleInitial+".";
}
