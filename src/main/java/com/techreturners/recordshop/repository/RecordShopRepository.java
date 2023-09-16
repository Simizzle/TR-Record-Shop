package com.techreturners.recordshop.repository;

import com.techreturners.recordshop.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface RecordShopRepository extends CrudRepository<Album, Long> {
}
