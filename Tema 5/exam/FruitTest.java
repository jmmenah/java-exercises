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

