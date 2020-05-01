
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintStream;
import java.lang.Exception;

public class Exercise1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a inpunt file name: ");
		String fileName = input.nextLine();
		input.close();
		int lines=0;

		File file = new File(fileName);

		try {
			PrintStream output = new PrintStream(new File("output.txt"));
		try{

			try (Scanner sc = new Scanner(file)) {
				while (sc.hasNextLine()) {
					lines++;
					if (lines%2==0) {
						output.println(sc.nextLine());
					}
					else{
						output.println(sc.nextLine().toUpperCase());
					}
					validate(lines);
				}
				System.out.println(lines+" lines copied");

			} catch (FileNotFoundException e) {
				System.out.println(fileName+" (No existe el archivo o el directorio)");
			}
		}catch(TwoLinesException m){
			System.out.println("Exception: Inputfile must have at least TWO Lines");
		}
	} catch (FileNotFoundException e1) {
			System.out.println(fileName+" (No existe el archivo o el directorio)");
		}

	}
	static void validate(int lines) throws TwoLinesException{
		if (lines <= 2) {
           		throw new TwoLinesException("Exception: Inputfile must have at least TWO Lines");
 		}
	}
}
class TwoLinesException extends Exception{  
 TwoLinesException(String s){  
  super(s);  
 }  
} 
