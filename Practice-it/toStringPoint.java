/*
Add the following method to the Point class:

public String toString()

Make it return a string in the following format. For example, if a Point object stored in a variable pt represents the point (5, -17), return the string:

java.awt.Point[x=5,y=-17]

Your code is being added to the following class:

public class Point {

    int x;

    int y;

    

    // // your code goes here

    

}

(You don't need to write the class header or declare the fields; assume that this is already done for you. Just write your method's complete code in the box provided.)
*/
public String toString(){
    return "java.awt.Point[x="+x+",y="+y+"]";
}
