// Inheritance vs. Composition in Java 
// https://www.programcreek.com/2014/05/inheritance-vs-composition-in-java/

package inheritance;

public class InheritanceTest {
	public static void main(String[] args) {
		Insect i = new Bee(1, "red");
		i.attack();
	}
}