// Employee class
// See EmployeeTest1.java, EmployeeTest2.java

public class Employee {
    // Fields - State
    private static final double MIN_SALARY = 900;
    private String firstName;
    private String lastName;
    private double monthlySalary;
    private String dni;

    // parameterized constructor
    public Employee(String firstName, String lastName, double monthlySalary, String dni) {
        this.firstName = firstName;
        this.lastName = lastName;
        setMonthlySalary(monthlySalary);
        setDni(dni);
    }

    // Methods - Behaviour

    public char calculateLetter(int dni) {
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letters.charAt(dni % 23);
    }

    public char calculateLetter(String dni) {
        return calculateLetter(Integer.parseInt(dni.substring(0, dni.length() - 1)));
    }

    public boolean isCorrectLetter(String dni) {
        return dni.charAt(dni.length() - 1) == calculateLetter(dni);
    }

    // toString method
    @Override
    public String toString() {
        return "[" + firstName + " " + lastName + ", " + monthlySalary + "€, dni=" + dni + "]";
    }


    // getters - setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        // this.monthlySalary = monthlySalary < MIN_SALARY ? MIN_SALARY : monthlySalary;

        if (monthlySalary < MIN_SALARY) {
            this.monthlySalary = MIN_SALARY;
        } else {
            this.monthlySalary = monthlySalary;
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        dni = dni.toUpperCase();
        // regular expression for any number followed by one character
        if (dni.matches("[0-9]+.")) {

            if (isCorrectLetter(dni)) {
                this.dni = dni;
            } else {
                System.out.println("Warning: wrong letter " + dni);
                this.dni = dni.substring(0, dni.length() - 1) + calculateLetter(dni);
                System.out.println("Changed to: " + this.dni);
            }
        } else {
            System.out.println("Warning: wrong DNI " + dni);
            this.dni = "unknown";
        }

    }

} // end Employee