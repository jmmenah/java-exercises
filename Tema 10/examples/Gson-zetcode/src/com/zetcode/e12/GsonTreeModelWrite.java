/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * Java Gson tree model API
 * Gson tree model write
 */

/*
 * Tree model API creates a tree representation of the JSON document in memory.
 * It builds a tree of JsonElements. JsonElement is a class representing an element of Json.
 * It could either be a JsonObject, a JsonArray, a JsonPrimitive, or a JsonNull.
 */
package com.zetcode.e12;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zetcode.Car;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GsonTreeModelWrite {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "2012", 22000, 
                new String[]{"gray", "red", "white"}));
        cars.add(new Car("Skoda", "2016", 14000, 
                new String[]{"black", "gray", "white"}));
        cars.add(new Car("Volvo", "2010", 19500, 
                new String[]{"black", "silver", "beige"}));
        
        String fileName = "resources/cars.json";
        Path path = Paths.get(fileName);
        
        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            
            JsonElement tree = gson.toJsonTree(cars);
            JsonArray jarray = tree.getAsJsonArray();
            
            JsonElement jel = jarray.get(1);
            
            JsonObject object = jel.getAsJsonObject();
            object.addProperty("model", "2009");
            
            gson.toJson(tree, writer);
        }
        
        System.out.println("Cars written to file");
    }        
}
