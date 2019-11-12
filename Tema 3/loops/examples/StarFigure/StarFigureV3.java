public class StarFigureV3 {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 32; j++) {

                if (i == 1) {
                    if (j <= 16) System.out.print("/");
                    else System.out.print("\\");
                } else if (i == 2) {
                    if (j <= 12) System.out.print("/");
                    else if (j <= 20) System.out.print("*");
                    else System.out.print("\\");
                } else if (i == 3) {
                    if (j <= 8) System.out.print("/");
                    else if (j <= 24) System.out.print("*");
                    else System.out.print("\\");
                } else if (i == 4) {
                    if (j <= 4) System.out.print("/");
                    else if (j <= 28) System.out.print("*");
                    else System.out.print("\\");
                } else System.out.print("*"); // i == 5

            }
            System.out.println();
        }
    }
}