// Slides 69 - 76
// Another polymorphism problem

public class MainTest3 {

    public static void main(String[] args) {

	System.out.println("Example 1:");
        Snow var1 = new Sleet();
        var1.method2();

	System.out.println("Example 2:");
        Snow var2 = new Rain();
        // There is an error, because Snow does not have a method1
        // Compilation error
        // var2.method1();

	System.out.println("Example 3:");
        Snow var3 = new Rain();
        // There is an error because a Rain is not a Sleet
        // Execution error
        ((Sleet) var3).method3();
   }	
}


