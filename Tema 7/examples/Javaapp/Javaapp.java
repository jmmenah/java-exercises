// Java-Generic Methods
// January 20, 2019 by Java Tutorial	
// https://hajsoftutorial.com/java-generic-methods/

class GenMethDemo {
    
    static <U,V extends Number> void showUV(U u,V v) {
        
        System.out.println("AnyType    : "+u.getClass().getName());
        System.out.println("NumberType : "+v.getClass().getName());
    }
}

public class Javaapp {
    
    public static void main(String[] args) {
        
        GenMethDemo.showUV("JAVA",11);
        GenMethDemo.showUV(50,90.5);
        GenMethDemo.<Float,Double>showUV(50.5f,7.5);
    }
}
