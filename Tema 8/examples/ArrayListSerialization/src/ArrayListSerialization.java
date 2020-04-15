/*
 * How to serialize ArrayList in java
 * https://beginnersbook.com/2013/12/how-to-serialize-arraylist-in-java/
 */

//package beginnersbook.com;

import java.util.ArrayList;
import java.io.*;

public class ArrayListSerialization {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();

        al.add("Hello");
        al.add("Hi");
        al.add("Howdy");

        try {
            FileOutputStream fos = new FileOutputStream("myfile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(al);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}