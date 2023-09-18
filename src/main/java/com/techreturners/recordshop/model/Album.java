package com.techreturners.recordshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column
    private String artist;
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

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "artist_id")
//    private Artist artist;


    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", year=" + year +
                ", label='" + label + '\'' +
                ", format=" + format +
                '}';
    }
}
