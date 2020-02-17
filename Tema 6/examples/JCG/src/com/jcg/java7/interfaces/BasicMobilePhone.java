package com.jcg.java7.interfaces;

/**
 * author Santosh Balgar Sachchidananda
 * BasicMobilePhone implements MobilePhone interface and provide definition for all the methods.
 * It also has additional method apart from the interface contract
 */
class BasicMobilePhone implements MobilePhone {
    /**
     * @param number
     * @param countryCode
     * Overridden from MobilePhone interface
     */
    @Override
    public void makeACall(Long number, Integer countryCode) {
        System.out.println(String.format("I can call to number %d-%d", countryCode, number));
    }

    /*
     * @param message
     * @return
     * Overriden from MobilePhone interface
     */
    @Override
    public boolean sendSMS(String message) {
        System.out.println("I can send SMS");
        return true;
    }

    /**
     * Own method
     */
    public void supportClassicGames() {
        System.out.println("I can support classic games");
    }
}
