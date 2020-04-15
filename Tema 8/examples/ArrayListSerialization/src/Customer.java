/*
 * How to serialize and de-serialize ArrayList in Java
 * http://www.benchresources.net/how-to-serialize-and-de-serialize-arraylist-in-java/
 *
 * Serializing ArrayList<Customer>
 */

//package in.bench.resources.serialize.deserialize.arraylist;

import java.io.Serializable;

public class Customer implements Serializable {

    // SerialVersionUID
    private static final long serialVersionUID = 19L;

    // member variables
    private int customerId;
    private String customerName;
    private int customerAge;

    // 3-arg parameterized constructor
    public Customer(int customerId, String customerName, int customerAge) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAge = customerAge;
    }

    // overriding toString() method
    @Override
    public String toString() {
        return "Customer [" + "customerId=" + customerId + "," + " customerName=" + customerName + "," + " customerAge="
                + customerAge + "]";
    }
}