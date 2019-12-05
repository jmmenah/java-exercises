/*
Write a method called allLess that accepts two arrays of integers and returns true if each element in the first array is less than the element at the same index in the second array.

For example, if the two arrays passed are {45, 20, 300} and {50, 41, 600}, your method should return true. If the arrays are not the same length, you should return false.
*/
public boolean allLess(int [] numbers1, int [] numbers2){
    if (numbers1.length!=numbers2.length){
        return false;
    }
    int i=0;
    while(i<numbers1.length){
        if (numbers1[i]<numbers2[i]){
            i++;
        }
        else{
            return false;
        }
    }
    return true;
}
