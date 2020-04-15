// Example based on 
// https://www.toolsqa.com/rest-assured/serialization-and-deserialization-in-java/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.List;

public class RectangleArraylistTest {

    public static void SerializeToFile(Object classObject, String fileName) {
        try {

            // Step 1: Open a file output stream to create a file object on disk.
            // This file object will be used to write the serialized bytes of an object
            FileOutputStream fileStream = new FileOutputStream(fileName);

            // Step 2: Create a ObjectOutputStream, this class takes a files stream.
            // This class is responsible for converting the Object of any type into
            // a byte stream
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

            // Step 3: ObjectOutputStream.writeObject method takes an Object and
            // converts it into a ByteStream. Then it writes the Byte stream into
            // the file using the File stream that we created in step 1.

            objectStream.writeObject(classObject);

            // Step 4: Gracefully close the streams
            objectStream.close();
            fileStream.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static Object DeSerializeFromFileToObject(String fileName) {
        try {

            // Step 1: Create a file input stream to read the serialized content
            // of rectangle class from the file
            FileInputStream fileStream = new FileInputStream(new File(fileName));

            // Step 2: Create an object stream from the file stream. So that the content
            // of the file is converted to the Rectangle Object instance
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            // Step 3: Read the content of the stream and convert it into object
            Object deserializeObject = objectStream.readObject();

            // Step 4: Close all the resources
            objectStream.close();
            fileStream.close();

            // return the deserialized object
            return deserializeObject;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        // create List & ArrayList reference to store rectangles

        List<Rectangle> listOfRectangles = new ArrayList<>();
 
        // create rectangle objects using constructor initialization
        Rectangle rect1 = new Rectangle(1, 2);
        Rectangle rect2 = new Rectangle(3, 4);
        Rectangle rect3 = new Rectangle(5, 6);
        Rectangle rect4 = new Rectangle(7, 8);

        // add rectangles objects to ArrayList
        listOfRectangles.add(rect1);
        listOfRectangles.add(rect2);
        listOfRectangles.add(rect3);
        listOfRectangles.add(rect4);

        // Serialize  
        SerializeToFile(listOfRectangles, "rectangles.ser");

        @SuppressWarnings("unchecked")

        List<Rectangle> deSerializedList = (ArrayList<Rectangle>) DeSerializeFromFileToObject("rectangles.ser");

        // iterating ArrayList with for each & printing Rectangle Area

        for(Rectangle rect : deSerializedList){
            System.out.println("Rect area is " + rect.Area());
        }

        // iterating ArrayList with for loop & printing Rectangle Perimeter

        for (int i=0; i< deSerializedList.size(); i++) {
            System.out.printf("%nRect %d Perimeter: %.2f", i+1, deSerializedList.get(i).Perimeter() );
        }
    }

}
