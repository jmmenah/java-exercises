public class DaysWeek {
	static int dia() {
		int dias = 7;
        	int dia = (int) (Math.random() * dias) + 1;	
		return dia;
	}

	public static void main(String [] args) {
	int d = dia();
	String dayname="null";
		if (d == 1) {
			dayname = "Monday";
		}
		else if (d == 2) {
			dayname = "Tuesday";
		}
		else if (d == 3) {
			dayname = "Wednesday";
		}
		else if (d == 4) {
			dayname = "Thursday";
		}
		else if (d == 5) {
			dayname = "Friday";
		}
		else if (d == 6) {
			dayname = "Saturday";
		}
		else {
			dayname = "Sunday";
		} 
	System.out.println("\""+ dayname + "\" is the best day of the week");

	}
}
