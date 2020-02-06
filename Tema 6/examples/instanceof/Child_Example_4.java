// instanceof Operator in Java
// https://codeprime.org/java-tutorials/operators-in-java/instanceof-operator-in-java/

/* 
 * Downcasting with instanceof operator
 *
 * In case of member(variables and methods) overriding:
 *    - Data members of an object are accessed according to reference type, 
 *      while methods are accessed according to the referred object.
 *    - You will only notice the difference when an object reference of a parent class
 *      referes to an object of the child class.
 *
 */

/* Output
    m1.taste = Sweet
    ((Alphonso)m1).taste = Extra Sweet
*/

class Mango{
    String taste = "Sweet";
}
 
class Alphonso extends Mango{
    String taste = "Extra Sweet";
}
 
public class Child_Example_4 {
    public static void main(String[] args){
        Alphonso a = new Alphonso();
        Mango m1 = a;
        Mango m2 = new Mango();
        if(m1 instanceof Alphonso){
            System.out.println("m1.taste = " + m1.taste);
            System.out.println("((Alphonso)m1).taste= "+((Alphonso)m1).taste);
        }
        if(!(m2 instanceof Alphonso)){
            System.out.println("m2.taste = " + m2.taste);
            /*  If this test is not applied the casting (Alphonso)m2 would
                cause java.lang.ClassCastException.
            */
            // Down-casting Mango object to Alphonso
            System.out.println("((Alphonso)m2).taste= "+((Alphonso)m2).taste);
        }
    }
}
