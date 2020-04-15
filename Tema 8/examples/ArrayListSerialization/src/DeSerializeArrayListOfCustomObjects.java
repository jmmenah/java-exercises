/*
 * How to serialize and de-serialize ArrayList in Java
 * http://www.benchresources.net/how-to-serialize-and-de-serialize-arraylist-in-java/
 *
 * This class de-serializes list of custom Java objects, which is serialized from above Customer POJO
 */

// package in.bench.resources.serialize.deserialize.arraylist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DeSerializeArrayListOfCustomObjects {

    public static void main(String[] args) {

        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        // creating List reference to hold AL values after de-serialization
        List<Customer> listOfCustomers = null;

        try {
            // reading binary data
            fis = new FileInputStream("ArrayListOfCustomer.ser");

            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);

            // reading object's value and casting ArrayList<Customer>
            listOfCustomers = (ArrayList<Customer>) ois.readObject();
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }

        System.out.println("ArrayList object de-serialized from "
                + "ArrayListOfCustomer.ser file\n");

        // iterating & printing ArrayList values to console
        for(Customer customer : listOfCustomers){
            System.out.println(customer);
        }
    }
}