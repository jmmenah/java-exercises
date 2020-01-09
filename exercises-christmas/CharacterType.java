// Read a character from command line and determine 
// whether the character entered is a capital letter, 
// a small case letter, a digit, a whitespace or a special symbol.

public class CharacterType {
    public static void main(String[] args) {

	if (args.length != 1) {
            System.out.println("Please, use: java CharacterType c");
            System.out.println("\twhere c is one character (or one string)\n");
         }
        else {
	    char c = args[0].charAt(0);  // first character from string
            System.out.print("\t'" + c + "' is a");

	    if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) System.out.println("n Uppercase Letter");
                else System.out.println(" Lowercase Letter");
            }
            else if (Character.isDigit(c)) System.out.println(" Digit");
                 else if (Character.isWhitespace(c)) System.out.println(" Whitespace");
                      else System.out.println(" character type different from letter, digit or space");  
        }  
    }
}
