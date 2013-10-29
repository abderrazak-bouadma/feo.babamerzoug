package com.babamerzoug.feo.domain;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/29/13
 * Time: 5:00 PM
 */
public class CurrencyExchangeDesk {

    @Id
    private String id;
    private String name;

    public CurrencyExchangeDesk() {
    }

    public CurrencyExchangeDesk(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeDesk{" +
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
