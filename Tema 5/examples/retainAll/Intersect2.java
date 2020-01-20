import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Intersect2 {
  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
    List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 9));
    
    List<Integer> newList = new ArrayList<>(list1);

    System.out.println("list1: " + list1);
    System.out.println("newList: " + newList);
    System.out.println("list2: " + list2);
    
    System.out.println("\nnewList.retainAll(list2)\n");

    newList.retainAll(list2);

    System.out.println("list1: " + list1);
    System.out.println("newList: " + newList);
    System.out.println("list2: " + list2);
  }
}

