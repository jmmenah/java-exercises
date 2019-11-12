/*
Write a method largestAbsVal that accepts three integers as parameters and returns the largest of their three absolute values. For example, a call of largestAbsVal(7, -2, -11) would return 11, and a call of largestAbsVal(-4, 5, 2) would return 5. 
*/
public static int largestAbsVal(int n1, int n2,int n3){
    return Math.max(Math.abs(n3),Math.max(Math.abs(n1),Math.abs(n2)));
}
