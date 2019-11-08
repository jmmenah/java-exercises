/*
Write a sentinel loop that repeatedly prompts the user to enter a number and, once the number -1 is typed, displays the maximum and minimum numbers that the user entered. Here is a sample dialogue:

Type a number (or -1 to stop): 5
Type a number (or -1 to stop): 2
Type a number (or -1 to stop): 17
Type a number (or -1 to stop): 8
Type a number (or -1 to stop): -1
Maximum was 17
Minimum was 2
*/
int SENTINEL = -1; 
System.out.print("Type a number (or " + SENTINEL + " to stop): ");
Scanner console = new Scanner(System.in);
int input = console.nextInt();
int min = input; // 
int max = input;
while (input != SENTINEL); { 
    if (input < min) {
        min = input;
    } else if (input > max) {
        max = input;
    }

    System.out.print("Type a number (or " + SENTINEL + " to stop): "); 
    input = console.nextInt(); 
}

if (min != SENTINEL) { 
    System.out.println("Maximum was " + max); 
    System.out.println("Minimum was " + min);
}
