package roseindia.net;

import java.io.*;

/*
 * Java - Serialization
 * https://www.tutorialspoint.com/java/java_serialization.htm
 *
 */

import java.util.ArrayList;
import java.util.List;

//import roseindia.net.Student;

public class SerializeStudent {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        // Adding Data to the list
        studentList.add(new Student(1, "Java", "MCA", "Motihari"));
        studentList.add(new Student(2, "Ravi", "BCA", "Patna"));
        studentList.add(new Student(3, "Mansukh", "M.Sc", "Katihar"));
        studentList.add(new Student(4, "Raman", " B.Tech", "Betiah"));
        studentList.add(new Student(5, "Kanhaiya", "M.Tech", "Delhi"));
        studentList.add(new Student(6, "Tinkoo", "MBA", "Alligarh"));
        studentList.add(new Student(7, "Nemo", "MCA", "Neverland"));
        studentList.add(new Student(8, "Alok", "MBA", "Ranchi"));

        // Serialize the studentList
        try (FileOutputStream fileOut = new FileOutputStream("resources/student.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ) {
            out.writeObject(studentList);
            System.out.println("Serialized data is saved in student.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserialize to a new list
        List<?> list = null;

        try (FileInputStream fileIn = new FileInputStream("resources/student.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            list = (List<?>) in.readObject();
        } catch (FileNotFoundException i) {
            i.printStackTrace();
            return;
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
            return;
        }

        // Print elements (Student objects) from list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}