/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * Java Gson streaming API
 * Gson JsonWriter
 */
/*
 *  JsonWriter writes a JSON encoded value to a stream, one token at a time.
 * The stream includes both literal values (strings, numbers, booleans, and nulls) as well as the begin
 * and end delimiters of objects and arrays. Each JSON document must contain one top-level array or object.
 * Objects are created with beginObject() and endObject() method calls.
 * Within objects, tokens alternate between names and their values.
 * Arrays are created within beginArray() and endArray() method calls.
 */
package com.zetcode.e14;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GsonStreamApiWrite {
    
    public static void main(String[] args) throws IOException {
        
        String fileName = "resources/cars.json";
        Path path = Paths.get(fileName);
        
        try (JsonWriter writer = new JsonWriter(Files.newBufferedWriter(path, 
                StandardCharsets.UTF_8))) {
            
            writer.beginObject(); 
            writer.name("name").value("Audi");
            writer.name("model").value("2012");
            writer.name("price").value(22000);
            
            writer.name("colours");
            writer.beginArray();
            writer.value("gray");
            writer.value("red");
            writer.value("white");
            writer.endArray();
            
            writer.endObject();
        } 
        
        System.out.println("Data written to file");
    }
}
