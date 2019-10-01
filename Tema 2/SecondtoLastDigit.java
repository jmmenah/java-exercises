public class SecondtoLastDigit { 
    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
	int m =((n % 100)/10);
	System.out.println(m);
    }
}


