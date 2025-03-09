package com.rvr.photos.controller;

import com.rvr.photos.entities.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class Controller {

    @GetMapping("/")
    public String hello() {
        return "<h1>Hello, world!</h1>";
    }

    private Map<String, Photo> db = Map.of(
            "1", new Photo("1", "photo1.jpg"),
            "2", new Photo("2", "photo2.jpg"),
            "3", new Photo("3", "photo3.jpg")
    );


    @GetMapping("/photos")
    public Collection<Photo> getPhotos() {
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable String id) {
        Photo photo = db.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    void deletePhoto(String id) {
        db.remove(id);

    }

    @PostMapping("/photos")
    public Photo createPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;
    }



}
