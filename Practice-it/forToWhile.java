/*
Convert each of the following for loops into an equivalent while loop. (You might need to rename some variables for the code to compile, since all four parts a-d are in the same scope.) 
*/
System.out.println("a.");
int max=5;
int n = 1;
while (n <= max) {
    System.out.println(n);
    n++;
}
System.out.println();

System.out.println("b.");
int total = 25;
int number = 1;
while (number <= (total / 2)) {
    total = total - number;
    System.out.println(total + " " + number);
    number++;
}
System.out.println();

System.out.println("c.");
int i = 1;
while (i <= 2) {
    int j = 1;
    while (j <= 3) {
        int k = 1;
        while (k <= 4) {
            System.out.print("*");
            k++;
        }
        System.out.print("!");
        j++;
    }
    System.out.println();
    i++;
}
System.out.println();

System.out.println("d.");
number = 4;
int count = 1;
while (count <= number) {
    System.out.println(number);
    number = number / 2;
    count++;
}
