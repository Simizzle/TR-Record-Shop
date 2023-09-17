package com.techreturners.recordshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column
    private String artistName;
    @Column
    private String altName;

    public Long getId() {
        return id;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAltName() {
        return altName;
    }
}
