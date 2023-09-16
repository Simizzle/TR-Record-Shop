package com.techreturners.recordshop.service;

import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.model.Genre;
import com.techreturners.recordshop.repository.RecordShopRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RecordShopServiceImpl implements RecordShopService {

    @Autowired
    RecordShopRepository recordShopRepository;

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        recordShopRepository.findAll().forEach(albums::add);
        return albums;
    }

    @Override
    public Album insertAlbum(Album album) {
        return null;
    }

    @Override
    public Album getAlbumByTitle(String title) {
        return null;
    }

    @Override
    public List<Album> getAlbumsByYear(int year) {
        return null;
    }

    @Override
    public List<Album> getAlbumsByArtist(String artist) {
        return null;
    }

    @Override
    public List<Album> getAlbumsByGenre(Genre genre) {
        return null;
    }

    @Override
    public void updateAlbumByTitle(String title, Album album) {

    }

    @Override
    public void updateStockForAlbum(Album album) {

    }

    @Override
    public void deleteAlbumById(Long id) {

    }
}
