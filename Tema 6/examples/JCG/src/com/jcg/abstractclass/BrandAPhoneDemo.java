package com.jcg.abstractclass;

/**
 * @author Santosh Balgar Sachchidananda
 * This is the driver program to demonstrate the abstract class
 */
public class BrandAPhoneDemo {
    public static void main(String[] args) {
        System.out.println("This class demonstrates the use of abstract class in Java");
        System.out.println("----------------------------------------------------------");
        AndroidPhone brandAPhone = new BrandAPhone();
        //Final method inherited from AndroidPhone abstract class
        brandAPhone.displayPhoneOSType();

        brandAPhone.makeACall(1234567890L, 91);

        brandAPhone.sendSMS("Hello, world!!!!");

        brandAPhone.capturePhoto();
        System.out.println("----------------------------------------------------------");
    }
}
