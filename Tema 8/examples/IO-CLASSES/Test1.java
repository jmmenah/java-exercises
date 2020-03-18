// reads input file, prints an all-uppercase version to output file
// args[0] is input file
// args[1] is output file

import java.io.*;

public class Test1
{
    public static void main(String[] args) throws IOException
    {
        Reader in = new BufferedReader(new FileReader(args[0]));
        Writer out = new BufferedWriter(new FileWriter(args[1]));
        int intRead;
        while((intRead = in.read()) != -1)
        {
            out.write(Character.toUpperCase((char) intRead));
        }
        in.close();
        out.close();
    }
}