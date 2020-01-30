/*
2.- Modify the program Mystery.java so that it uses loops instead of the arraycopy method. Your solution should work in the same way as the one provided. (3,5 points)

Remember: you can't use the arraycopy method nor Arrays.copyOf and you must use loops.
*/

import java.util.Arrays;

public class Mystery {
    public static void main(String[] args) {

        int[] array1 = { 1, 2, 3, 4, 5, 6 };

        shiftArray(array1, 'R');

        System.out.println(Arrays.toString(array1));

        int[] array2 = { 10, 20, 30, 40, 50, 60 };

        shiftArray(array2, 'L');

        System.out.println(Arrays.toString(array2));
    }

    public static void shiftRight(int[] n) {
	int[] arrayaux= new int[n.length];
	arrayaux[0]=n[n.length-1];
	for(int i=1;i<n.length;i++){
		arrayaux[i]=n[i-1];
	}
	for(int i=0;i<n.length;i++){
		n[i]=arrayaux[i];
	}

    }

    public static void shiftLeft(int[] n) {
        int aux;
        for (int i=1; i<n.length; i++) {
            aux = n[i];
            n[i] = n[i-1];
            n[i-1] = aux;
        }
    }

    public static void shiftArray(int[] n, char direction) {
        if (n != null && n.length > 1) {
            if (direction == 'R')
                shiftRight(n);
            else if (direction == 'L')
                shiftLeft(n);
        }
    }
}
