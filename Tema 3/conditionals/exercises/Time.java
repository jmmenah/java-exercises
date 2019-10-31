/*
Code  and upload a Java program Time.java that takes as arguments three integers:  h, m, s.
They contain hour, minutes and seconds respectively. Check if the time indicate is a valid time.
Execution examples:

$ java Time 
Please use:
 java Time h m s

$ java Time 18
Please use:
 java Time h m s

$ java Time 18 05 
Please use:
 java Time h m s

$ java Time 18 05 23
"18:05:23" is a Valid time

$ java Time 18 5 23
"18:05:23" is a Valid time

$ java Time 23 59 59
"23:59:59" is a Valid time

$ java Time 24 0 0
"Not valid time"

$ java Time 0 0 0
"00:00:00" is a Valid time

$ java Time 0 1 2
"00:01:02" is a Valid time

$ java Time 12 60 45
"Not valid time"

$ java Time -12 13 14
"Not valid time"
*/
public class Time {
	public static void main(String[] args) {
		int h= Integer.parseInt(args[0]);
		int m= Integer.parseInt(args[1]);
		int s= Integer.parseInt(args[2]);
		if (args.length < 3 || args.length > 3){
			System.out.printf("Please use:\n");
			System.out.printf("java Time h m s \n");
		}
		else if (h>23 || m>59 || s>59 || h<0 || m<0 || s<0) {
			System.out.printf("\"Not valid time\"\n");
		}
		else {
			System.out.printf("\"%02d:%02d:%02d\" is a Valid time\n",h,m,s);
		}

	}
}