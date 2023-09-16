package com.techreturners.recordshop.controller;

import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.service.RecordShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recordshop")
public class RecordShopController {

    @Autowired
    RecordShopService recordShopService;

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = recordShopService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

}
