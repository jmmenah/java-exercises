import java.io.*;

public class Test2
{
    public static void main(String[] args) throws IOException
    {
        Reader in = new BufferedReader(new FileReader(args[0]));
        int intRead;
        String word = "";
        int wordCount = 0;
        while((intRead = in.read()) != -1)
        {
            if (Character.isLetter((char) intRead))
                word += (char) intRead;
            else
	    {
                if (word.equals(args[1]))
                {
                    wordCount++;
                }
                word = "";
            }
        }
        if (word.equals(args[1]))
            wordCount++;

        in.close();        
        System.out.println("The word '" + args[1] + "' occurred " + wordCount +
                           " times");
    }
}