// https://github.com/Marak/asciimo/blob/master/fonts/eftiwall-chart.txt
// http://yohannes.faithweb.com/spyTxt.htm
import java.util.Random;
public class EftiWall {
    // Do not modify the main method
    public static void main(String[] args) {
	basicWall();
	randomWall();
	mouseWall();    
    }
    
    // Each drawing consists of three lines. 
    // Use a different method for each of them.

    // Draws the hair
    
    // Draws the eyes
    
    // Draws the hands nose and wall

    
    // Draws a basic EftiWall
    /*
         ___
        (. .)
    ooO--(_)--Ooo-

    */
    public static void basicWall() {
        System.out.println("     ___");
        System.out.println("    (. .)");
        System.out.println("ooO--(_)--Ooo-");
        System.out.println();
        System.out.println();
        System.out.println();
    }


    // Draws a mouse spying at the wall
    /*
        _   _     
       (_)-(_)    
        (o o)     
    ooO--(_)--Ooo-

    */
    public static void mouseWall() {
        System.out.println("    _   _");
        System.out.println("   (_)-(_)");
        System.out.println("    (o o)");
        System.out.println("ooO--(_)--Ooo-");

    }    

    // Draws a random EftiWall
    public static void randomWall() {
	String eyeType = "*.oO-";  // 5 types of eye
    String hairType = "|x&,)(/^#+=_";  // 12 types of hair
        // hint: use charAt(index) to get one type of eye or hair
        Random random = new Random();
        int eye= random.nextInt(5);
        int hair= random.nextInt(12);
        System.out.println("     "+ hairType.charAt(hair)+hairType.charAt(hair)+hairType.charAt(hair));
        System.out.println("    ("+eyeType.charAt(eye)+" "+eyeType.charAt(eye)+")");
        System.out.println("ooO--(_)--Ooo-");
        System.out.println();
        System.out.println();
    }        
}