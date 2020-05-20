/*
 * Data Access Object Design Pattern or DAO Pattern
 * https://ramj2ee.blogspot.com/2013/08/data-access-object-design-pattern-or.html
 * https://github.com/ramram43210/Java/tree/master/designpattern/DAO
 */

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployees();

    public void addEmployee(Employee employee);

    public Employee getEmployee(int employeeId);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(int employeeId);
}
