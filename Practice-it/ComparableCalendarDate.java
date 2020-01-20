/*
 Suppose that a class CalendarDate has been defined for storing a calendar date with month, day and year components. (In our section handout, the class was called Date, but we have renamed it here because Practice-It uses a class named Date for other purposes.) The class includes the following members:
Name	Description
private int year 	the year component
private int month 	the month component
private int day 	the day component
public CalendarDate(int year, int month, int day) 	constructs a date with given year, month, day
public int getYear() 	returns the year component
public int getMonth() 	returns the month component
public int getDay() 	returns the day component
public String toString() 	returns the date in yyyy/mm/dd format

Your task is to modify the class to be Comparable by adding an appropriate compareTo method. Dates that occur chronologically earlier should be considered "less" than dates that occur later.

You may assume that dates are constructed with appropriate values: Months will be between 1 and 12, days will be between 1 and 31 and years will be four-digit numbers. Assume that the toString method produces a standard format with two digits for the month and two digits for the day, including leading zeros if necessary. For example, January 7th, 2005, would return the string "2005/01/07".
*/
public int compareTo(CalendarDate date) {
    if (year == date.year && month == date.month && day == date.day) {
        return 0;
    } else if (year == date.year && month == date.month && day > date.day) {
        return 1;
    } else if (year == date.year && month > date.month) {
        return 1;
    } else if (year > date.year) {
        return 1;
    } else {
        return -1;
    }
}
