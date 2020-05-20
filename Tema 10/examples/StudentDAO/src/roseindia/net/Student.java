/*
 *  Data Access object (DAO) Design Pattern
 *  https://www.roseindia.net/tutorial/java/jdbc/dataaccessobjectdesignpattern.html
 *
 */

package roseindia.net;

import java.io.Serializable;

public class Student implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int rollNo;
    private String name;
    private String course;
    private String address;

    public Student() {

    }

    public Student(int roll, String name, String course, String address) {
        this.rollNo = roll;
        this.name = name;
        this.course = course;
        this.address = address;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", name=" + name + ", course=" + course + ", address=" + address + "]";
    }

}
