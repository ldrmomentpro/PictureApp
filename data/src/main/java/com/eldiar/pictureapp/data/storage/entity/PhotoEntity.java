package com.eldiar.pictureapp.data.storage.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "photo_table")
public class PhotoEntity {
    @NonNull
    @PrimaryKey
    public String id;
    public String author;
    public String url;

    public PhotoEntity(String id, String author, String url) {
        this.id = id;
        this.author = author;
        this.url = url;
    }
}
