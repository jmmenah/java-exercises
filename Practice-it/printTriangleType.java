// A method that show the type of triangle with the sides    
	public static void printTriangleType(int a, int b, int c) {
        String triangletype;
			if (a == b && b == c)
			{
                triangletype="equilateral"; //All sides equal
			}
			else if (a == b || b == c || a == c)
			{
                triangletype="isosceles"; //Two equal sides
			}
			else
			{
                triangletype="scalene"; //Three different sides
			}
        System.out.println(triangletype);
	}
