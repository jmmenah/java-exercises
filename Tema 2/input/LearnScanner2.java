import java.util.Scanner;

public class LearnScanner2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Hello " + name + ", How old are you? ");
        int age = input.nextInt();
        System.out.print("What is your weight in Kg? ");
        double weight = input.nextDouble();
        System.out.println(name + " is " + age + " year old and weighs " + weight + " kg");
    }
}
