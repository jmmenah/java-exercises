// Super()
// https://beginnersbook.com/2013/03/constructors-in-java/

class MyParentClass {
    MyParentClass() {
        System.out.println("MyParentClass Constructor");
    }
}

class MyChildClass extends MyParentClass {
    MyChildClass() {
        System.out.println("MyChildClass Constructor");
    }

    public static void main(String args[]) {
        new MyChildClass();
    }
}

