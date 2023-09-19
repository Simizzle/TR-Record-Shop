package com.techreturners.recordshop.service;

import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.model.Genre;
import com.techreturners.recordshop.repository.RecordShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<Album> getAlbumsByTitle(Optional<String> title) {
        return recordShopRepository.findAllAlbumsByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Album> getAlbumsByYear(Optional<Integer> year) {
        return recordShopRepository.findAllAlbumsByYear(year);
    }

    @Override
    public List<Album> getAlbumsByArtist(Optional<String> artist) {
        return recordShopRepository.findAllAlbumsByArtistContainingIgnoreCase(artist);
    }

    @Override
    public List<Album> getAlbumsByGenre(Optional<Genre> genre) {
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

    @Override
    public List<Album> getAlbumsByYearOrTitleOrGenreOrArtist(Optional<Integer> year, Optional<String> title, Optional<Genre> genre, Optional<String> artist) {
        return recordShopRepository.findAllAlbumsByYearOrTitleOrGenreOrArtistContainingIgnoreCase(year, title, genre, artist);
    }

}
