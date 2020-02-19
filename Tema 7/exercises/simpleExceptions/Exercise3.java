
public class Exercise3 {

	public static void main(String args[]) {
		try{
			int num = Integer.parseInt("XYZ");
			System.out.println(num);
		}
		catch(NumberFormatException e){
			System.out.println("You can't parse to int a string");//This exception occurs when you try to parse to int a string
		}
	}

}
