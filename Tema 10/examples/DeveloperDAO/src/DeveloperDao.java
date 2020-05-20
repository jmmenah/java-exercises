// Java program to illustrate Data Access Object Pattern
// https://www.geeksforgeeks.org/data-access-object-pattern/

import java.util.List;

interface DeveloperDao {
    public List<Developer> getAllDevelopers();

    public Developer getDeveloper(int DeveloperId);

    public void updateDeveloper(Developer Developer);

    public void deleteDeveloper(Developer Developer);
}
