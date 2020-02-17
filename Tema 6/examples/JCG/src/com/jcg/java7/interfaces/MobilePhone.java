package com.jcg.java7.interfaces;

/**
 * @author Santosh Balgar Sachchidananda
 * MobileInterface defines the contract which all types of mobile phones
 * in the example have to adhere to
 */
public interface MobilePhone {
    void makeACall(Long number, Integer countryCode);
    boolean sendSMS(String message);
}
