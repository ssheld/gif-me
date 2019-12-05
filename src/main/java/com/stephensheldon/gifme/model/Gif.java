package com.stephensheldon.gifme.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: Stephen Sheldon 11/21/19
 **/

//@JsonIgnoreProperties(ignoreUnknown = true)
//@Component
public class Gif {
    private float created;
    private boolean hasAudio;
    private String id;
    private String[] tags;
    private String title;
    private String url;
    private String itemUrl;
    private ArrayList<HashMap<String, Media>> media;
    private String hash;
//    @Autowired
//    private Hashids hashids;

    public float getCreated() {
        return created;
    }

    public void setCreated(float created) {
        this.created = created;
    }

    public boolean isHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
//        setHash(id);
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public ArrayList<HashMap<String, Media>> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<HashMap<String, Media>> media) {
        this.media = media;
    }

    public String getTinyGifUrl() {
        Media tinyGifUrlMedia = this.media.get(0).get("tinygif");
        return tinyGifUrlMedia.getUrl();
    }

//    public String getHash() {
//        return hash;
//    }
//
//    public void setHash(String id) {
//        this.hash = hashids.encode(Long.parseLong(id));
//    }

    @Override
    public String toString() {
        return "Title: " + title + " id: " + id + " url: " + url;
    }
}
