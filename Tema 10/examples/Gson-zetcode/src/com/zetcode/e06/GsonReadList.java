/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * Java Gson read list
 *
 */

package com.zetcode.e06;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class GsonReadList {
    
    public static void main(String[] args) throws IOException {
        
        Gson gson = new GsonBuilder().create();
        
        try (Reader reader = new FileReader("resources/items.json")) {
            
            List<Item> items = gson.fromJson(reader, 
                    new TypeToken<List<Item>>(){}.getType());
            
            items.forEach(System.out::println);
        }
    }    
}
