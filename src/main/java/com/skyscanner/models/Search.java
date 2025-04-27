package com.skyscanner.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {

    @JsonProperty
    private String city;

    public Search() {}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
