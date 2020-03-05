// refactor countOccurrences method using a Single Generic Method 

public class CountOcurrences {

	public static void main(String[] args) {
		String[] names = { "Mary", "Paul", "Susan", "John", "Susan", "James", "Mary", "Paul", "Mary", "Lisa", "Paul",
				"John" };
		int count = countOccurrences(names, "Mary");
		System.out.println("#occurrences of Mary: " + count);

		Integer[] integers = { 1, 0, 2, 1, 0, 0, 7, 8, 0, 1, 2, 0, 1, 0, 3, 0, 0 };
		count = countOccurrences(integers, 0);
		System.out.println("#occurrences of zeros: " + count);

		Car[] cars = new Car[6];
		cars[0] = new Car("Seat León", "blue");
		cars[1] = new Car("BMW X2", "red");
		cars[2] = new Car("Seat León", "blue");
		cars[3] = new Car("BMW X2", "red");
		cars[4] = new Car("Seat León", "blue");
		cars[5] = new Car("BMW X2", "yellow");

		Car myCar = new Car("BMW X2", "red");

		count = countOccurrences(cars, myCar);
		System.out.println("#occurrences of myCar: " + count);

	}

	// https://math.hws.edu/javanotes8/c10/s5.html#generics.5.2
	// https://howtodoinjava.com/java/generics/complete-java-generics-tutorial/
	// https://www.codejava.net/java-core/collections/how-to-write-generic-classes-and-methods-in-java

	/**
	 * Returns the number of times that itemToCount occurs in list. Items in the
	 * list are tested for equality using itemToCount.equals(), except in the
	 * special case where itemToCount is null.
	 */
	// counting item in array of String

	public static <T> int countOccurrences(T[] list,T itemToCount){
		int count = 0;
		if (itemToCount == null) {
			for (T listItem : list)
				if (listItem == null)
					count++;
		} else {
			for (T listItem : list)
				if (itemToCount.equals(listItem))
					count++;
		}
		return count;	
	}
/*
	public static int countOccurrences(String[] list, String itemToCount) {
		int count = 0;
		if (itemToCount == null) {
			for (String listItem : list)
				if (listItem == null)
					count++;
		} else {
			for (String listItem : list)
				if (itemToCount.equals(listItem))
					count++;
		}
		return count;
	}

	// counting item in array of Integer
	public static int countOccurrences(Integer[] list, Integer itemToCount) {
		int count = 0;
		if (itemToCount == null) {
			for (Integer listItem : list)
				if (listItem == null)
					count++;
		} else {
			for (Integer listItem : list)
				if (itemToCount.equals(listItem))
					count++;
		}
		return count;
	}

	// counting item in array of Car
	public static int countOccurrences(Car[] list, Car itemToCount) {
		int count = 0;
		if (itemToCount == null) {
			for (Car listItem : list)
				if (listItem == null)
					count++;
		} else {
			for (Car listItem : list)
				if (itemToCount.equals(listItem))
					count++;
		}
		return count;
	}
*/
}
class Car {
	private String model;
	private String color;

	Car(String model, String color) {
		this.model = model;
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		Car other = (Car) obj;
		return model.equals(other.model) && color.equals(other.color);
	}
}
