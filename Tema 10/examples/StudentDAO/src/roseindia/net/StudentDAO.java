/*
 *  Data Access object (DAO) Design Pattern
 *  https://www.roseindia.net/tutorial/java/jdbc/dataaccessobjectdesignpattern.html
 *
 */

package roseindia.net;

public interface StudentDAO {
    public void add(Student s);

    public void update(Student s);

    public void delete(int rollNo);

    public void findAll();
}
