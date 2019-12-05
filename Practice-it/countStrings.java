/*
Write a method countStrings that takes an array of Strings and a target String and returns the number of occurences target appears in the array. 
*/
public static int countStrings(String[] list, String target) {
    int count=0;
    for (int i=0;i<list.length;i++) {
        if (list[i].equals(target)){
            count++;
        }
    }
    return count;
}
