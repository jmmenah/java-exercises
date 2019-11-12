/*
Write a method named lastDigit that returns the last digit of an integer. For example, lastDigit(3572) should return 2. It should work for negative numbers as well. For example, lastDigit(-947) should return 7. 
*/
public static int lastDigit(int number){
    return Math.abs(number % 10);
}
