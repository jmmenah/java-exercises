import java.util.Scanner;   // so you can use Scanner

public class StringOops {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Type your name: ");
        String name = console.next();
        process(name);
    }

    public static void process(String name) {
        if (name.equals("Whitaker")) {
            System.out.println("You must be really awesome.");
        }
        name = name.replace("a", "e");
        name = name.toUpperCase();
        name = name.substring(0, 3);
        System.out.println(name + " has " + name.length() + " letters");
    }
}

