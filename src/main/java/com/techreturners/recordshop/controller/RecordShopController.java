package com.techreturners.recordshop.controller;

import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.model.Genre;
import com.techreturners.recordshop.service.RecordShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return new ResponseEntity<>(newAlbum, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/albums", params = "artist", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Album>> getAlbumByArtist(@RequestParam("artist") Optional<String> artist) {
        List<Album> albumList = recordShopService.getAlbumsByArtist(artist);
        return new ResponseEntity<>(albumList, HttpStatus.OK);
    }

    @RequestMapping(value = "/albums", params = "year", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Album>> getAlbumByYear(@RequestParam("year") Optional<Integer> year) {
        List<Album> albumList = recordShopService.getAlbumsByYear(year);
        return new ResponseEntity<>(albumList, HttpStatus.OK);
    }

    @RequestMapping(value = "/albums", params = "title", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Album>> getAlbumByTitle(@RequestParam("title") Optional<String> title) {
        List<Album> albumList = recordShopService.getAlbumsByTitle(title);
        return new ResponseEntity<>(albumList, HttpStatus.OK);
    }

    @RequestMapping(value = "/albums", params = "genre", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Album>> getAlbumByGenre(@RequestParam("genre") Optional<Genre> genre) {
        List<Album> albumList = recordShopService.getAlbumsByGenre(genre);
        return new ResponseEntity<>(albumList, HttpStatus.OK);
    }

    @RequestMapping(value = "/albums/{albumId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Album> getAlbumById(@PathVariable Long albumId) {
        Album albumList = recordShopService.getAlbumById(albumId);
        return new ResponseEntity<>(albumList, HttpStatus.OK);
    }

    @PutMapping(value = "/albums/{albumId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Album> updateAlbumById(@PathVariable("albumId") Long albumId, @RequestBody Album album) {
        recordShopService.updateAlbumById(albumId, album);
        return new ResponseEntity<>(recordShopService.getAlbumById(albumId), HttpStatus.OK);
    }

    @RequestMapping(value = "/albums/byparams", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Album>> getAlbumById(@RequestParam("year") Optional<Integer> year,
                                                    @RequestParam("title") Optional<String> title,
                                                    @RequestParam("genre") Optional<Genre> genre,
                                                    @RequestParam("artist") Optional<String> artist) {
        List<Album> albumList = recordShopService.getAlbumsByYearOrTitleOrGenreOrArtist(year, title, genre, artist);
        return new ResponseEntity<>(albumList, HttpStatus.OK);
    }

    // this is a new comment
}
