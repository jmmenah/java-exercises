// Driver class: uses Employee.class

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTest1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Employee> employeesList = new ArrayList<Employee>();

		Scanner input = new Scanner(new File("employees.csv"));

		int i = 1;

		while (input.hasNext()) {
			String line = input.nextLine();
			System.out.println(i++ + ": " + line);
			String[] emp = line.split(", ");
			Employee e = new Employee(emp[0], emp[1], Double.parseDouble(emp[2]), emp[3]);
			employeesList.add(e);
		}
		input.close();

		System.out.println();
		
		for (Employee e : employeesList) {
			System.out.println(e);
		}
	}
}
