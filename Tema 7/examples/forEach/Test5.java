/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.ArrayList;
import java.util.List;

// A slightly more complex example using forEach() method with List

class Animal {
    private String SpeciesName;
    private String type;

    public Animal(String SpeciesName, String type) {
        this.SpeciesName = SpeciesName;
        this.type = type;
    }

    public String getSpeciesName() {
        return SpeciesName;
    }

    public void setSpeciesName(String speciesName) {
        SpeciesName = speciesName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

// Consider a list of Animal objects.
// Each Animal object contains a name and a type.
// The requirement is to extract only farm animals from the list and put them in a separate list.

public class Test5 {

    public static List<String> getFarmAnimals(List<Animal> animals) {
        //A list to store only farm animal names
        List<String> farmAnimals = new ArrayList<>();

        //loop through the Animal list
        animals.forEach(animal -> {
            if (animal.getType() != null && "Farm".equals(animal.getType())) {
                //extract only farm animal names
                farmAnimals.add(animal.getSpeciesName());
            }
        });
        //return farm animal names
        return farmAnimals;
    }

    public static void main(String[] args) {
        //create the input Animal list
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", "Domestic"));
        animals.add(new Animal("Tiger", "Wild"));
        animals.add(new Animal("Goat", "Farm"));
        animals.add(new Animal("Cow", "Farm"));

        System.out.println("The Farm Animals are: ");
        //get only farm animal names from getFarmAnimal() method
        List<String> farmAnimals = getFarmAnimals(animals);

        if (farmAnimals != null && !farmAnimals.isEmpty()) {
            //loop through farm animal names returned and print them using forEach() method
            farmAnimals.forEach(farmAnimal -> System.out.println(farmAnimal));
        }
    }
}