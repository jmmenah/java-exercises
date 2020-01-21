// A class to represent marketers.
public class Marketer extends Employee {

    public Marketer(int years) {
        super(years);  // Calling superclass constructor
    }

    public void advertise() {
        System.out.println("Act now while supplies last!");
    }

    /*
    public double getSalary() {
        return 50000.0;      // $50,000.00 / year
    }
    */

    public double getSalary() {
        return super.getSalary() + 10000.0;
    }
}
