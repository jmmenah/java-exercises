// See: Singleton.java

public class TestSingleton {

	public static void main(String[] args) {

		Singleton theSingleton = Singleton.getInstance();

		theSingleton.setName("I am the only one!");
		System.out.println(theSingleton);
		System.out.println(theSingleton.getName());

		Singleton otherSingleton = Singleton.getInstance();
		theSingleton.setName("I am unique!");
		System.out.println(otherSingleton);
		System.out.println(otherSingleton.getName());

		System.out.println(theSingleton.getName());
	}
}
