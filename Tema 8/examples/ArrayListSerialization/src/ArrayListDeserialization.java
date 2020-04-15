/*
 * How to serialize ArrayList in java
 * https://beginnersbook.com/2013/12/how-to-serialize-arraylist-in-java/
 */

//package beginnersbook.com;

import java.io.*;
import java.util.ArrayList;

public class ArrayListDeserialization {
    public static void main(String[] args) {
        ArrayList<String> arraylist;
        try {
            FileInputStream fis = new FileInputStream("myfile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        for (String tmp : arraylist) {
            System.out.println(tmp);
        }
    }
}