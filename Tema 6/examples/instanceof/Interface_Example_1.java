// instanceof Operator in Java
// https://codeprime.org/java-tutorials/operators-in-java/instanceof-operator-in-java/

// object of a class that implements an interface is an instance of that interface

interface Cycle{ }
 
class BiCycle implements Cycle { }
 
public class Interface_Example_1 {
    public static void main(String[] args){
        // b is an instance of BiCycle Class
        // BiCycle class implements Cycle Interface
        BiCycle b = new BiCycle();
        if(b instanceof Cycle){
            System.out.println("b is an instance of Cycle Interface.");  // Output
        } else {
            System.out.println("b is not an instance of Cycle Interface.");
        }
    }
}
