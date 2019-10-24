    public static int numUnique(int a, int b, int c) {
        int unique;
			if (a == b && b == c)
			{
                unique=1;
			}
			else if (a == b || b == c || a == c)
			{
                unique=2;
			}
			else
			{
                unique=3;
			}
        return unique;
	}
