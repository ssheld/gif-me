package com.stephensheldon.gifme.model;

import org.springframework.stereotype.Component;

/**
 * Author: Stephen Sheldon 11/22/19
 **/
//@Component
public class Media {
    private String preview;
    private String url;
    private int[] dims;
    private int size;

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int[] getDims() {
        return dims;
    }

    public void setDims(int[] dims) {
        this.dims = dims;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Preview: %s url: %s size %d", preview, url, size);
    }
}
