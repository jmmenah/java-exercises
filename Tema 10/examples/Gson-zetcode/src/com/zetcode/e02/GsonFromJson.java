/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * Java Gson fromJson
 *
 */
// The fromJson() method deserializes the specified JSON into an object of the specified class.
// The example uses fromJson() method to read JSON into a Java object.
package com.zetcode.e02;

import com.google.gson.Gson;
import com.zetcode.User;

public class GsonFromJson {

    public static void main(String[] args) {

        String json_string = "{\"firstName\":\"Tom\", \"lastName\": \"Broody\"}";

        Gson gson = new Gson();

        User user = gson.fromJson(json_string, User.class);

        System.out.println(user);
    }
}
