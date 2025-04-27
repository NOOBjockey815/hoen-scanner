package com.skyscanner.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {

    @JsonProperty
    private String city;

    @JsonProperty
    private String kind;

    @JsonProperty
    private String title;

    public SearchResult() {}

    public String getCity() {
        return city;
    }

    public String getKind() {
        return kind;
    }

    public String getTitle() {
        return title;
    }
}
