The following program redundantly repeats the same expressions many times. 
Modify the program to remove all redundant expressions using variables of appropriate types. 

public class ComputePay {
    public static void main(String[] args) {
        // Calculate pay at work based on hours worked each day
        System.out.println("My total hours worked:");
        System.out.println(4 + 5 + 8 + 4);

        System.out.println("My hourly salary:");
        System.out.println("$8.75");

        System.out.println("My total pay:");
        System.out.println((4 + 5 + 8 + 4) * 8.75);

        System.out.println("My taxes owed:"); // 20% tax
        System.out.println((4 + 5 + 8 + 4) * 8.75 * 0.20);
    }
}

public class ComputePay {
    public static void main(String[] args) {
        // Calculate pay at work based on hours worked each day
        int totalHours = 4 + 5 + 8 + 4;
        double hourlyPay = 8.75;
        double totalPay = (totalHours) * hourlyPay;
        double taxesOwed = (totalHours) * hourlyPay * 0.20;
        
        System.out.println("My total hours worked:");
        System.out.println(totalHours);
             
        System.out.println("My hourly salary:");
        System.out.println("$" + hourlyPay);

        System.out.println("My total pay:");
        System.out.println(totalPay);

        System.out.println("My taxes owed:"); // 20% tax
        System.out.println(taxesOwed);
    }
}


