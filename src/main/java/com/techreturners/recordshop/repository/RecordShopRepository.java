package com.techreturners.recordshop.repository;

import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordShopRepository extends JpaRepository<Album, Long> {

    List<Album> findAllAlbumsByArtist(String artist);

    List<Album> findAllAlbumsByYear(int year);

    List<Album> findAllAlbumsByTitle(String title);

    List<Album> findAllAlbumsByGenre(Genre genre);

    Album findAlbumById(Long albumId);

}
