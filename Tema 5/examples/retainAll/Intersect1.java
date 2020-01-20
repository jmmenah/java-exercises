import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Intersect1 {
  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new ArrayList<Integer>();
 
    int a1[] = {1, 2 ,3 ,4, 5, 6};
    int a2[] = {5, 6, 7, 8, 9};

    for (int n : a1) list1.add(n);

    for (int n : a2) list2.add(n);
    
    System.out.println("list1: " + list1);
    System.out.println("list2: " + list2);
    
    System.out.println("\nlist1.retainAll(list2)\n");

    list1.retainAll(list2); 
    
    System.out.println("list1: " + list1);
    System.out.println("list2: " + list2);
  }
}

