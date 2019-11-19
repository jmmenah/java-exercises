// Java Copy Constructor
// https://beginnersbook.com/2013/03/constructors-in-java/

class JavaExample {
    String web;

    JavaExample(String w) {
        web = w;
    }

    /* This is the Copy Constructor, it
     * copies the values of one object
     * to the another object (the object
     * that invokes this constructor)
     */
    JavaExample(JavaExample je) {
        web = je.web;
    }

    void disp() {
        System.out.println("Website: " + web);
    }

    public static void main(String args[]) {
        JavaExample obj1 = new JavaExample("BeginnersBook");

        /* Passing the object as an argument to the constructor
         * This will invoke the copy constructor
         */
        JavaExample obj2 = new JavaExample(obj1);
        obj1.disp();
        obj2.disp();
    }
}