/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * Java Gson excluding fields with @Expose
 *
 */
/*
 * @Expose annotation indicates that a member should be exposed for JSON serialization or deserialization.
 * The @Expose annotation can take two boolean parameters: serialize and deserialize.
 * The @Expose annotation must be explicitly enabled with excludeFieldsWithoutExposeAnnotation() method.
 */
package com.zetcode.e09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

enum MaritalStatus {
    
    SINGLE,
    MARRIED,
    DIVORCED,
    UNKNOWN
}

class Person {
    
    @Expose
    private String firstName;
    
    @Expose
    private String lastName;

    // The marital status field will not be serialized,
    // because it is not decorated with the @Expose annotation.
    private MaritalStatus maritalStatus;

    public Person(String firstName, String lastName, 
            MaritalStatus maritalStatus) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.maritalStatus = maritalStatus;
    }
    
    public Person() {}
}

public class GsonExcludeFileds {
    
    public static void main(String[] args) {
        
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        
        Person p = new Person("Jack", "Sparrow", MaritalStatus.UNKNOWN);
        
        gson.toJson(p, System.out);        
    }
}
