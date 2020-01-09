// Read a character from command line and determine 
// whether the character entered is a capital letter, 
// a small case letter, a digit, a whitespace or a special symbol.

// regular expressions

public class CharacterTypeb {
    public static void main(String[] args) {

	if (args.length != 1) {
            System.out.println("Please, use: java CharacterTypeb c");
            System.out.println("\twhere c is one character (or one string)\n");
         }
        else {
	    char c = args[0].charAt(0);  // first character from string
            String s = String.valueOf(c);
            System.out.print("\t'" + c + "' is a");
            // boolean isLetter = s.matches("[a-zA-Z]{1}");
                                          // [a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{1}
            boolean isCapitalLetter = s.matches("[A-ZÑÁÉÍÓÚÜ]{1}");
            boolean isSmallLetter = s.matches("[a-zñáéíóúü]{1}");
            boolean isDigit = s.matches("\\d{1}"); 

            if (isCapitalLetter) System.out.println("n Uppercase Letter");
            else if (isSmallLetter) System.out.println(" Lowercase Letter");
                 else if (isDigit) System.out.println(" Digit");
                      else if (Character.isWhitespace(c)) System.out.println(" Whitespace");
                           else System.out.println(" character type different from letter, digit or space");  
        }  
    }
}
