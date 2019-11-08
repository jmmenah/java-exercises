/*
Suppose that you are trying to write a program that produces the following output using loops. The program below is an attempt at a solution, but it contains at least four major errors. Identify and fix them all.

1 3 5 7 9 11 13 15 17 19 21 
1 3 5 7 9 11 
*/
public static class BadNews {
    public static final int MAX_ODD = 21;
    int count;
        public static void writeOdds21() {
        // print each odd number
        for (int count = 1; count <= (MAX_ODD);count = count + 2) {
        System.out.print(count + " ");
        
        }
        }
        public static void writeOdds11() {
        // print each odd number
        for (int count = 1; count <= 11;count = count + 2) {
        System.out.print(count + " ");
        
        }
        }

    public static void main(String[] args) {
    // write all odds up to 21
    writeOdds21();
    System.out.println();
    writeOdds11();

    // now, write all odds up to 11
    }
}

