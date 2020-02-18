//  Building Java Programs: A Back to Basics Approach, 4th edition by Stuart Reges and Marty Stepp
//  http://www.buildingjavaprograms.com/code-files/4ed/
//  chapter 4

public class CauseException {
    public static void main(String[] args) {
        int x = 1 / 0;
        System.out.println(x);
    }
}
