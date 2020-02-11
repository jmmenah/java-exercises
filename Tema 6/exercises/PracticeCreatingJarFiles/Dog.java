// Dog class
// See DogTest.java

public class Dog {
	private int age;
	private String name;

	public Dog(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int dogPersonYears() {
		return age * 7;
	}
		
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
}
