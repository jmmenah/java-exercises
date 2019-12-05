/*
Write a method isPalindrome that accepts an array of Strings as its argument and returns true if that array is a palindrome (if it reads the same forwards as backwards) and false if not. For example, the array {"alpha", "beta", "gamma", "delta", "gamma", "beta", "alpha"} is a palindrome, so passing that array to your method would return true. Arrays with zero or one element are considered to be palindromes. 
*/
public static boolean isPalindrome (String[] array){
    if (array.length == 0 || array.length == 1){
        return true;
    }
    int start = 0;
    int end = array.length -1;
    while (end>=start) {
        if (!array[start].equals(array[end])){
            return false;
        }
        start++;
        end--;
    }
    return true;
}
