package com.eldiar.pictureapp.domain.models;


public class Photo {
    public String id;
    public String author;
    public String download_url;

    public Photo() {
    }

    public Photo(String id, String author, String download_url) {
        this.id = id;
        this.author = author;
        this.download_url = download_url;
    }
}
