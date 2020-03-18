
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TestSerialize {

    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();

        //FileOutputStream to write to a file
        OutputStream os = new FileOutputStream("foo.dat");

        //BufferedOutputStream for "performance"
        os = new BufferedOutputStream(os);        

        //ObjectOutputStream to write the foo object
        os = new ObjectOutputStream(os);

        ((ObjectOutputStream) os).writeObject(foo);

        os.close();
    }
}
