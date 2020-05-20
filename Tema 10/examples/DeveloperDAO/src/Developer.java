// Java program to illustrate Data Access Object Pattern
// https://www.geeksforgeeks.org/data-access-object-pattern/

class Developer {
    private String name;
    private int DeveloperId;

    Developer(String name, int DeveloperId) {
        this.name = name;
        this.DeveloperId = DeveloperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeveloperId() {
        return DeveloperId;
    }

    public void setDeveloperId(int DeveloperId) {
        this.DeveloperId = DeveloperId;
    }
}
