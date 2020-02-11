// Driver class: uses Dog.class

public class DogTest {
	public static void main(String[] args) {
		// Create array of Dog objects
		Dog[] dogs = new Dog[4];

		// Initialize array of Dog using constructor
		
		dogs[0] = new Dog(7,"Milú");
		dogs[1] = new Dog(1,"Patán");
		dogs[2] = new Dog(3,"Idéfix");
		dogs[3] = new Dog(5,"Pluto");
		
		dogs[0].setAge(2);
		dogs[1].setName("Snoopy");

		System.out.println("\nCalling showDogs");
		showDogs(dogs);
		
		System.out.println("\nCalling showDogPersonYears");
		showDogPersonYears(dogs);

	} // end main

	// using for loop
	public static void showDogs(Dog[] dog) {
		for (int i = 0; i < dog.length; i++) {
			System.out.print("Dog #" + (i + 1) + ": ");
			System.out.println(dog[i]);
		}
	} // end showDogs

	// using for-each loop
	public static void showDogPersonYears(Dog[] dog) {
		for (Dog d : dog) {
			System.out.println(d.getName() + ": "+ d.dogPersonYears() + " person years");
		}
	} // end showDogPersonYears
} // end DogTest
