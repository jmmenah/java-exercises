package main.java.inheritance;

public class MainClass {
	public static void main(String[] args) {
		Animal animal = new Animal();
		Bird bird = new Bird();
		Dog dog = new Dog();
		
		System.out.println();
		
		animal.sleep();
		animal.eat();
		
		bird.sleep();
		bird.eat();
		
		dog.sleep();
		dog.eat();
		
		Animal a1 = new Dog();
		Animal a2 = new Bird();
		
		a1.eat();
		a2.sleep();
		
		// The following statements are incorrect.
		// Dog d = new Animal();
		// Bird b = new Animal();
	}
}
