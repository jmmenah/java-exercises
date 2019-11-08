/*
Write code that prompts for three integers, averages them, and prints the average. Make your code robust against invalid input; if the user types a non-number, re-prompt with the same prompt message. (You may want to look at the getInt method discussed in Chapter 5. You can call that method in your solution if you like.) Here is an example dialogue:

Type an integer: 5
Type an integer: 2
Type an integer: 17
Average: 8.0
*/

String prompt = "Type an integer: ";
Scanner console = new Scanner(System.in);
int num1 = getInt(console, prompt);
int num2 = getInt(console, prompt);
int num3 = getInt(console, prompt);
double average = (num1 + num2 + num3) / 3.0;
System.out.println("Average: " + average);

