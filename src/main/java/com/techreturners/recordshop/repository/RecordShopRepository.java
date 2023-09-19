package com.techreturners.recordshop.repository;

import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordShopRepository extends JpaRepository<Album, Long> {

    List<Album> findAllAlbumsByArtistContainingIgnoreCase(Optional<String> artist);

    List<Album> findAllAlbumsByYear(Optional<Integer> year);

    List<Album> findAllAlbumsByTitleContainingIgnoreCase(Optional<String> title);

    List<Album> findAllAlbumsByGenre(Optional<Genre> genre);

    List<Album> findAllAlbumsByYearOrTitleOrGenreOrArtistContainingIgnoreCase(Optional<Integer> year, Optional<String> title, Optional<Genre> genre, Optional<String> artist);

    Album findAlbumById(Long albumId);

}
