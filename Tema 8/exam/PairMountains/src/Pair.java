// https://math.hws.edu/javanotes8/c10/s5.html

// https://www.codejava.net/java-core/collections/how-to-write-generic-classes-and-methods-in-java
// Just like the generic Map<K, V>, we declare more than one type parameter 
// when generifying a class. The type parameters are separated by commas.
// For example, the following class is declared with two type parameters to 
// represent a pair of things:

import java.io.Serializable;

public class Pair<T, U> implements Serializable {
	private static final long serialversionUID = 123456789L;

	T first;
	U second;

	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
}