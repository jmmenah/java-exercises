/*
Code the next two programs and upload your Java source code.

1.- Complete the program FruitTest.java  that uses Fruit class Fruit.java. (7 points)

    Follow the instructions shown in the comments. 
    You are NOT allowed to modify the Fruit class except for:
        adding a toString method and
        complete the code of the method startsWithVowel

The output of the program must be identical to the one shown (pay attention to lower and upper case):

$ java FruitTest
 
Show List of Fruits:
Fruit #1: An Apple with "green" color
Fruit #2: An Apple with "red" color
Fruit #3: An Apple with "yellow" color
Fruit #4: A Banana with "yellow" color
Fruit #5: An Orange with "orange" color
Fruit #6: A Cherry with "red" color
Fruit #7: A Grape with "purple" color
Fruit #8: A Grape with "green" color
Fruit #9: A Peach with "yellow" color
Fruit #10: A Peach with "red" color

 RED fruits:
An Apple with "red" color
A Cherry with "red" color
A Peach with "red" color
Total = 3

 BROWN fruits:
Total = 0

 GREEN fruits:
An Apple with "green" color
A Grape with "green" color
Total = 2
*/

import java.util.ArrayList;

public class FruitTest {

  public static void main(String[] args) {

    // Complete the program
    ArrayList <Fruit> fruitsList = new ArrayList<Fruit>();
    fruitsList.add(new Fruit("Apple","green"));
    fruitsList.add(new Fruit("Apple","red"));
    fruitsList.add(new Fruit("Apple","yellow"));
    fruitsList.add(new Fruit("Banana","yellow"));
    fruitsList.add(new Fruit("Orange","orange"));
    fruitsList.add(new Fruit("Cherry","red"));
    fruitsList.add(new Fruit("Grape","purple"));
    fruitsList.add(new Fruit("Grape","green"));
    fruitsList.add(new Fruit("Peach","yellow"));
    fruitsList.add(new Fruit("Peach","red"));

    showFruits(fruitsList);
    System.out.println(); 
    showFruitsColor(fruitsList, "red");
    System.out.println(); 
    showFruitsColor(fruitsList, "brown");
    System.out.println(); 
    showFruitsColor(fruitsList, "green");
    fruitsList.get(0).toString();
  }

public static void showFruits(ArrayList<Fruit> fruitsList){
    System.out.println("Show List of Fruits:");
    int size=fruitsList.size();
	for(int i=0;i<size;i++){
		System.out.println("Fruit #"+(i+1)+": "+fruitsList.get(i).toString());
	}
}
public static void showFruitsColor(ArrayList<Fruit> fruitsList, String color){
    System.out.println(color.toUpperCase()+" fruits:");
    int count=0;
    for(Fruit fruit : fruitsList){
        if(fruit.getColor().equals(color)){
        System.out.println(fruit);
        count++;
        }
    }
    System.out.println("Total = "+count);     
}
  
}

