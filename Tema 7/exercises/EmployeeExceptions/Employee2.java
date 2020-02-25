// Employee2 class

// See Employee2Test.java

public class Employee2 {
    // Fields - State
    private static final double MIN_SALARY = 900;
    private String firstName;
    private String lastName;
    private double monthlySalary;
    private String dni;

    // parameterized constructor
    public Employee2(String firstName, String lastName, double monthlySalary, String dni) {
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            setMonthlySalary(monthlySalary);
        } catch (InvalidMinSalaryException e) {
            System.out.println(e.getMessage());
            System.out.println("Fixing monthlySalary = " + MIN_SALARY + "\n");
        }

        try {
            setDni(dni);
        } catch (InvalidDniException e) {
            this.dni = "unknown";
            System.out.println(e.getMessage());
            System.out.println("It can not be fixed :-(\n");

        } catch (WrongDniLetterException e) {
            System.out.println(e.getMessage());
            System.out.println("Fixing. Changed to: " + this.dni + "\n");
        }
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

    public void setMonthlySalary(double monthlySalary) throws InvalidMinSalaryException {
        // this.monthlySalary = monthlySalary < MIN_SALARY ? MIN_SALARY : monthlySalary;

        if (monthlySalary < MIN_SALARY) {
            this.monthlySalary = MIN_SALARY;
            throw new InvalidMinSalaryException("Exception: wrong Salary " + monthlySalary);

        } else {
            this.monthlySalary = monthlySalary;
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws InvalidDniException, WrongDniLetterException {
        dni = dni.toUpperCase();
        // regular expression for any number followed by one character
        if (dni.matches("[0-9]+.")) {

            if (isCorrectLetter(dni)) {
                this.dni = dni;
            } else {
                this.dni = dni.substring(0, dni.length() - 1) + calculateLetter(dni);
                throw new WrongDniLetterException("Exception: wrong letter " + dni);
            }
        } else {
            throw new InvalidDniException("Exception: wrong DNI " + dni);
        }

    }

} // end Employee