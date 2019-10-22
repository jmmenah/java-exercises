public class DayOfWeek {
    public static void main(String[] args) { 
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
	int y0 = y - (14 - m) / 12;
	int x = y0 + y0/4 - y0/100 + y0/400;
	int m0 = m + 12 * ((14 - m) / 12) - 2;
	int d0 = (d + x + (31*m0)/12) % 7;
	boolean isLeapYear = ( (y % 4 == 0) && ((y % 100 != 0) || (y % 400 == 0)) );
	if (y < 0) {
		System.out.println("Invalid year");
	}
	else if (m < 0 || m > 12){
		System.out.println("Invalid month");
	}
	else if ( d <=0 || d > 31 || ((m == 4 || m == 6 || m == 9 || m == 11 ) && d > 30)) {
		System.out.println("Invalid day");
	}
	else if ( (m == 2) && ( ) {
		System.out.println("Invalid day");
	}
	else {
		switch (d0) {
		    case 0:  System.out.println("Sunday");      break;
		    case 1:  System.out.println("Monday");      break;			    
		    case 2:  System.out.println("Tuesday");     break;
		    case 3:  System.out.println("Wednesday");   break;
		    case 4:  System.out.println("Thursday");    break;
		    case 5:  System.out.println("Friday");      break;
		    case 6:  System.out.println("Saturday");    break;
		    default: System.out.println("Invalid day"); break;
		}
	}
    }
}
