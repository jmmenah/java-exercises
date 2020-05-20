/*
 *  Data Access object (DAO) Design Pattern
 *  https://www.roseindia.net/tutorial/java/jdbc/dataaccessobjectdesignpattern.html
 *
 */

/*
CREATE TABLE student (
  RollNo int(9)  PRIMARY KEY NOT NULL,
  Name tinytext NOT NULL,
  Course varchar(25) NOT NULL,
  Address text
);
*/

package roseindia.net;

public class DAOPatternDemo {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student alok = new Student();
        alok.setName("Alok");
        alok.setRollNo(8);
        alok.setCourse("MBA");
        alok.setAddress("Ranchi");

        // Adding Data
        studentDAO.add(alok);

        Student tinkoo = new Student(6, "Tinkoo", "MBA", "Alligarh");
        studentDAO.add(tinkoo);

        // Displaying Data
        studentDAO.findAll();

        // Change
        tinkoo.setName("Arvind");
        tinkoo.setRollNo(6);

        // Updating Data
        studentDAO.update(tinkoo);

        // Adding Data
        studentDAO.add(new Student(1, "Java", "MCA", "Motihari"));
        studentDAO.add(new Student(2, "Ravi", "BCA", "Patna"));
        studentDAO.add(new Student(3, "Mansukh", "M.Sc", "Katihar"));
        studentDAO.add(new Student(4, "Raman", " B.Tech", "Betiah"));
        studentDAO.add(new Student(5, "Kanhaiya", "M.Tech", "Delhi"));
        studentDAO.add(new Student(7, "Nemo", "MCA", "Neverland"));

        // Deleting Data
        studentDAO.delete(7);

        // Displaying Data
        studentDAO.findAll();
    }
}
