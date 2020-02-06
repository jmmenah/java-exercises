// instanceof Operator in Java
// https://codeprime.org/java-tutorials/operators-in-java/instanceof-operator-in-java/

// An object of Child class is an instance of a Parent class

class Wood {}
 
class Firewood extends Wood {}
 
public class Child_Example_1 {
    public static void main(String [] args){
        Firewood firewood = new Firewood();
        // firewood is an object reference for child class Firewood.
        // Wood is the parent class
        if(firewood instanceof Wood){
            System.out.println("firewood is an instance of Wood class.");  // Output
        } else {
            System.out.println("firewood is not an instance of Wood class.");
        }
    }
}
