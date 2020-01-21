public class EmployeeMain6 {
    public static void main(String[] args) {
        Employee[] employees = {new Employee(2), new Lawyer(4), new Marketer(3), 
				new Secretary(0), new LegalSecretary(0)};
        
        // print information about each employee
        for (int i = 0; i < employees.length; i++) {
            printInfo(employees[i]);
        }
    }
    public static void printInfo(Employee employee) {
        System.out.println("Form = " + employee.getVacationForm());
        System.out.println("Hours = " + employee.getHours());
        System.out.println("Salary = " + employee.getSalary());
        System.out.println("Vacations Days = " + employee.getVacationDays());
        System.out.println();
    }
}
