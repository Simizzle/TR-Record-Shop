package com.techreturners.recordshop.controller;

import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.service.RecordShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recordshop")
public class RecordShopController {

    @Autowired
    RecordShopService recordShopService;

    @GetMapping(value = {"/albums"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = recordShopService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @PostMapping(value = {"/albums"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album newAlbum = recordShopService.insertAlbum(album);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("album", "/api/v1/albums/" + newAlbum.getId().toString());
        return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
    }

}
