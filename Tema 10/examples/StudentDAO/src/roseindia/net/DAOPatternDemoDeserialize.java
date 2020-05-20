/*
 *  Data Access object (DAO) Design Pattern
 *  https://www.roseindia.net/tutorial/java/jdbc/dataaccessobjectdesignpattern.html
 *
 */

package roseindia.net;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DAOPatternDemoDeserialize {

    public static List<Student> DeserializeStudentList(String fileName) {
        List<Student> l = null;

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            l = (List<Student>) in.readObject();
        } catch (FileNotFoundException i) {
            i.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
        }
        return l;
    }

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();

        // Deserialize to a list
        List<Student> list = DeserializeStudentList("resources/student.ser");

        // Adding Data Looping the list
        for (int i = 0; i < list.size(); i++) {
            studentDAO.add(list.get(i));
        }

        // Displaying Data
        studentDAO.findAll();

        // Change
        Student tinkoo = new Student();
        tinkoo.setName("Arvind");
        tinkoo.setRollNo(6);

        // Updating Data
        studentDAO.update(tinkoo);

        // Deleting Data
        studentDAO.delete(7);

        // Displaying Data
        studentDAO.findAll();
    }
}
