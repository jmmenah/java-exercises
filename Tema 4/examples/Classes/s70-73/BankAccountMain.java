// Slides: ch08-classes.ppt
// 70 - 73

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        System.out.println(b1.getID());   

        System.out.println(b1.getNumAccounts());   

        BankAccount b2 = new BankAccount();
        System.out.println(b2.getID());   

        System.out.println(b2.getNumAccounts());   
        System.out.println(b1.getNumAccounts());   
    }
}


