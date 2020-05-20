/*
 * Gson tutorial: http://zetcode.com/java/gson/
 */
package com.zetcode.e06;

public class Item {
    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", quantity=" + quantity + '}';
    }

}
