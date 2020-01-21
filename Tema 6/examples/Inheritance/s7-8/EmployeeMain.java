
public class EmployeeMain {
    public static void main(String[] args) {
        System.out.println("Employee:");
        Employee employee1 = new Employee();
        System.out.println("Form = " + employee1.getVacationForm());
        System.out.println("Hours = " + employee1.getHours());
        System.out.println("Salary = " + employee1.getSalary());
        System.out.println("Vacations Days = " + employee1.getVacationDays());
        System.out.println();
        
        System.out.println("Secretary:");
        Secretary employee2 = new Secretary();
        System.out.println("Form = " + employee2.getVacationForm());
        System.out.println("Hours = " + employee2.getHours());
        System.out.println("Salary = " + employee2.getSalary());
        System.out.println("Vacations Days = " + employee2.getVacationDays());
       
        employee2.takeDictation("Hello world");
    }
}
