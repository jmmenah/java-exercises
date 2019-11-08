/*
Write a method called zeroDigits that accepts an integer parameter and returns the number of digits in the number that have the value 0. For example, the call zeroDigits(5024036) should return 2, and zeroDigits(743) should return 0. The call zeroDigits(0) should return 1. You may assume that the integer is non-negative. (We suggest you use a do/while loop in your solution.) 
*/
public static int zeroDigits(int number) {
    int count = 0;
    do {
        if (number % 10 == 0) {
            count++;
        }
        number = number / 10;
    } while (number > 0);
    return count;
}
