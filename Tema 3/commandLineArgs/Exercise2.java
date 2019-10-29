/*
Write a program in Java to print all the arguments passed

Output examples:

$ javac Exercise2.java 
$ java Exercise2 My name is Somebody Nowhere
Total number of arguments: 5
Arguments:
Index: 0 Arg: My
Index: 1 Arg: name
Index: 2 Arg: is
Index: 3 Arg: Somebody
Index: 4 Arg: Nowhere
*/
public class Exercise2 {
    public static void main(String[] args) {
    	int nlength = args.length;
		System.out.println("Total number of arguments: "+ nlength);
        for(int i = 0; i < args.length; i++) {
            System.out.println("Index: "+i+" Arg: "+args[i]);
        }
    }
}