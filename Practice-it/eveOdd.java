Scanner console = new Scanner(System.in);
System.out.print("Type a number: ");
int number= console.nextInt();
int odd = number % 2;
    if (odd == 0){
        System.out.println("even");
    }
    else{
        System.out.println("odd");
    }
