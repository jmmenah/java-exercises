// Design Patterns in Java: Singleton Pattern
// https://dragonprogrammer.com/design-patterns-java-singleton-pattern/#1-quick-and-dirty-implementation-with-lazy-instantiation

/*
 * First of all, observe that the constructor is marked as private. This means that from the outside, 
 * you can’t construct objects of this class.
 * 
 * Secondly, the singleton instantiates itself via the getInstance() static method. 
 * As this is a static method, it can be accessed from anywhere in your code.
 * 
 * Inside this method, we check if an instance of the singleton already exists. 
 * If that’s not the case, then we create it.
 * 
 * Subsequent calls to the getInstance() method return the same, previously created Singleton instance.
 * 
 * Furthermore, I’d like to point out that this is an example of lazy instantiation, 
 * as we’re delaying creating the object until we need it, i.e. when the getInstance() 
 * method is called the first time.
 * 
 * Call the singleton:
 * Singleton theSingleton = Singleton.getInstance();
 * 
 */

// Quick-and-Dirty Implementation with Lazy Instantiation

public class Singleton {
	private static Singleton instance;
	private String name;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		} else {
			System.out.println("Caution: \"" + instance + "\" object already exists!");
		}
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
