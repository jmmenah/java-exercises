// Slides 25 - 26, 33
// Modified Employee class

public class Employee {

    private int years;

    // When an Employee object is constructed, 
    // we'll pass in the number of years the person has been with the company.
    public Employee(int initialYears) {
        years = initialYears;
    }
    
    // slide 33
    // Add an accessor for any field needed by the subclass.
    public int getYears() {
        return years;
    }

    public int getHours() {
        return 40;           // works 40 hours / week
    }
    
    public double getSalary() {
        return 50000.0;      // $50,000.00 / year
    }
    
    // 2 weeks' paid vacation
    // For each year worked, we'll award 2 additional vacation days.
    public int getVacationDays() {
        return 10 + 2 * years; 
    }

    public String getVacationForm() {
        return "yellow";     // use the yellow form
    }
}
