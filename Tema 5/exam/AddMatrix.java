/*
2.- Complete the static methods addTotal and addColumn in the program AddMatrix.java.  (3 points)
*/
public class AddMatrix {

    public static void main(String[] args){

      int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};

      int[][] matrix2 = {{1,2},{3,4},{5,6},{7,8}};

      // adding all elements
      System.out.println(addTotal(matrix1));  // prints 45
      System.out.println(addTotal(matrix2));  // prints 36
    
      // adding only the provided column 
      System.out.println(addColumn(matrix1, 0));  // prints 12
      System.out.println(addColumn(matrix2, 1));  // prints 20
    }
    public static int addTotal(int[][] matrix){
      int sum=0;
      for(int i=0; i<matrix.length;i++){
        for(int j=0; j<matrix[0].length;j++){
          sum=sum+matrix[i][j];
        }
      }
      return sum;
    }
    public static int addColumn(int[][] matrix, int column){
      int sum=0;
        for(int i=0; i<matrix.length;i++){
          sum=sum+matrix[i][column];
      }
      return sum;
    }  
}
