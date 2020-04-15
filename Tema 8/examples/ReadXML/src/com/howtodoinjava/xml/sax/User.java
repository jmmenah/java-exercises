/*
 * Java SAX Parser – Read XML Example
 * By Lokesh Gupta
 * https://howtodoinjava.com/xml/sax-parser-read-xml-example/
 */

package com.howtodoinjava.xml.sax;

/**
 * Model class. Its instances will be populated using SAX parser.
 */
public class User {
    //XML attribute id
    private int id;
    //XML element fisrtName
    private String firstName;
    //XML element lastName
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.firstName + ":" + this.lastName;
    }
}
