public class Sleet extends Snow {
      public void method2() {
          System.out.println("Sleet 2");
          super.method2();
          method3();
      }

      public void method3() {
          System.out.println("Sleet 3");
      }
}
