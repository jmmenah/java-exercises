/*
 * Java Read XML with StAX Parser – Cursor & Iterator APIs
 * By Lokesh Gupta
 * https://howtodoinjava.com/xml/read-xml-stax-parser-cursor-iterator/
 */

package com.howtodoinjava.demo;

public class Employee {
    private Integer id;
    private String name;
    private String title;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", title=" + title + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
