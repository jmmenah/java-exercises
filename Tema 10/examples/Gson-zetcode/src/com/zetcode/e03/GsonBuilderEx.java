/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * GsonBuilder
 *
 */
/*
 *  GsonBuilder builds Gson with various configuration settings.
 *  GsonBuilder follows the builder pattern, and it is typically
 *  used by first invoking various configuration methods to set desired options,
 *  and finally calling create().
 */

// In the example, we write an object into JSON. We use GsonBuilder to create Gson
package com.zetcode.e03;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintStream;

import com.zetcode.User;

public class GsonBuilderEx {

    public static void main(String[] args) throws IOException {

        try (PrintStream prs = new PrintStream(System.out, true, 
                "UTF8")) {
            
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            
            User user = new User("Peter", "Flemming");
            gson.toJson(user, prs);
        }
    }
}
