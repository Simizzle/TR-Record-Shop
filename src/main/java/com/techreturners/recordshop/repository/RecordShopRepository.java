package com.techreturners.recordshop.repository;

import com.techreturners.recordshop.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordShopRepository extends JpaRepository<Album, Long> {

    List<Album> findAllAlbumsByArtist(String artist);
}
