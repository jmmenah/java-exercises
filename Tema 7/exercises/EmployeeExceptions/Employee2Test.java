
// Driver class: uses Employee2.class

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee2Test {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Employee2> employeesList = new ArrayList<>();

        // try-with-resources Statement
        // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try (Scanner input = new Scanner(new File("employees.csv"))) {
            int i = 1;
            try {
                while (input.hasNext()) {
                    String line = input.nextLine();
                    System.out.println(i++ + ": " + line);
                    String[] emp = line.split(", ");
                    Employee2 e = new Employee2(emp[0], emp[1], Double.parseDouble(emp[2]), emp[3]);
                    employeesList.add(e);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: ArrayIndexOutOfBoundsException");
            } catch (NumberFormatException e) {
                System.out.println("Error: NumberFormatException");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
        }

        System.out.println();

        for (Employee2 e : employeesList) {
            System.out.println(e);
        }
    }
}
