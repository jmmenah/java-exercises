// A simple constructor program in java
// https://beginnersbook.com/2013/03/constructors-in-java/
public class Hello {
    String name;

    //Constructor
    Hello() {
        this.name = "BeginnersBook.com";
    }

    public static void main(String[] args) {
        Hello obj = new Hello();
        System.out.println(obj.name);
    }
}