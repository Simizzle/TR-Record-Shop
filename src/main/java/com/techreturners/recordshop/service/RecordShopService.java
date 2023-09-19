package com.techreturners.recordshop.service;

import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.model.Genre;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RecordShopService {

    List<Album> getAllAlbums();

    Album insertAlbum(Album album);

    List<Album> getAlbumsByTitle(Optional<String> title);

    List<Album> getAlbumsByYear(Optional<Integer> year);

    List<Album> getAlbumsByArtist(Optional<String> artistName);

    List<Album> getAlbumsByGenre(Optional<Genre> genre);

    void updateAlbumById(Long id, Album album);

    void updateStockForAlbum(Album album);

    void deleteAlbumById(Long id);

    Album getAlbumById(Long albumId);

    List<Album> getAlbumsByYearOrTitleOrGenreOrArtist(Optional<Integer> year, Optional<String> title, Optional<Genre> genre, Optional<String> artist);

}
