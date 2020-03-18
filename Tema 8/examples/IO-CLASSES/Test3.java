import java.io.*;
import java.util.*;

public class Test3
{
    public static void main(String[] args) throws IOException
    {
        Reader in = new BufferedReader(new FileReader(args[0]));
        int intRead;
        String word = "";
        Set<String> wordSet = new HashSet<String>();
        while((intRead = in.read()) != -1)
        {
            if (Character.isLetter((char) intRead))
            {
                word += (char) intRead;
            }
            else
            {
                if (!word.equals(""))
                {
                    wordSet.add(word.toLowerCase());
                }
                word = "";
            }
        }
        if (!word.equals(""))
        {
            wordSet.add(word.toLowerCase());
        }
        in.close();        
        System.out.println("There are " + wordSet.size() + " different words " +
                           "in this file");
        System.out.println("The words are:");
        Iterator iterator = wordSet.iterator();
        while (iterator.hasNext())
        {
            System.out.println("(" + iterator.next() + ")");
        }
    }
}