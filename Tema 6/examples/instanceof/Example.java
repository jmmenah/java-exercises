// instanceof Operator in Java
// https://codeprime.org/java-tutorials/operators-in-java/instanceof-operator-in-java/

/*
 * instanceof operator is used to check whether a reference variable (an object) is an instance 
 * of a specific class or interface. 
 * Syntax to use instanceof is: Object_reference instanceof type
 *
 *    - type can be a class name or even an interface name.
 *    - The return type is a boolean value, true or false.
 *
 */

class Vehicle {
    int wheels;
    Vehicle(int v){
        wheels = v;
    }
}
 
public class Example {
    public static void main(String[] args){
        Vehicle v = new Vehicle(4);
        // Testing whether v is an instance of vehicle class
        if(v instanceof Vehicle){
            System.out.println("v is an instance of Vechicle class.");  // Output
        } else {
            System.out.println("v is not an instance of Vechicle class.");
        }
    }
}
