/*
Add the following method to the BankAccount class:

public String toString()

Your method should return a string that contains the account's name and balance separated by a comma and space. For example, if an account object named benben has the name "Benson" and a balance of 17.25, the call of benben.toString() should return:

Benson, $17.25
There are some special cases you should handle. If the balance is negative, put the - sign before the dollar sign. Also, always display the cents as a two-digit number. For example, if the same object had a balance of -17.5, your method should return:

Benson, -$17.50
Your code is being added to the following class:

public class BankAccount {
    private String name;
    private double balance;
    
    // // your code goes here
    
}
*/
public String toString() {
    if (balance > 0) {
        return String.format("%s, $%.2f", name, balance);
    } else  if (balance < 0) {
        return String.format("%s, -$%.2f", name, -balance);
    } else {
        return name + ", $0.00";
    }
}
