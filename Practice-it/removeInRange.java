/*
Write a method called removeInRange that accepts four parameters: an ArrayList of integers, an element value, a starting index, and an ending index. The method's behavior is to remove all occurrences of the given element that appear in the list between the starting index (inclusive) and the ending index (exclusive). Other values and occurrences of the given value that appear outside the given index range are not affected.

For example, for the list [0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16], a call of removeInRange(list, 0, 5, 13); should produce the list [0, 0, 2, 0, 4, 6, 8, 10, 12, 0, 14, 0, 16]. Notice that the zeros located at indices between 5 inclusive and 13 exclusive in the original list (before any modifications were made) have been removed.
*/
public static void removeInRange(ArrayList<Integer> list, int value, int min, int max) {
	for(int i=min;i<max;i++){
        if(value==list.get(i)){
            list.remove(i);
            i--;
            max--;
        }
    }
}
