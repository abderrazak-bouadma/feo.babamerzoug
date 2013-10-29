package com.babamerzoug.feo.domain;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/29/13
 * Time: 5:00 PM
 */
public class Desk {

    @Id
    private String id;
    private String name;

    public Desk() {
    }

    public Desk(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
