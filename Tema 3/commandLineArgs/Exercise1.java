/*
Write a program in Java to print the total number of arguments passed

Output examples:

$ javac Exercise1.java 
$ java Exercise1
Total number of arguments: 0

$ java Exercise1 Hello World
Total number of arguments: 2

$ java Exercise1 My name is Somebody Nowhere
Total number of arguments: 5
*/
public class Exercise1 {
	public static void main(String[] args) {
		int nlength = args.length;
		System.out.println("Total number of arguments: "+ nlength); 
	}
}