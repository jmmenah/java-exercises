public class StarFigureV6 {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            printRepeat("/", 20 - 4 * i);
            printRepeat("*", 8 * i - 8);
            printRepeat("\\", 20 - 4 * i);
            System.out.println();
        }

    }

    public static void printRepeat(String str, int times) {
        for (int i = 1; i <= times; i++) {
            System.out.print(str);
        }
    }
}
