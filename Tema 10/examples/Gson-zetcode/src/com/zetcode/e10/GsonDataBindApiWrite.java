/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * Java Gson data binding API
 * Gson data binding API write
 */
//  The data binding API converts JSON to and from POJO using property accessors.
//  Gson processes JSON data using data type adapters.

package com.zetcode.e10;

import com.google.gson.Gson;
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

public class GsonDataBindApiWrite {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "2012", 22000, new String[]{"gray", "red", "white"}));
        cars.add(new Car("Skoda", "2016", 14000, new String[]{"black", "gray", "white"}));
        cars.add(new Car("Volvo", "2010", 19500, new String[]{"black", "silver", "beige"}));

        String fileName = "resources/cars.json";
        Path path = Paths.get(fileName);

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            gson.toJson(cars, writer);
        }

        System.out.println("Cars written to file");
    }
}