// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to compare two files lexicographically.

//package w3resourceIO;

// https://www.tutorialspoint.com/java/io/file_compareto.htm
// The java.io.File.compareTo(File pathname) method compares 
// two abstract pathnames lexicographically. 
// The ordering defined by this method is dependent upon the operating system.

// package com.tutorialspoint;

import java.io.File;

public class Exercise6 {
   public static void main(String[] args) {      
      File f = null;
      File f1 = null;
      
      try {
         // create new files
         f = new File("test.txt");
         f1 = new File("File/test1.txt");
         
         // returns integer value
         int value = f.compareTo(f1);
         
         // prints
         System.out.print("Lexicographically, ");
         System.out.print("abstract path name test.txt");
         
         // if lexicographically, argument = abstract path name
         if(value == 0) {
            System.out.print(" = ");
         }
         
         // if lexicographically, argument < abstract path name
         else if(value > 0) {
            System.out.print(" > ");
         }
         
         // if lexicographically, the argument > abstract path name
         else {
            System.out.print(" < ");
         }
         
         // print
         System.out.println("abstract path name File/test1.txt");
         
         // prints the value returned by compareTo()
         System.out.print("Value returned: "+value);
         
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}
