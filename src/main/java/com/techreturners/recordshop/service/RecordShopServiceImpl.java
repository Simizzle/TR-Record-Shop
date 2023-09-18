package com.techreturners.recordshop.service;

import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.model.Genre;
import com.techreturners.recordshop.repository.RecordShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordShopServiceImpl implements RecordShopService {

    @Autowired
    RecordShopRepository recordShopRepository;

    @Override
    public List<Album> getAllAlbums() {
        return new ArrayList<>(recordShopRepository.findAll());
    }

    @Override
    public Album insertAlbum(Album album) {
        return recordShopRepository.save(album);
    }

    @Override
    public List<Album> getAlbumByTitle(String title) {
        return null;
    }

    @Override
    public List<Album> getAlbumsByYear(int year) {
        return null;
    }

    @Override
    public List<Album> getAlbumsByArtist(String artistName) {
        return recordShopRepository.findAllAlbumsByArtist(artistName);
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
