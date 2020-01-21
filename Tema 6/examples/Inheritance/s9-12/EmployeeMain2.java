public class EmployeeMain2 {
    public static void main(String[] args) {
        Employee empl = new Employee();
        Secretary sec = new Secretary();

        printInfo(empl);
        printInfo(sec);
    }

    public static void printInfo(Employee employee) {
        System.out.println("Form = " + employee.getVacationForm());
        System.out.println("Hours = " + employee.getHours());
        System.out.println("Salary = " + employee.getSalary());
        System.out.println("Vacations Days = " + employee.getVacationDays());
        System.out.println();
    }
}
