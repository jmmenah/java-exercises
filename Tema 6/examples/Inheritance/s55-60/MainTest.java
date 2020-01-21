// Slides 57 - 60
// A polymorphism problem

public class MainTest {

    public static void main(String[] args) {

	Foo[] pity = {new Baz(), new Bar(), new Mumble(), new Foo()};
	for (int i = 0; i < pity.length; i++) {
	    System.out.println(pity[i]);
	    pity[i].method1();
	    pity[i].method2();
	    System.out.println();
	}
   }	
}


