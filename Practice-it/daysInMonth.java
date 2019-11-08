/*
 Write a method named daysInMonth that accepts a month (an integer between 1 and 12) as a parameter and returns the number of days in that month in this year. For example, the call daysInMonth(9) would return 30 because September has 30 days. Assume that the code is not being run during a leap year (that February always has 28 days).
Month 	1 Jan 	2 Feb 	3 Mar 	4 Apr 	5 May 	6 Jun 	7 Jul 	8 Aug 	9 Sep 	10 Oct 	11 Nov 	12 Dec
Days 	31 	28 	31 	30 	31 	30 	31 	31 	30 	31 	30 	31
*/
public static int daysInMonth(int month){
    int days;
        if (month == 1 || month == 3 || month == 5 || month == 7 ||month == 8 || month == 10 || month == 12 ){
            days = 31 ;
        }
        else if (month == 2){
            days = 28 ;
        }
        else {
            days = 30;
        }
        return days;
}
