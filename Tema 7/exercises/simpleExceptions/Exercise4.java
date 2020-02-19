
public class Exercise4 {

	public static void main(String args[]) {

		String str = "Hello World!";
		System.out.println(str.length());
		char c = str.charAt(0);
		try{
			c = str.charAt(40);
		}
		catch(StringIndexOutOfBoundsException ob){
			System.out.println("There are less elements in the array");//This exception occurs when you try to cach a char at a position higher than the length of the string
		}
		finally{
			System.out.println(c);
		}
	}
}
