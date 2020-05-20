/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * Java Gson data binding API
 * Gson data binding API read
 */
//  The data binding API converts JSON to and from POJO using property accessors.
//  Gson processes JSON data using data type adapters.

/*  In the example, we read data from a JSON file into a list of car objects with Gson data binding API.
 * Gson automatically maps JSON into Car objects. Because the type information is lost at runtime,
 * we need to use the TypeToken to let Gson know what type we use.
 */

package com.zetcode.e11;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zetcode.Car;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class GsonDataBindApiRead {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String fileName = "resources/cars.json";
        Path path = Paths.get(fileName);
        
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            List<Car> cars = gson.fromJson(reader,
                    new TypeToken<List<Car>>(){}.getType());
            
            cars.forEach(System.out::println);
        }        
    }
}
