package com.jcg.java8.interfaces;

/**
 * BasicMobile class provides definition only for mandatory abstract method
 * Need to provide definition for capturePhoto()
 * Whereas, makeACall() takes the default implementation
 */

class BasicPhone implements MobileInterface {
    @Override
    public void capturePhoto() {
        System.out.println("***BASIC PHONE*** Cannot capture photo");
    }
}

/**
 * SmartPhone class overrides both default method and abstract method
 * Provides definition for both makeACall() and capturePhoto() methods
 */
class SmartPhone implements MobileInterface {

    @Override
    public void makeACall(Long number) {
        System.out.println(String.format("***SMART PHONE*** Can make voice and video call to number .... %d", number));
    }

    @Override
    public void capturePhoto() {
        System.out.println("***SMART PHONE*** Can capture photo");
    }
}

/**
 * MobileInterfaceDemo is the driver class
 */
public class MobileInterfaceDemo {
    public static void main(String[] args) {
        MobileInterface basicPhone = new BasicPhone();
        MobileInterface smartPhone = new SmartPhone();

        // Calls static method of interface
        MobileInterface.printWelcomeMessage();
        System.out.println("********************** BASIC PHONE ************************");
        // Calls default implementation of interface
        basicPhone.makeACall(1234567890L);
        // Calls abstract method of interface
        basicPhone.capturePhoto();

        System.out.println("********************** SMART PHONE ************************");
        // Calls overridden implementation of makeACall()
        smartPhone.makeACall(1234567890L);
        // Calls abstract method of interface
        smartPhone.capturePhoto();
    }
}
