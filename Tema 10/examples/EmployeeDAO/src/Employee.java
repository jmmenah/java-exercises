/*
 * Data Access Object Design Pattern or DAO Pattern
 * https://ramj2ee.blogspot.com/2013/08/data-access-object-design-pattern-or.html
 * https://github.com/ramram43210/Java/tree/master/designpattern/DAO
 */

public class Employee {
    private int employeeId;
    private String name;
    private int age;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
