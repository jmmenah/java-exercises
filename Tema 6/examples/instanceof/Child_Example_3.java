// instanceof Operator in Java
// https://codeprime.org/java-tutorials/operators-in-java/instanceof-operator-in-java/

// An object_reference of Parent class referring a Child class object is an instance of Child class

class Flower { }
 
class Rose extends Flower{ }
 
public class Child_Example_3 {
    public static void main(String[] args){
        Flower f;
        Rose r = new Rose();
        // Assigning parent class reference with a child class object
        f = r;
        if(f instanceof Rose){
            System.out.println("f is an instance of Rose class.");  // Output
        } else {
            System.out.println("f is not an instance of Rose class.");
        }
    }
}
