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
    public List<Album> getAlbumsByTitle(String title) {
        return recordShopRepository.findAllAlbumsByTitle(title);
    }

    @Override
    public List<Album> getAlbumsByYear(int year) {
        return recordShopRepository.findAllAlbumsByYear(year);
    }

    @Override
    public List<Album> getAlbumsByArtist(String artist) {
        return recordShopRepository.findAllAlbumsByArtist(artist);
    }

    @Override
    public List<Album> getAlbumsByGenre(Genre genre) {
        return recordShopRepository.findAllAlbumsByGenre(genre);
    }

    @Override
    public void updateAlbumById(Long id, Album album) {
        Album retrievedAlbum = recordShopRepository.findAlbumById(id);
        retrievedAlbum.setArtist(album.getArtist());
        retrievedAlbum.setGenre(album.getGenre());
        retrievedAlbum.setFormat(album.getFormat());
        retrievedAlbum.setTitle(album.getTitle());
        retrievedAlbum.setYear(album.getYear());
        retrievedAlbum.setLabel(album.getLabel());

        recordShopRepository.save(retrievedAlbum);
    }

    @Override
    public void updateStockForAlbum(Album album) {

    }

    @Override
    public void deleteAlbumById(Long id) {

    }

    @Override
    public Album getAlbumById(Long albumId) {
        return recordShopRepository.findAlbumById(albumId);
    }

}
