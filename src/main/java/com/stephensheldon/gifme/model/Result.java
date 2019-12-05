package com.stephensheldon.gifme.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
 * Author: Stephen Sheldon 11/22/19
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
//@Component
public class Result {
    private String next;
    private Gif[] results;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Gif[] getResults() {
        return results;
    }

    public void setResults(Gif[] results) {
        this.results = results;
    }
}
