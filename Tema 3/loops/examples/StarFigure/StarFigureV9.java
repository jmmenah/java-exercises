// Code by Javier Marcos Olmo

/*
         16/   \\16
	12/  8* \\12
	 8/ 16* \\8
	 4/ 24* \\4
	    32*
*/

public class StarFigureV9 {
    public static void main(String[] args) {

        int count1 = 16;
        int count2 = 0;
        for (int i = 1; i <= 5; i++) {
            slash(count1);
            asterisk(count2);
            backSlash(count1);
            count1 = count1 - 4;
            count2 = count2 + 8;
            System.out.println();
        }

    }

    public static void slash(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("/");
        }
    }

    public static void asterisk(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
    }

    public static void backSlash(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("\\");
        }
    }
}
