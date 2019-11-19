// Example3: What if you implement only parameterized constructor in class
// https://beginnersbook.com/2013/03/constructors-in-java/

/*
It will throw a compilation error.
The reason is, the statement Example3 myobj = new Example3() is invoking a default constructor which we don’t have in our program.
When you don’t implement any constructor in your class, compiler inserts the default constructor into your code,
however when you implement any constructor, then you don’t receive the default constructor by compiler into your code.

If we remove the parameterized constructor from the next code then the program would run fine,
because then compiler would insert the default constructor into your code.
 */

class Example3 {
    private int var;

    public Example3(int num) {
        var = num;
    }

    public int getValue() {
        return var;
    }

    public static void main(String args[]) {
        Example3 myobj = new Example3();  //  It will throw a compilation error
        System.out.println("value of var is: " + myobj.getValue());
    }
}