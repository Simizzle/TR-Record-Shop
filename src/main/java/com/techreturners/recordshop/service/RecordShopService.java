package com.techreturners.recordshop.service;

import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.model.Genre;

import java.util.List;

public interface RecordShopService {

    List<Album> getAllAlbums();

    Album insertAlbum(Album album);

    List<Album> getAlbumsByTitle(String title);

    List<Album> getAlbumsByYear(int year);

    List<Album> getAlbumsByArtist(String artistName);

    List<Album> getAlbumsByGenre(Genre genre);

    void updateAlbumById(Long id, Album album);

    void updateStockForAlbum(Album album);

    void deleteAlbumById(Long id);

    Album getAlbumById(Long albumId);

}
