/*
 * Gson tutorial: hhtp://zetcode.com/java/gson/
 * Java Gson read into array
 *
 */
//  The next example reads data into a Java array.

package com.zetcode.e07;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zetcode.User;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class GsonReadArray {
    
    public static void main(String[] args) throws IOException {
        
        Gson gson = new GsonBuilder().create();
        
        String fileName = "resources/users.json";
        Path path = new File(fileName).toPath();
        
        try (Reader reader = Files.newBufferedReader(path, 
                StandardCharsets.UTF_8)) {
            
            User[] users = gson.fromJson(reader, User[].class);

            Arrays.stream(users).forEach( e -> {
                System.out.println(e);
            });
            //for (User u: users) System.out.println(u);
        }
    }
}
