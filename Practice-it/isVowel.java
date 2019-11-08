/*
Write a method named isVowel that returns whether a String is a vowel (a single-letter string containing a, e, i, o, or u, case-insensitively). 
*/
public static boolean isVowel(String c) {
    return "aeiouAEIOU".indexOf(c) > 0;
}
