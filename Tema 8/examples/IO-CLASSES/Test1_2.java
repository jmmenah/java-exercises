// reads input file, prints an all-uppercase version to output file
// args[0] is input file
// args[1] is output file

import java.io.*;

public class Test1_2 {

    public static void main(String[] args) throws IOException {
        Reader in = new BufferedReader(new FileReader(args[0]));
        Writer out = new UpperCaseWriter(new FileWriter(args[1]));
        int intRead;
        while ((intRead = in.read()) != -1) {
            out.write(intRead);
        }
        in.close();
        out.close();
    }
}

class UpperCaseWriter extends BufferedWriter {

    public UpperCaseWriter(Writer out) {
        super(out);
    }

    public UpperCaseWriter(Writer out, int sz) {
        super(out, sz);
    }

    @Override
    public void write(int c) throws IOException {
        super.write(Character.toUpperCase(c));
    }

}
