// Building Java Programs: A Back to Basics Approach, 4th edition 
// by Stuart Reges and Marty Stepp
// http://www.buildingjavaprograms.com/

public class MethodsExample {
    public static void main(String[] args) {
        message1();
        message2();
        System.out.println("Done with main.");
    }

    public static void message1() {
        System.out.println("This is message1.");
    }

    public static void message2() {
        System.out.println("This is message2.");
        message1();
        System.out.println("Done with message2.");
    }
}