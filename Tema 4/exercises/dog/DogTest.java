public class DogTest{
	public static void main(String[] args) {
		Dog[] dogs= new Dog[4];
		dogs[0]= new Dog("Milú",2);
		dogs[1]= new Dog("Snoopy",1);
		dogs[2]= new Dog("Idéfix",3);
		dogs[3]= new Dog("Pluto",5);

		System.out.println();
		System.out.println("Calling showDogs");
		System.out.println();
		showDogs(dogs);
		System.out.println();
		System.out.println("Calling showDogPersonYears");
		System.out.println();
		showDogPersonYears(dogs);
		System.out.println();
	}

	public static void showDogs(Dog[] dogs){
		for(int i=0;i<dogs.length;i++){
			System.out.println("Dog #"+(i+1)+": "+dogs[i]);
		}
	}

	public static void showDogPersonYears(Dog[] dogs){
		for(Dog dog : dogs){
			System.out.println(dog.getName()+": "+dog.personYears()+" person years");
		}
	}
}
