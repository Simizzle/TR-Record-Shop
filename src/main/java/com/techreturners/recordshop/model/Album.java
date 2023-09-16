package com.techreturners.recordshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column
    private String title;
    @Column
    private Genre genre;
    @Column
    private int year;

    @Column
    private String label;
    @Column
    private List<Format> format;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_name")
    private Artist artist;

}
