// https://introcs.cs.princeton.edu/java/11hello/UseArgument.java.html

/*
 *
 * Fixing UseArgument.java code to avoid exception
 *
 * java UseArgument
 * Hi, Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
 *	at UseArgument.main(UseArgument.java:20)
 *
 */

public class UseArgumentAvoidException {

    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Please use:\n java UseArgumentAvoidException name");
            System.exit(1);
        }

        System.out.print("Hi, ");
        System.out.print(args[0]);
        System.out.println(". How are you?");
    }
}
