// Slides: ch08-classes.ppt
// 70 - 73

public class BankAccount {

    // static count of how many accounts are created
    // (only one count shared for the whole class)
    private static int objectCount = 0;

    // clients can call this to find out # accounts created
    public static int getNumAccounts() {
        return objectCount;
    }

    // fields (replicated for each object)
    private String name;
    private int id;

    public BankAccount() {
        objectCount++;     // advance the id, and
        id = objectCount;  // give number to account
    }

//    ...

    public int getID() {   // return this account's id
        return id;
    }
}


