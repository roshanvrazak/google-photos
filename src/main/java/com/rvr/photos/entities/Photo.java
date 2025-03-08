package com.rvr.photos.entities;

import org.jetbrains.annotations.NotNull;

public class Photo {

    String id;
    @NotNull
    String fileName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
