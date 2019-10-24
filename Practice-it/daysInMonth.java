//Method that shows the days that has one month
public static int daysInMonth(int month){
    int days;
        if (month == 1 || month == 3 || month == 5 || month == 7 ||month == 8 || month == 10 || month == 12 ){
            days = 31 ; //Months that have 31 days
        }
        else if (month == 2){
            days = 28 ; //February
        }
        else {
            days = 30; //Days with 30 days
        }
        return days;
}
