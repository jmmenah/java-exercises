/*
Write a method named isUnique that takes an array of integers as a parameter and that returns a boolean value indicating whether or not the values in the array are unique (true for yes, false for no). The values in the list are considered unique if there is no pair of values that are equal. For example, if a variable called list stores the following values:

int[] list = {3, 8, 12, 2, 9, 17, 43, -8, 46, 203, 14, 97, 10, 4};

Then the call of isUnique(list) should return true because there are no duplicated values in this list. If instead the list stored these values:

int[] list = {4, 7, 2, 3, 9, 12, -47, -19, 308, 3, 74};

Then the call should return false because the value 3 appears twice in this list. Notice that given this definition, a list of 0 or 1 elements would be considered unique.
*/
public static boolean isUnique(int[] list){
    if(list==null){
        return true;
    }
    boolean isUnique=true;
    for(int i=1;i<list.length-1;i++){
        for(int j=1;j<list.length-1;i++){
            if (list[i]==list[j]){
                return false;
            }
        }
    }
    return true;
}
