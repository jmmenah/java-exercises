// Driver class: uses Employee.class

import java.util.ArrayList;

public class EmployeeTest2 {

	public static void main(String[] args) {
		
		ArrayList<Employee> employeesList = new ArrayList<Employee>();

		employeesList.add(new Employee("Flora", "Campo Verde", 700, "98765432T"));
		employeesList.add(new Employee("Aurea", "Dorado Oro", 800, "12345678Z"));
		employeesList.add(new Employee("Leoncio", "Selva África", 900, "007Bond"));
		employeesList.add(new Employee("Ambrosio", "Dulce Amargo", 1000, "13579246W"));
		employeesList.add(new Employee("Luzmila", "Pardo Oscuro", 1500, "24681357K"));
		employeesList.add(new Employee("Delfina", "Peces del Mar", 2000, "12341234d"));
		employeesList.add(new Employee("Casimiro", "Vera Mira", 3000, "87654321X"));

		System.out.println();

		double totalMonthlySalary = 0;
		for (Employee e : employeesList) {
			System.out.println(e);
			totalMonthlySalary += e.getMonthlySalary();
		}

		System.out.println("\nTotal Monthly Salary = " + totalMonthlySalary + "€\n");

		for (Employee e : employeesList) {
			yearlySalary(e);
		}
	}

	public static void yearlySalary(Employee emp) {
		System.out.print("Yearly salary of \"" + emp.getLastName() + ", " + emp.getFirstName() + "\": ");
		System.out.println(emp.getMonthlySalary() * 12);
	}
}
