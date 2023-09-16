package com.techreturners.recordshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
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
    @ManyToOne
    @JoinColumn(name = "artist_name", nullable = false)
    private Artist artist;

}
