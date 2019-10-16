public class DistinctValues { 
	public static void main(String[] args) { 
       		int a = Integer.parseInt(args[0]);
        	int b = Integer.parseInt(args[1]);
        	int c = Integer.parseInt(args[2]);
			if (a == b && b == c)
			{
			System.out.println("There is only 1 distinct value.");
			}
			else if (a == b || b == c || a == c)
			{
			System.out.println("There are 2 distinct values.");
			}
			else
			{
			System.out.println("There are 3 distinct values.");
			}
	}
}
