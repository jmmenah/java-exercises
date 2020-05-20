/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * Serializing null values
 *
 */
//   Gson by default does not serialize fields with null values to JSON.
//   If a field in a Java object is null, Gson excludes it. We can force Gson
//   to serialize null values via the GsonBuilder by using serializeNulls() method.

package com.zetcode.e05;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zetcode.User;


public class GsonSerializeNulls {

    public static void main(String[] args) {

        GsonBuilder builder = new GsonBuilder();

        builder.serializeNulls();

        Gson gson = builder.create();

        User user = new User();
        user.setFirstName("Norman");

        String json = gson.toJson(user);
        System.out.println(json);
    }
}
