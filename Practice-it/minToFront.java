/*
Write a method minToFront that takes an ArrayList of integers as a parameter and that moves the minimum value in the list to the front, otherwise preserving the order of the elements. For example, if a variable called list stores the following values: {3, 8, 92, 4, 2, 17, 9} and you make this call: minToFront(list); it should store the following values after the call: {2, 3, 8, 92, 4, 17, 9} You may assume that the list stores at least one value. 
*/
public void minToFront(ArrayList<Integer> list) {
    int min=list.get(0);
	for(int i=1;i<list.size();i++){
        if(min>list.get(i)){
            min=list.get(i);
        }
    }
    int index=list.indexOf(min);
    int temp=list.get(index);
    list.remove(index);
    list.add(0,min);
}
