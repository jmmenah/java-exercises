// instanceof Operator in Java
// https://codeprime.org/java-tutorials/operators-in-java/instanceof-operator-in-java/

// An object of Parent class is not an instance of the Child class

class Animal{ }
 
class Cow extends Animal{ }
 
public class Child_Example_2 {
    public static void main(String[] args){
        Animal animal = new Animal();
        // animal is an instance of parent class Animal
        // Cow is the Child class
        if(animal instanceof Cow){
            System.out.println("animal is an instance of Cow class.");
        } else {
            System.out.println("animal is not an instance of Cow class.");  // Output
        }
    }
}
