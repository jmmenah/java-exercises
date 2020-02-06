// instanceof Operator in Java
// https://codeprime.org/java-tutorials/operators-in-java/instanceof-operator-in-java/

// If the object_reference is assigned null, instanceof returns false

class Fruit {
    double price;
    Fruit(double p){
        price = p;
    }
}
 
public class Null_Example {
    public static void main(String[] args){
        Fruit f = new Fruit(120);
        f= null;
        // Testing whether f is an instance of Fruit class
        if(f instanceof Fruit){
            System.out.println("f is an instance of Fruit class.");
        } else {
            System.out.println("f is not an instance of Fruit class.");  // Output
        }
    }
}
