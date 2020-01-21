// Slide 31
// Since Secretary doesn't require any parameters to its constructor, 
// LegalSecretary compiles without a constructor.
// Its default constructor calls the Secretary() constructor.

// A class to represent legal secretaries.
public class LegalSecretary extends Secretary {
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
