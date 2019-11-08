/*
Write a piece of code that prompts the user for a number and then prints a different message depending on whether the number was an integer or a real number. Here are two sample dialogues:

Type a number: 42.5
You typed the real number 42.5

Type a number: 3
You typed the integer 3
*/
Scanner console = new Scanner(System.in);
System.out.print("Type a number: ");
if (console.hasNextInt()) {
    int value = console.nextInt();
    System.out.println("You typed the integer " + value);
} else if (console.hasNextDouble()) {
    double value = console.nextDouble();
    System.out.println("You typed the real number " + value);
}


