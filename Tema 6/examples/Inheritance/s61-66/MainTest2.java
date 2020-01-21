// Slides 61 - 66
// Another polymorphism problem

public class MainTest2 {

    public static void main(String[] args) {

	Ham[] food = {new Lamb(), new Ham(), new Spam(), new Yam()};
	for (int i = 0; i < food.length; i++) {
	    System.out.println(food[i]);
	    food[i].a();
	    System.out.println();     // to end the line of output
	    food[i].b();
	    System.out.println();     // to end the line of output
	    System.out.println();
	}
   }	
}


