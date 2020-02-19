
public class Exercise5 {

	public static void main(String args[]) {
		String str = null;
		try{
			System.out.println(str.length());
		}
		catch(NullPointerException error){
			System.out.println("You can't get the length of a null string");//This exception occurs when you try to see the length of a null string
		}
	}

}
