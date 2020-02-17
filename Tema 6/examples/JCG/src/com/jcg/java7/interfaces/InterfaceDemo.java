package com.jcg.java7.interfaces;

/**
 * author Santosh Balgar Sachchidananda
 * InterfaceDemo is the driver class for interfaces
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        MobilePhone basicMobilePhone = new BasicMobilePhone();
        MobilePhone smartPhone = new SmartPhone();

        System.out.println("Basic Mobile Phone features");
        basicMobilePhone.makeACall(1234567890L, 91);
        basicMobilePhone.sendSMS("Hello world!!!");
        ((BasicMobilePhone) basicMobilePhone).supportClassicGames();
        System.out.println("-------------------------------------------------");
        System.out.println("Smart Phone features");
        smartPhone.makeACall(1234567890L, 91);
        smartPhone.sendSMS("Hello world!!!");
        ((SmartPhone) smartPhone).canCapturePhoto();
    }
}
