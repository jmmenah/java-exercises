public class StarFigureV7 {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            System.out.print(repeat("/", 20 - 4 * i));
            System.out.print(repeat("*", 8 * i - 8));
            System.out.print(repeat("\\", 20 - 4 * i));
            System.out.println();
        }

    }

    // https://gist.github.com/umidjons/10859940
    public static String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }
}
