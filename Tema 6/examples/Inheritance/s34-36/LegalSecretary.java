// A class to represent legal secretaries.
public class LegalSecretary extends Secretary {

    // slide 36
    // Modifying the constructor of the Secretary class
    // implies adding this parameterized constructor 
    public LegalSecretary(int years) {
        super(years);
    }

    public void fileLegalBriefs() {
        System.out.println("I could file all day!");
    }

    public double getSalary() {
	double baseSalary = super.getSalary();
	return baseSalary + 5000.0;
    }
    /*
    public double getSalary() {
        return 45000.0;      // $45,000.00 / year
    }
    */
}
