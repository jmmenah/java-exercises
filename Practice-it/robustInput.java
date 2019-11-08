/*
The following code is not robust against invalid user input. Change the code so that it will not proceed until the user has entered a valid age (any integer) and grade point average (GPA, any real number). You may assume that the user enters a single token of input each time when prompted. Here is a sample dialogue of how the code should behave:

Type your age: hello
Type your age: ?
Type your age: 3.14
Type your age: 25
Type your GPA: a
Type your GPA: bcd
Type your GPA: 2.5
age = 25, GPA = 2.5
*/
Scanner console = new Scanner(System.in);

System.out.print("Type your age: ");
while (!console.hasNextInt()) {
    console.nextLine();
    System.out.print("Type your age: ");
}
int age = console.nextInt();

System.out.print("Type your GPA: ");
while (!console.hasNextDouble()) {
    console.next();
    System.out.print("Type your GPA: ");
}
double gpa = console.nextDouble();
System.out.println("age = " + age + ", " + "GPA = " + gpa);
