//Mehtod that shows how many numbers are unique of 3.    
	public static int numUnique(int a, int b, int c) {
        int unique;
			if (a == b && b == c)
			{
                unique=1; //Only 1 number unique
			}
			else if (a == b || b == c || a == c)
			{
                unique=2; //2 numbers uniques
			}
			else
			{
                unique=3; //3 numbers uniques
			} 
        return unique;
	}
