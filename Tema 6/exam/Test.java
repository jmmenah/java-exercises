import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// Create an ArrayList for the employees
		ArrayList<Employee> employees = new ArrayList<Employee>();

		
		// Adding employees to the ArrayList

		employees.add(new Programmer("James", "Gosling", stringToLocalDate("19-05-1955"), 3000, "Java"));
		employees.add(new Programmer("Guido", "van Rossum", stringToLocalDate("31-01-1956"), 3100, "Python"));
		employees.add(new DatabasePro("Michael", "Widenius", stringToLocalDate("03-03-1962"), 3200, "MySQL"));
		employees.add(new Programmer("Rasmus", "Lerdorf", stringToLocalDate("22-11-1968"), 3300, "PHP"));
		employees.add(new DatabasePro("Michael", "Stonebraker", stringToLocalDate("11-10-1943"), 3400, "PostgreSQL"));
		employees.add(new Programmer("Bjarne", "Stroustrup", stringToLocalDate("30-12-1950"), 3500, "C++"));
		
		// using a for loop 
        for (int x = 0; x < employees.size(); x++) {
        	System.out.println((x+1)+"-"+employees.get(x));
        	System.out.println();
        }
		
		// using a for each loop
		for(Employee e : employees){
        	if(e instanceof Programmer){
        		Programmer pro = (Programmer) e;
        		System.out.println(e.getLastName().toUpperCase()+", "+e.getFirstName()+" => Programming language = "+ pro.getLanguage());
        	}
        	if(e instanceof DatabasePro){
        		DatabasePro data = (DatabasePro) e;
        		System.out.println(e.getLastName().toUpperCase()+", "+e.getFirstName()+" => Database = "+ data.getDatabase());
        	}
        }
	}

	// s must have the format dd-MM-yyyy
	public static LocalDate stringToLocalDate(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(s, formatter);

		return date;
	}
}
