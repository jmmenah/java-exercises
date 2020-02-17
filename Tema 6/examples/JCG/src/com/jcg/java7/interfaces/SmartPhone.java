package com.jcg.java7.interfaces;

/**
 * @author Santosh Balgar Sachchidananda
 * SmartPhone class implements MobilePhone interface. It has to provide definition for all the methods.
 * Also it has additional methods.
 */
class SmartPhone implements MobilePhone {
    /**
     * @param number
     * @param countryCode
     * Overridden from MobilePhone interface
     */
    @Override
    public void makeACall(Long number, Integer countryCode) {
        System.out.println(String.format("I can make audio and video call to %d-%d", countryCode, number));
    }

    /**
     * @param message
     * @return
     * Overridden from MobilePhone interface
     */
    @Override
    public boolean sendSMS(String message) {
        System.out.println("I can send SMS");
        return true;
    }

    /**
     * own method of SmartPhone class
     */
    public void canCapturePhoto() {
        System.out.println("I can take HD photo");
    }
}
