public class TenHellosPair { 
    public static void main(String[] args) {

        // print out special cases whose ordinal doesn't end in th
        System.out.println("2nd Hello");

        // count from i = 4 to 10
/*        int i = 4;
        while (i <= 10) {
            System.out.println(i + "th Hello");
            i = i + 2;
        }

        do {
            System.out.println(i + "th Hello");
            i = i + 2;
        }while (i <= 10);
*/
	for(int i=4; i <= 10; i = i + 2){
		System.out.println(i + "th Hello");
	}
   }
}
