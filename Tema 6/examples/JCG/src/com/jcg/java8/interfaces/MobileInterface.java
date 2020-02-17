package com.jcg.java8.interfaces;

/**
 * @author: Santosh Balgar Sachchiananda
 * This example shows the Java8 interface default methods
 */

public interface MobileInterface {

    /**
     * Java8 adds capability to have static method in interface.
     * Static method in interface Can't be overridden
     */
    public static void printWelcomeMessage() {
        System.out.println("***STATIC METHOD*** Welcome!!");
    }
    /*
     * Java8 adds capability of providing a default definition of method in an interface.
     * Default method can be overridden by the implementing class
     */
    default void makeACall(Long number) {
        System.out.println(String.format("***DEFAULT METHOD*** Calling ...... %d", number));
    }
    /*
     * Regular interface method, which every class needs to provide a definition
     */
    public void capturePhoto();
}
