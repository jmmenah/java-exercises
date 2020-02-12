// Inheritance vs. Composition in Java 
// https://www.programcreek.com/2014/05/inheritance-vs-composition-in-java/

package composition;

public class CompositionTest {

	public static void main(String[] args) {
		Bee a = new Bee(1, "black", new AttackImpl("fly", "move"));
		a.attack();

		// if you need another implementation of move()
		// there is no need to change Insect, we can quickly use new method to attack

		Bee b = new Bee(1, "black", new AttackImpl("fly", "sting"));
		b.attack();
	}
}
