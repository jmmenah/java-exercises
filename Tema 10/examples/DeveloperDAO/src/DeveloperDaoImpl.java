// Java program to illustrate Data Access Object Pattern
// https://www.geeksforgeeks.org/data-access-object-pattern/

import java.util.ArrayList;
import java.util.List;

class DeveloperDaoImpl implements DeveloperDao {
    List<Developer> Developers;

    public DeveloperDaoImpl() {
        Developers = new ArrayList<Developer>();
        Developer Developer1 = new Developer("Kushagra", 0);
        Developer Developer2 = new Developer("Vikram", 1);
        Developers.add(Developer1);
        Developers.add(Developer2);
    }

    @Override
    public void deleteDeveloper(Developer Developer) {
        Developers.remove(Developer.getDeveloperId());
        System.out.println("DeveloperId " + Developer.getDeveloperId()
                + ", deleted from database");
    }

    @Override
    public List<Developer> getAllDevelopers() {
        return Developers;
    }

    @Override
    public Developer getDeveloper(int DeveloperId) {
        return Developers.get(DeveloperId);
    }

    @Override
    public void updateDeveloper(Developer Developer) {
        Developers.get(Developer.getDeveloperId()).setName(Developer.getName());
        System.out.println("DeveloperId " + Developer.getDeveloperId()
                + ", updated in the database");
    }
}
