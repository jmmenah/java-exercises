/*
Write a method called max that accepts an array of integers as a parameter and returns the maximum value in the array. For example, if the array passed stores {12, 7, -1, 25, 3, 9}, your method should return 25. You may assume that the array contains at least one element. Your method should not modify the elements of the array. 
*/
public int max(int [] numbers){
    int max=numbers[0];
    for(int i=0;i<numbers.length;i++){
        if(max<numbers[i]){
            max=numbers[i];
        }
    }
    return max;
}
