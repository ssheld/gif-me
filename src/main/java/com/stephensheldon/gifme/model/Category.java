package com.stephensheldon.gifme.model;

import org.springframework.stereotype.Component;

/**
 * Author: Stephen Sheldon 11/21/19
 **/
@Component
public class Category {
    private String searchTerm;
    private String path;
    private String image;
    private String name;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
