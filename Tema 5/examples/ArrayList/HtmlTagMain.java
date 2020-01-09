/*
 ch10-arraylist.ppt - Slides 40-41
*/

import java.util.Set; 
import java.util.TreeSet; 

public class HtmlTagMain {
    public static void main(String[] args) {
        
        // <body><b></b><i><b></b><br/></i></body>
        Set<HtmlTag> tags = new TreeSet<HtmlTag>();
        tags.add(new HtmlTag("body", true));   // <body>
        tags.add(new HtmlTag("b", true));      // <b>
        tags.add(new HtmlTag("b", false));     // </b>
        tags.add(new HtmlTag("i", true));      // <i>
        tags.add(new HtmlTag("b", true));      // <b>
        tags.add(new HtmlTag("b", false));     // </b>
        tags.add(new HtmlTag("br"));           // <br/>
        tags.add(new HtmlTag("i", false));     // </i>
        tags.add(new HtmlTag("body", false));  // </body>
        System.out.println(tags);
        // [<b>, </b>, <body>, </body>, <br/>, <i>, </i>]

        System.out.println(tags);
        HtmlTag tagOpenBody = new HtmlTag("body", true);
        HtmlTag tagCloseBody = new HtmlTag("body", false);
        HtmlTag tagOpenHead = new HtmlTag("head", true);
        System.out.println(tagOpenBody.compareTo(tagOpenHead));
        System.out.println(tagOpenBody.compareTo(tagOpenBody));
        System.out.println(tagOpenBody.compareTo(tagCloseBody));
    }
}	
