
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class TestDeserialize {

    public static void main(String[] args) throws Exception {

        //FileOutputStream to read from a file
        InputStream is = new FileInputStream("foo.dat");

        //BufferedInputStream for "performance"
        is = new BufferedInputStream(is);

        //ObjectInputStream to read the foo object
        is = new ObjectInputStream(is);

        Foo foo = (Foo) ((ObjectInputStream) is).readObject();
        is.close();

        System.out.println(foo.attr);
        System.out.println(foo.message);
        for (int i = 0; i < 10; i++) {
            System.out.print(foo.bars[i].attr + " ");
        }
    }
}
