/*
The following code attempts to examine a String and return whether it contains a given letter. A flag named found is used. However, the Boolean logic is not implemented correctly, so the method does not always return the correct answer. In what cases does the method report an incorrect answer? Change the code so that it will always return a correct result. 
*/
public static boolean contains(String str, char ch) {
    boolean found = false;
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == ch) {
            found = true;
        }
    }
    return found;
}
