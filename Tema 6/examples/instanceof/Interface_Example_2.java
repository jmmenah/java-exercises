// instanceof Operator in Java
// https://codeprime.org/java-tutorials/operators-in-java/instanceof-operator-in-java/

// Reference of an interface type refering an object of a class that implements it, 
// is an instance of that class

interface Car{ }
 
class Audi implements Car { }
 
public class Interface_Example_2 {
    public static void main(String[] args){
        // c is a reference variable of interface type Car.
        // c refers to an object of class type Audi.
        Car c = new Audi();
        if(c instanceof Audi){
            System.out.println("c is an instance of Audi Class.");  // Output
        } else {
            System.out.println("c is not an instance of Audi Class.");
        }
    }
}
