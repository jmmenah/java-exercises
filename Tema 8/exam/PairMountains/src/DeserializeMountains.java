import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializeMountains {

    public static void main(String[] args) {

        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        // creating List reference to hold ALL values after de-serialization
        List<Pair<String, Integer>> mountains = null;

        // Serialized file name
        String fileName = "Testing.ser";
        //String fileName = "ArrayListOfMountains.ser";
        try {
            // reading binary data
            fis = new FileInputStream(fileName);

            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);

            // reading object's value and casting ArrayList<Pair<String, Integer>>
            mountains = (ArrayList<Pair<String, Integer>>) ois.readObject();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("ArrayList object de-serialized from \"" + fileName + "\" file:");

        // iterating & printing ArrayList values to console
        for(Pair m : mountains){
            System.out.println(m);
        }
    }
}
