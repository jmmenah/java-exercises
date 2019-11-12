// Only Java 11 +
// https://www.jdoodle.com/online-java-compiler/
public class StarFigureV8 {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            System.out.print("/".repeat(20 - 4 * i));
            System.out.print("*".repeat(8 * i - 8));
            System.out.print("\\".repeat(20 - 4 * i));
            System.out.println();
        }

    }
}
