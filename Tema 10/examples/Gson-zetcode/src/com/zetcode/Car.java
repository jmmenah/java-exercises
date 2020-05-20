/*
 * Gson tutorial: http://zetcode.com/java/gson/
 */
package com.zetcode;

import java.util.Arrays;

public class Car {

    private final String name;
    private final String model;
    private final int price;
    private final String[] colours;

    public Car(String name, String model, int price, String[] colours) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.colours = colours;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", colours=" + Arrays.toString(colours) +
                '}';
    }
}

