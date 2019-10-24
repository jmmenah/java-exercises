    public static void printTriangleType(int a, int b, int c) {
        String triangletype;
			if (a == b && b == c)
			{
                triangletype="equilateral";
			}
			else if (a == b || b == c || a == c)
			{
                triangletype="isosceles";
			}
			else
			{
                triangletype="scalene";
			}
        System.out.println(triangletype);
	}
