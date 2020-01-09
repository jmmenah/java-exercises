/*
Write a method maxLength that takes an ArrayList of Strings as a parameter and that returns the length of the longest string in the list. If your method is passed an empty list, it should return 0.
*/

public int maxLength(ArrayList<String> list) {
    int longest=0;
	for(int i=0;i<list.size();i++){
        if (list.get(i).length()>longest){
            longest=list.get(i).length();
        }
    }
    return longest;
}
