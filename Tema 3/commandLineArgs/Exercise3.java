/*
Write a program in Java to take two string values as command line argument and check for equality

Output examples:

$ javac Exercise3.java 
$ java Exercise3
Two strings required.

$ java Exercise3 Hello
Two strings required.

$ java Exercise3 Hello World
Strings are not equal.

$ java Exercise3 Hello hello
Strings are not equal.

$ java Exercise3 Hello Hello
Strings are equal.
*/

public class Exercise3 {
    public static void main(String[] args) {
    	int nlength = args.length;
    	if ( (nlength < 2) || (nlength >= 3) ){
    		System.out.println("You need two arguments.");
       	}
       	else {
       		String str1 = args[0];
       		String str2 = args[1];
       		if (str1.equals(str2) == true){
       			System.out.println("They are equals.");	
       		}
       		else {
       			System.out.println("They are not equals.");
       		}
       	}
    }
}