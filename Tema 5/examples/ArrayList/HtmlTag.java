/*
 ch10-arraylist.ppt - Slides 40-41
*/

public class HtmlTag implements Comparable<HtmlTag> {
   
    private String element;
    private boolean open;
    private boolean empty; // empty element

    // Compares tags by their element ("body" before "head"),
    // breaking ties with opening tags before closing tags.
    // Returns < 0 for less, 0 for equal, > 0 for greater.
    public int compareTo(HtmlTag other) {
        int compare = element.compareTo(other.getElement());
        if (compare != 0) {
            // different tags; use String's compareTo result
            return compare;
        } else {
            // same tag
            if (isOpenTag() == other.isOpenTag()) {
                return 0;   // exactly the same kind of tag
            } else if (other.isOpenTag()) {
                return 1;   // he=open, I=close; I am after
            } else {
                return -1;  // I=open, he=close; I am before
            }
        }
    }

    public HtmlTag(String element, boolean open) {
        this.element = element;
        this.open = open;  
	empty = false; 
    }

    public HtmlTag(String element) {
        this.element = element;
        open = true; 
	empty = true;   
    }

    public String getElement() {
        return element;
    }

    public boolean isOpenTag() {
        return open; 
    }

    public String toString() {
        String tag ="<";  
        if (!open) tag+= "/";
        tag+= element;
        if (empty) tag+= "/";
        
        return tag + ">";    
    }
}



