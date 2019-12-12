/*
2.- Write a program NestedLoop.java that gets from command line one integer called size. The program output must be identical as shown in the examples below. (3,5 points)

Hint: use tab instead of spaces

Examples of execution:

$ java NestedLoop 1
1    

$ java NestedLoop 2
1 2 
2 4

$ java NestedLoop 3
1 2 3 
2 4 6 
3 6 9

$ java NestedLoop 5
1    2    3    4    5    
2    4    6    8    10    
3    6    9    12   15    
4    8    12   16   20    
5    10   15   20   25

$ java NestedLoop -12
Sorry! Valid size from 1 to 10

$ java NestedLoop 0
Sorry! Valid size from 1 to 10

$ java NestedLoop 22
Sorry! Valid size from 1 to 10

$ java NestedLoop 10
1    2     3    4    5     6     7     8     9     10    
2    4     6    8    10    12    14    16    18    20    
3    6     9    12   15    18    21    24    27    30    
4    8     12   16   20    24    28    32    36    40    
5    10    15   20   25    30    35    40    45    50    
6    12    18   24   30    36    42    48    54    60    
7    14    21   28   35    42    49    56    63    70    
8    16    24   32   40    48    56    64    72    80    
9    18    27   36   45    54    63    72    81    90    
10   20    30   40   50    60    70    80    90    100    
*/

public class NestedLoop{
	public static void main(String[] args) {
		int size=Integer.parseInt(args[0]);
		if(size<1||size>10){
			System.out.println("Sorry! Valid size from 1 to 10");
		}
		else{
			for(int i=1;i<=size;i++){
				for(int j=1;j<=size;j++){
					System.out.print((j*i)+"	");
				}
				System.out.println();
			}
		}
	}
}
