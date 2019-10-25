System.out.print("Is your money multiplied 1 or 2 times? ");
int times = console.nextInt();
System.out.print("And how much are you contributing? ");
int donation = console.nextInt();
if (times == 1) {
    sum = sum + donation;
    count1++;
}
if (times == 2) {
    sum = sum + 2 * donation;
    count2++;
}
total = total + donation;
